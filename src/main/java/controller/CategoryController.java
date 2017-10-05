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

import dao.CategoryDAO;
import entity.Category;

@Controller
public class CategoryController {
	@Autowired
	CategoryDAO categoryDAO;

	@GetMapping("category_manager")
	public String categoryManager() {
		return "admin/category_manager";
	}

	@GetMapping("add_category")
	public String addCategory() {
		return "admin/add_category";
	}

	@PostMapping("add_category")
	public String addCategory(@Validated @ModelAttribute("productCategory") Category category,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "admin/add_category";
		} else {
			categoryDAO.addCategory(category);
			return "redirect:/category_manager.html";
		}

	}

	@GetMapping("edit_category")
	public String updateCategory(Model model, @RequestParam Integer id) {
		Category category = categoryDAO.getCategoryById(id);
		model.addAttribute("productCategory", category);
		return "admin/edit_category";
	}

	@PostMapping("update_category")
	public String updateCategory(@Validated @ModelAttribute("productCategory") Category category,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "admin/edit_category";
		} else {
			categoryDAO.updateCategory(category);
			return "redirect:/category_manager.html";
		}

	}

	@GetMapping("delete_category")
	public String removeCategory(@RequestParam int id) {
		Category category = new Category();
		category.setId(id);
		categoryDAO.removeCategory(category);
		return "redirect:/category_manager.html";

	}

}
