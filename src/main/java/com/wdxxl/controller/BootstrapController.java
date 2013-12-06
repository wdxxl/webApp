package com.wdxxl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wdxxl.service.ISampleService;

@Controller
@RequestMapping(value="/bootstrap")
public class BootstrapController {
	@Autowired
	private ISampleService sampleService;

	/**
	 * http://localhost:9090/webApp/bootstrap/welcome
	 * 
	 * @return
	 */
	@RequestMapping("/welcome")
	public ModelAndView goToWelcome(){
		ModelAndView modelAndView = new ModelAndView("bootstrap/welcome");
		modelAndView.addObject("msg", "welcome");
		return modelAndView;
	}
	
}
