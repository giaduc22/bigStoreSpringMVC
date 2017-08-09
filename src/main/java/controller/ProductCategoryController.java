package controller;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.ProductCategory;


@Transactional
@Controller
public class ProductCategoryController {

	@Autowired
	SessionFactory sessionFactory;

	public String index(ModelMap modelMap) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from ProductCategory";
		Query query = session.createQuery(hql);
		List<ProductCategory> list = query.list();
		modelMap.addAttribute("products", list);
		return "menu_bar";
	}
	

}
