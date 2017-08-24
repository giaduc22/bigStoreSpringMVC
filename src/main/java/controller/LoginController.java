package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.UserDAO;

@Controller
public class LoginController {

	@Autowired
	UserDAO UserDAO;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "user/login";
	}

	// @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	// public ModelAndView loginProcess(HttpServletRequest request,
	// HttpServletResponse response,
	// @ModelAttribute("login") Login login) {
	// ModelAndView mav = null;
	// User user = UserDAO.auth(login);
	// if (null != user) {
	// mav = new ModelAndView("welcome");
	// mav.addObject("firstname", user.getUsername());
	// } else {
	// mav = new ModelAndView("login");
	// mav.addObject("message", "Username or Password is wrong!!");
	// }
	// return mav;
	// }

	// @RequestMapping( value="/loginfailed", method = RequestMethod.GET)
	// public String loginError(Model model){
	// model.addAttribute("error", "true");
	// return "login";
	// }
	//
	// @RequestMapping( value = "/logout", method = RequestMethod.GET)
	// public String logout(Model model){
	// return "login";
	// }
}
