package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.ProductCategoryDAO;

@Controller
public class ProductCategoryController {
	@Autowired
	ProductCategoryDAO productCategoryDAO;

	@RequestMapping(value = "product_category_manager", method = RequestMethod.GET)
	public String productCategoryManager() {
		return "admin/product_category_manager";
	}

	@RequestMapping(value = "add_product_category", method = RequestMethod.POST)
	public String addProductCategory(@RequestParam String name) {
		if (productCategoryDAO.addProductCategory(name)) {

		} else {

		}
		return "redirect:/product_category_manager.html";
	}
	
	@RequestMapping(value = "update_product_category", method = RequestMethod.POST)
	public String updateProductCategory(@RequestParam int id, @RequestParam String name) {
		if (productCategoryDAO.updateProductCategory(id, name)) {
			return "redirect:/product_category_manager.html";
		} else {
			return "redirect:/product_category_manager.html";
		}

	}

	@RequestMapping(value = "delete_product_category", method = RequestMethod.GET)
	public String removeProductCategory(@RequestParam int id) {
		if (productCategoryDAO.removeProductCategory(id)) {
			return "redirect:/product_category_manager.html";
		} else {
			return "redirect:/product_category_manager.html";
		}

	}

	

}
