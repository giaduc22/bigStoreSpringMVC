package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import dao.ProductCategoryDAO;
import dao.ProductDAO;
import dao.UserDAO;
import entity.Product;
import entity.ProductCategory;
import entity.User;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
	@Autowired
	ProductCategoryDAO productCategoryDAO;
	@Autowired
	ProductDAO productDAO;
	@Autowired
	UserDAO userDAO;

	@ModelAttribute
	public void getAllProductCategory(Model model) {
		List<ProductCategory> productCategories = productCategoryDAO.getAllProductCategory();
		model.addAttribute("productCategories", productCategories);
	}

	@ModelAttribute
	public void getAllProduct(Model model) {
		List<Product> products = productDAO.getProducts();
		model.addAttribute("products", products);
	}

	@ModelAttribute
	public void getAllUser(Model model) {
		List<User> users = userDAO.getAllUser();
		model.addAttribute("users", users);
	}

}
