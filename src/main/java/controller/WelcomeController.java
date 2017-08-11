package controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Product;
import entity.ProductCategory;
import entity.User;
import service.ProductCategoryService;

@Controller
// @Transactional
@RequestMapping("/")
public class WelcomeController {
	@Autowired(required=true)
	ProductCategoryService productCategoryService;

	// SessionFactory sessionFactory;

	@RequestMapping(value = "index")
	public String index(Model model) {
		// Session session = sessionFactory.getCurrentSession();

		List<ProductCategory> productCategories = productCategoryService.getAllProductCategory();
		model.addAttribute("productCategories", productCategories);

		// List<ProductCategory> productCategories = session.createQuery("from
		// ProductCategory").list();
		// model.addAttribute("productCategories", productCategories);

		// List<Product> products = session.createQuery("from Product").list();
		// model.addAttribute("products", products);

		return "index";
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

	@RequestMapping(value = "item")
	public String onItemClick() {
		return "item";
	}

}
