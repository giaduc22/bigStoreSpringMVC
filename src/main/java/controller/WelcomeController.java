package controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.ProductCategoryDAO;
import dao.ProductDAO;
import dao.UserDAO;
import entity.Product;

@Controller
@RequestMapping("/")
public class WelcomeController {
	@Autowired
	ProductCategoryDAO productCategoryDAO;
	@Autowired
	ProductDAO productDAO;
	@Autowired
	UserDAO userDAO;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(Model model, @RequestParam(required = false) Integer category,
			@RequestParam(required = false) Integer page, HttpServletResponse response) {

		return "products";
	}

	@RequestMapping(value = "item", method = RequestMethod.GET)
	public String onItemClick(Model model, @RequestParam Integer id) {
		List<Product> product = productDAO.getProductById(id);
		model.addAttribute("product", product);

		return "item";
	}

	@RequestMapping(value = "cart")
	public String cart() {
		return "user/cart";
	}

}
