package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < productCategories.size(); i++) {
			Integer size = productDAO.getProductByCategory(productCategories.get(i).getId()).size();
			map.put(i, size);
		}
		model.addAttribute("productCategories", productCategories);
		model.addAttribute("size", map);
	}

	@ModelAttribute
	public void getAllProduct(Model model) {
		List<Product> products = productDAO.getAllProduct();
		model.addAttribute("products", products);
	}

	@ModelAttribute
	public void getAllUser(Model model) {
		List<User> users = userDAO.getAllUser();
		model.addAttribute("users", users);
	}

}
