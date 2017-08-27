package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.ProductDAO;
import entity.Product;

@Controller
public class ProductController {

	@Autowired
	ProductDAO productDAO;

	@RequestMapping(value = "product_manager", method = RequestMethod.GET)
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

	@RequestMapping(value = "add_product", method = RequestMethod.GET)
	public String addProduct() {
		return "admin/add_product";
	}

	@RequestMapping(value = "add_product", method = RequestMethod.POST)
	public String addProduct(@RequestParam String name, @RequestParam Integer product_category,
			@RequestParam String image, @RequestParam String description, @RequestParam Double price) {
		Product product = new Product(name, product_category, image, description, price);
		productDAO.addProduct(product);

		return "redirect:/product_manager.html";
	}

	@RequestMapping(value = "edit_product", method = RequestMethod.GET)
	public String updateProduct(Model model, @RequestParam Integer id) {
		Product product = productDAO.getProductById(id);
		model.addAttribute("product", product);
		return "admin/edit_product";
	}
	
	@RequestMapping(value = "update_product", method = RequestMethod.POST)
	public String updateProduct(@RequestParam Integer id, @RequestParam String name,
			@RequestParam Integer product_category, @RequestParam String image, @RequestParam String description,
			@RequestParam Double price) {
		Product product = new Product(name, product_category, image, description, price);
		product.setId(id);
		productDAO.updateProduct(product);
		return "redirect:/product_manager.html";
	}

	@RequestMapping(value = "delete_product", method = RequestMethod.GET)
	public String removeProductCategory(@RequestParam Integer id) {
		Product product = new Product();
		product.setId(id);
		productDAO.removeProduct(product);
		return "redirect:/product_manager.html";

	}
}
