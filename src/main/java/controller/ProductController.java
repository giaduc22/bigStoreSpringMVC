package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.ProductDAO;

@Controller
public class ProductController {

	@Autowired
	ProductDAO productDAO;

	@RequestMapping(value = "product_manager", method = RequestMethod.GET)
	public String productManager() {
		return "admin/product_manager";
	}

	@RequestMapping(value = "add_product", method = RequestMethod.POST)
	public String addProduct(@RequestParam String name, @RequestParam Integer product_category,
			@RequestParam String image, @RequestParam String description, @RequestParam Double price) {
		if (productDAO.addProduct(name, product_category, image, description, price)) {
			System.out.println("okay");
		} else {
			System.out.println("not okay!!!");
		}

		return "redirect:/product_manager.html";
	}

	@RequestMapping(value = "update_product", method = RequestMethod.POST)
	public String updateProductCategory(@RequestParam Integer id, @RequestParam String name,
			@RequestParam Integer product_category, @RequestParam String image, @RequestParam String description,
			@RequestParam Double price) {
		if (productDAO.updateProduct(id, name, product_category, image, description, price)) {
			System.out.println("okay!!!");
			return "redirect:/product_manager.html";
		} else {
			System.out.println("not Okay!!!");
			return "redirect:/product_manager.html";
		}
	}

	@RequestMapping(value = "delete_product", method = RequestMethod.GET)
	public String removeProductCategory(@RequestParam Integer id) {
		if (productDAO.removeProduct(id)) {
			return "redirect:/product_manager.html";
		} else {
			return "redirect:/product_manager.html";
		}

	}
}
