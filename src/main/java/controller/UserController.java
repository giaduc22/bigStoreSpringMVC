package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.UserDAO;


@Controller
public class UserController {

	@Autowired
	UserDAO userDAO;
	
	
	@RequestMapping(value = "user_manager", method = RequestMethod.GET)
	public String userManager() {
		return "admin/user_manager";
	}

}
