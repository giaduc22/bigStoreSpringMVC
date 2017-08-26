package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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

	@RequestMapping(value = "add_category", method = RequestMethod.GET)
	public String addCategory() {
		return "admin/add_category";
	}
	
	@RequestMapping(value = "add_product_category", method = RequestMethod.POST)
	public String addProductCategory(@RequestParam String name, @Validated ProductCategory category,
			BindingResult bindingResult) {
		// ProductCategory productCategory = new ProductCategory(name);
		// productCategoryDAO.addProductCategory(productCategory);
		if (bindingResult.hasErrors()) {
			System.out.println("Error!");
		} else {
			System.out.println("Okay!!");
		}

		return "redirect:/product_category_manager.html";
	}

	
	@RequestMapping(value = "edit_category", method = RequestMethod.GET)
	public String update_Category(Model model, @RequestParam Integer id) {
		ProductCategory productCategory = productCategoryDAO.getCategoryById(id);
		model.addAttribute("productCategory", productCategory);
		return "admin/edit_category";
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
