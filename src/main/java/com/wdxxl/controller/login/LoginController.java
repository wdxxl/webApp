package com.wdxxl.controller.login;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wdxxl.model.AppUser;
import com.wdxxl.service.IAppUserService;
import com.wdxxl.utils.Constants;
import com.wdxxl.validator.AppUserValidator;

@Controller
public class LoginController {
	@Autowired
	private IAppUserService appUserService;

	@InitBinder  
    public void initBinder(DataBinder binder) {  
       binder.setValidator(new AppUserValidator());  
    }  
	
	@RequestMapping("/showLogin") 
	public ModelAndView showCreateUser(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("appUser", new AppUser());
		return modelAndView;
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(HttpServletRequest httpRequest, 
			HttpServletResponse httpResponse,
			@Validated AppUser appuser, BindingResult result){
		if(result.hasErrors()){
			System.out.println("result.hasErrors()");
			return "login";
		}else{
			if (!isUserExist(appuser.getLoginName(),httpRequest)) {
				return "redirect:showLogin";
			}else {
				return "redirect:bootstrap/welcome";
			}
		}
	}
	
	
	/**
	 * before add validator, use this function.
	 */
	@RequestMapping(value="/loginOld", method=RequestMethod.POST)
	public String loginOld(HttpServletRequest httpRequest, 
			HttpServletResponse httpResponse,
			@RequestParam(value="loginName" ,required=false) String loginName,
			@RequestParam(value="password" ,required=false) String password){
		if (!isUserExist(loginName,httpRequest)) {
			return "redirect:showLogin";
		}else {
			return "redirect:bootstrap/welcome";
		}
	}
	
	
	/**
	 * Identify whether we have the user with the passed loginName, will save the user into session if it does exist
	 * @param loginRequest
	 * @param request
	 * @return boolean
	 */
	boolean isUserExist(String loginName, HttpServletRequest request) {
		AppUser user = appUserService.getAppUserByLoginName(loginName);
		if (user != null) {
			String uuid = UUID.randomUUID().toString();
			request.getSession(true).setAttribute(Constants.TOKEN_KEY, uuid);
			//request.getSession(true)
			//true - to create a new session for this request if necessary; 
			//false to return null if there's no current session
			LoginedUsers.setUser(uuid, user);
			return true;
		} else {
			return false;
		}
	}
}
