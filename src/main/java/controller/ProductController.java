package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String addProduct(@Validated @ModelAttribute("product") Product product, BindingResult bindingResult) {
		// Product product = new Product(name, product_category, image,
		// description, price);
		// productDAO.addProduct(product);

		if (bindingResult.hasErrors()) {
			return "admin/add_product";
		} else {
			productDAO.addProduct(product);
			return "redirect:/product_manager.html";
		}

	}

	@GetMapping("edit_product")
	public String updateProduct(Model model, @RequestParam Integer id) {
		Product product = productDAO.getProductById(id);
		model.addAttribute("product", product);
		return "admin/edit_product";
	}

	@PostMapping("update_product")
	public String updateProduct(@Validated @ModelAttribute("product") Product product, BindingResult bindingResult) {
		// Product product = new Product(name, product_category, image,
		// description, price);
		// product.setId(id);
		if (bindingResult.hasErrors()) {
			return "admin/edit_product";
		} else {
			productDAO.updateProduct(product);
			return "redirect:/product_manager.html";
		}

	}

	@GetMapping("delete_product")
	public String removeProductCategory(@RequestParam Integer id) {
		Product product = new Product();
		product.setId(id);
		productDAO.removeProduct(product);
		return "redirect:/product_manager.html";

	}
}
