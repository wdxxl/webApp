package com.wdxxl.controller.login;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wdxxl.domain.AppUser;
import com.wdxxl.service.IAppUserService;
import com.wdxxl.utils.Constants;
import com.wdxxl.validator.AppUserValidator;

@Controller
public class LoginController {
	private static Logger logger =  LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private IAppUserService appUserService;

	/**
	 * This function used for binding form. so add validate.
	 * @param binder
	 */
	@InitBinder
    public void initBinder(DataBinder binder) {  
		logger.debug("LoginController initBinder App User Validator.");
		binder.setValidator(new AppUserValidator());  
    }
	
	@RequestMapping("/showLogin") 
	public ModelAndView showCreateUser(HttpServletRequest request){
		logger.debug("LoginController Show LoginPage.");
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("appUser", new AppUser());//add empty model, and return to the login view.
		return modelAndView;
	}
	
	@RequestMapping("/showSpringSecurityLogin") 
	public ModelAndView showSpringSecurityLogin(HttpServletRequest request){
		logger.debug("LoginController Show showSpringSecurityLogin.");
		ModelAndView modelAndView = new ModelAndView("loginSpringSecurity");
		return modelAndView;
	}
	
	/**
	 * POST Login User Message, both time to use Spring Validator to validate the login user.
	 * BindingResult to check validation hasErrors or not��
	 * 
	 * @param httpRequest
	 * @param httpResponse
	 * @param appuser
	 * @param result
	 * @return
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(HttpServletRequest httpRequest, 
			HttpServletResponse httpResponse,
			@Validated AppUser appuser, 
			BindingResult result){
		
		if(result.hasErrors()){
			logger.debug("login validator return errors. return back to the login page.");
			return "login";
		}else{
			if (!isUserExist(appuser.getLoginName(),httpRequest)) {
				logger.debug("Login failure, Redirect to ShowLogin.");
				return "redirect:showLogin";
			}else {
				logger.debug("Login Success, Redirect to Welcome page.");
				
				/*
				return "bootstrap/welcome"; 
					//if use forward the URL address will not changed.
					//still in "http://localhost:9090/webApp/showLogin"
					//no session message.
				*/
				return "redirect:bootstrap/welcome";
				//http://localhost:9090/webApp/bootstrap/welcome;jsessionid=BF33928E5616EB26BF3BD075E00D52FC
			}
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
			logger.debug("User Existed��");
			String uuid = UUID.randomUUID().toString();
			request.getSession(true).setAttribute(Constants.TOKEN_KEY, uuid);
			//request.getSession(true)
			//true - to create a new session for this request if necessary; 
			//false - to return null if there's no current session
			LoginedUsers.setUser(uuid, user);
			return true;
		} else {
			return false;
		}
	}
}
