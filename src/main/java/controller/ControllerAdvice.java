package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import dao.CategoryDAO;
import dao.ProductDAO;
import entity.Product;
import entity.Category;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	ProductDAO productDAO;

	@ModelAttribute
	public void getAllProductCategory(Model model) {
		List<Category> categories = categoryDAO.getAllCategory();
		model.addAttribute("productCategories", categories);
	}

	@ModelAttribute
	public void getAllProduct(Model model) {
		List<Product> products = productDAO.getAllProduct();
		model.addAttribute("products", products);
	}

}
