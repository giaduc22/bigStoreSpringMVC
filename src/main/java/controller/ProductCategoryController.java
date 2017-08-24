package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.ProductCategoryDAO;
import entity.ProductCategory;

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
		ProductCategory productCategory = new ProductCategory(name);
		productCategoryDAO.addProductCategory(productCategory);
		return "redirect:/product_category_manager.html";
	}

	@RequestMapping(value = "update_product_category", method = RequestMethod.POST)
	public String updateProductCategory(@RequestParam int id, @RequestParam String name) {
		ProductCategory productCategory = new ProductCategory(name);
		productCategory.setId(id);
		productCategoryDAO.updateProductCategory(productCategory);
		return "redirect:/product_category_manager.html";
	}

	@RequestMapping(value = "delete_product_category", method = RequestMethod.GET)
	public String removeProductCategory(@RequestParam int id) {
		ProductCategory productCategory = new ProductCategory();
		productCategory.setId(id);
		productCategoryDAO.removeProductCategory(productCategory);
		return "redirect:/product_category_manager.html";

	}

}
