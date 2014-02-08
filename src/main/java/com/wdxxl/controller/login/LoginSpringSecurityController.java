package com.wdxxl.controller.login;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wdxxl.service.IAppUserService;

@Controller
@RequestMapping(value="/springSecurity")
public class LoginSpringSecurityController {
	private static Logger logger =  LoggerFactory.getLogger(LoginSpringSecurityController.class);

	@Autowired
	private IAppUserService appUserService;
	
	@RequestMapping(value="/welcome", method=RequestMethod.POST)
	public String welcome(HttpServletRequest httpRequest, 
			HttpServletResponse httpResponse){
		
		return "redirect:bootstrap/welcome";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView login(ModelMap model) {
		logger.debug("login loginSpringSecurity.");
		
		ModelAndView modelAndView = new ModelAndView("bootstrap/loginSpringSecurity");
		return modelAndView;
	}
 
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		logger.debug("loginfailed loginSpringSecurity.");
		model.addAttribute("error", "true");
		return "bootstrap/loginSpringSecurity";
	}
 
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		logger.debug("logout loginSpringSecurity.");
		
		return "bootstrap/loginSpringSecurity";
	}
 
}
