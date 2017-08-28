package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.ProductCategoryDAO;
import entity.ProductCategory;

@Controller
public class ProductCategoryController {
	@Autowired
	ProductCategoryDAO productCategoryDAO;

	
	@GetMapping("product_category_manager")
	public String productCategoryManager() {
		return "admin/product_category_manager";
	}

	@GetMapping("add_category")
	public String addCategory() {
		return "admin/add_category";
	}
	
	@PostMapping("add_product_category")
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

	
	@GetMapping("edit_category")
	public String update_Category(Model model, @RequestParam Integer id) {
		ProductCategory productCategory = productCategoryDAO.getCategoryById(id);
		model.addAttribute("productCategory", productCategory);
		return "admin/edit_category";
	}
	
	@PostMapping("update_product_category")
	public String updateProductCategory(@RequestParam int id, @RequestParam String name) {
		ProductCategory productCategory = new ProductCategory(name);
		productCategory.setId(id);
		productCategoryDAO.updateProductCategory(productCategory);
		return "redirect:/product_category_manager.html";
	}

	@GetMapping("delete_product_category")
	public String removeProductCategory(@RequestParam int id) {
		ProductCategory productCategory = new ProductCategory();
		productCategory.setId(id);
		productCategoryDAO.removeProductCategory(productCategory);
		return "redirect:/product_category_manager.html";

	}

}
