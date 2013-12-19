package com.wdxxl.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wdxxl.service.ISampleService;
import com.wdxxl.utils.Constants;

@Controller
@RequestMapping(value="/bootstrap")
public class BootstrapController {
	private static Logger logger  =  LoggerFactory.getLogger(BootstrapController.class );
	
	@Autowired
	private ISampleService sampleService;

	/**
	 * http://localhost:9090/webApp/bootstrap/welcome
	 * 
	 * @return
	 */
	@RequestMapping("/welcome")
	public ModelAndView goToWelcome(HttpServletRequest httpRequest, 
			HttpServletResponse httpResponse){
		logger.debug("[IN] goToWelcome.");
		String uuid = (String) httpRequest.getSession().getAttribute(Constants.TOKEN_KEY);
		logger.debug("uuid = "+uuid);
		
		ModelAndView modelAndView = new ModelAndView("bootstrap/welcome");
		modelAndView.addObject("msg", "welcome");

		logger.debug("[OUT] goToWelcome.");
		return modelAndView;
	}
	
}
