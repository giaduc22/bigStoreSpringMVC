package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.ProductCategoryDAO;
import dao.ProductDAO;
import entity.Product;

@Controller
@RequestMapping("/")
public class WelcomeController {
	@Autowired
	ProductCategoryDAO productCategoryDAO;
	@Autowired
	ProductDAO productDAO;

	@RequestMapping(value = "index?{category}", method = RequestMethod.GET)
	public String index(Model model, @PathVariable("category") String category, HttpServletRequest request,
			HttpServletResponse response) {

		String req = request.getParameter("category");
		List<Product> products = new ArrayList<Product>();

		if (req == null) {
			products = productDAO.getAllProduct();
		} else {
			products = productDAO.getProductByCategory(Integer.parseInt(req));
		}

		model.addAttribute("products", products);

		return "products";
	}

	@RequestMapping(value = "item?{id}", method = RequestMethod.GET)
	public String onItemClick(Model model, @PathVariable("id") String id, HttpServletRequest request) {
		String req = request.getParameter("id");

		List<Product> product = productDAO.getProductById(Integer.parseInt(req));
		model.addAttribute("product", product);

		return "item";
	}

	@RequestMapping(value = "login")
	public String login() {
		return "login";		
	}

	@RequestMapping(value = "cart")
	public String cart() {
		productCategoryDAO.removeProductCategory(5);
		return "cart";
	}

	

	

	@RequestMapping(value = "user_manager")
	public String userManager() {
		return "admin/user_manager";
	}

}
