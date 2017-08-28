package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@GetMapping("index")
	public String index(Model model, @RequestParam(required = false) Integer category,
			@RequestParam(required = false) Integer page) {
		
		if (category == null && page == null) {
			model.addAttribute("products", productDAO.getAllProduct());
			model.addAttribute("pagination", productDAO.getLastPage());
		} else if (category == null && page != null) {
			productDAO.setPage(page);
			model.addAttribute("products", productDAO.getAllProduct());
			model.addAttribute("pagination", productDAO.getLastPage());
		} else if (category != null && page == null) {
			model.addAttribute("products", productDAO.getProductByCategory(category));
			model.addAttribute("pagination", productDAO.getLastPage());
		} else {
			productDAO.setPage(page);
			model.addAttribute("products", productDAO.getProductByCategory(category));
			model.addAttribute("pagination", productDAO.getLastPage());
		}

		return "products";
	}

	@GetMapping("item")
	public String onItemClick(Model model, @RequestParam Integer id) {
		Product product = productDAO.getProductById(id);
		model.addAttribute("product", product);
		return "item";
	}

}
