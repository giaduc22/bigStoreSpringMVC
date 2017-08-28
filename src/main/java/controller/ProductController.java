package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.ProductDAO;
import entity.Product;

@Controller
public class ProductController {

	@Autowired
	ProductDAO productDAO;

	@GetMapping("product_manager")
	public String productManager(Model model, @RequestParam(required = false) Integer page) {
		if (page != null) {
			productDAO.setPage(page);
			model.addAttribute("pagination", productDAO.getLastPage());
			model.addAttribute("products", productDAO.getAllProduct());
		} else {
			model.addAttribute("pagination", productDAO.getLastPage());
			model.addAttribute("products", productDAO.getAllProduct());
		}
				
		return "admin/product_manager";
	}

	@GetMapping("add_product")
	public String addProduct() {
		return "admin/add_product";
	}

	
	@PostMapping("add_product")
	public String addProduct(@RequestParam String name, @RequestParam Integer product_category,
			@RequestParam String image, @RequestParam String description, @RequestParam Double price) {
		Product product = new Product(name, product_category, image, description, price);
		productDAO.addProduct(product);

		return "redirect:/product_manager.html";
	}

	@GetMapping("edit_product")
	public String updateProduct(Model model, @RequestParam Integer id) {
		Product product = productDAO.getProductById(id);
		model.addAttribute("product", product);
		return "admin/edit_product";
	}
	
	@PostMapping("update_product")
	public String updateProduct(@RequestParam Integer id, @RequestParam String name,
			@RequestParam Integer product_category, @RequestParam String image, @RequestParam String description,
			@RequestParam Double price) {
		Product product = new Product(name, product_category, image, description, price);
		product.setId(id);
		productDAO.updateProduct(product);
		return "redirect:/product_manager.html";
	}

	@GetMapping("delete_product")
	public String removeProductCategory(@RequestParam Integer id) {
		Product product = new Product();
		product.setId(id);
		productDAO.removeProduct(product);
		return "redirect:/product_manager.html";

	}
}
