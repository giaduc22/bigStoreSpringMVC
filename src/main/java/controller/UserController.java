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

import entity.User;

@Transactional
@Controller
@RequestMapping("/user/")
public class UserController {

	@Autowired
	SessionFactory sessionFactory;

	@RequestMapping("index")
	public String index(ModelMap modelMap) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from User";
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		modelMap.addAttribute("users", list);
		return "user/index";
	}

}
