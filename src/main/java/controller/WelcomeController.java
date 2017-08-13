package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.ProductDAO;
import entity.Product;
import entity.ProductCategory;
import entity.User;
import service.ProductCategoryService;
import service.ProductService;

@Controller
@RequestMapping("/")
public class WelcomeController {
	@Autowired
	ProductCategoryService productCategoryService;
	@Autowired
	ProductService productService;

	@RequestMapping(value = "index?{category}", method = RequestMethod.GET)
	public String index(Model model, @PathVariable("category") String category, HttpServletRequest request,
			HttpServletResponse response) {
		List<ProductCategory> productCategories = productCategoryService.getAllProductCategory();
		model.addAttribute("productCategories", productCategories);

		String req = request.getParameter("category");

		List<Product> products = new ArrayList<Product>();
		if (req == null) {
			products = productService.getAllProduct();
		} else {
			products = productService.getProductByCategory(Integer.parseInt(req));
		}
		model.addAttribute("products", products);

		return "index";
	}

	// @RequestMapping(value = "index?{category}", method = RequestMethod.GET)
	// public String getProductByCategory(Model model, @PathVariable("category")
	// String category) {
	// List<ProductCategory> productCategories =
	// productCategoryService.getAllProductCategory();
	// model.addAttribute("productCategories", productCategories);
	//
	// List<Product> products = productService.getProductByCategory(2);
	// model.addAttribute("products", products);
	//
	// return "index";
	// }

	@RequestMapping(value = "item?{id}", method = RequestMethod.GET)
	public String onItemClick(Model model, @PathVariable("id") String id) {

		List<Product> product = productService.getProductById(new Integer(id));
		model.addAttribute("product", product);

		return "item";
	}

	@RequestMapping(value = "login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "cart")
	public String cart() {
		return "cart";
	}

	// @RequestMapping(value = "product_manager")
	// public String productManager(Model model) {
	// Session session = sessionFactory.getCurrentSession();
	// List<Product> products = session.createQuery("from Product").list();
	// model.addAttribute("products", products);
	// return "admin/product_manager";
	// }
	//
	// @RequestMapping(value = "product_category_manager")
	// public String productCategoryManager(Model model) {
	// Session session = sessionFactory.getCurrentSession();
	//
	// List<ProductCategory> productCategories = session.createQuery("from
	// ProductCategory").list();
	// model.addAttribute("productCategories", productCategories);
	// return "admin/product_category_manager";
	// }

	@RequestMapping(value = "user_manager")
	public String userManager() {
		return "admin/user_manager";
	}

}
