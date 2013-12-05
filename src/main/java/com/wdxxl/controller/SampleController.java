package com.wdxxl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wdxxl.form.User;
import com.wdxxl.service.ISampleService;

@Controller
public class SampleController {
	@Autowired
	private ISampleService sampleService;

	/**
	 * http://localhost:9090/webApp/samplesModelAndView1
	 * 
	 * @return
	 */
	@RequestMapping("/samplesModelAndView1")
	public ModelAndView goToSamplesModelAndView1(){
		sampleService.printSample();
		ModelAndView modelAndView = new ModelAndView("samplesModelAndView");
		modelAndView.addObject("msg", "samplesModelAndView1");
		return modelAndView;
	}
	
	/**
	 * @RequestParam
	 * 
	 * http://localhost:9090/webApp/samplesModelAndView2
	 *	 HTTP Status 400 - Required Long parameter 'state' is not present
	 * http://localhost:9090/webApp/samplesModelAndView2?state=s
	 *	 HTTP Status 400 - 
	 * http://localhost:9090/webApp/samplesModelAndView2?state=1
	 * 	POSTMAN POST access
	 * 	HTTP Status 405 - Request method 'POST' not supported
	 * 
	 * @return
	 */
	@RequestMapping(value="/samplesModelAndView2", method=RequestMethod.GET)
	public ModelAndView goToSamplesModelAndView2(
			@RequestParam(value="state", required = true) Long state,
			@RequestParam(value="zip", required = false, defaultValue="") String zipcode){
		ModelAndView modelAndView = new ModelAndView("samplesModelAndView");
		modelAndView.addObject("msg", "samplesModelAndView2");
		return modelAndView;
	}

	/**
	 * @PathVariable
	 * method={RequestMethod.GET, RequestMethod.POST} Both of the RequestMethod are OK.
	 * 
	 * http://localhost:9090/webApp/samplesModelAndView3
	 *	 HTTP Status 404 - /webApp/samplesModelAndView3
	 * http://localhost:9090/webApp/samplesModelAndView3/1/s
	 *	 OK
	 * http://localhost:9090/webApp/samplesModelAndView3/s/s
	 *	 HTTP Status 400 -
	 * 
	 * @return
	 */
	@RequestMapping(value="/samplesModelAndView3/{id}/{str}", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView goToSamplesModelAndView3(
			@PathVariable Long id, 
			@PathVariable String str){
		ModelAndView modelAndView = new ModelAndView("samplesModelAndView");
		modelAndView.addObject("msg", "samplesModelAndView3_id:_"+id+"_str:_"+str);
		return modelAndView;
	}
	
	/**
	 * http://localhost:9090/webApp/responseBodys
	 * 
	 * return "responseBodys" as ResponseBody just the string value.
	 * May great to used as AJAX call, after operation return some more messages.
	 *   
	 * TODO this response body may used to set type,like XML or JSON
	 * @return
	 */
	@RequestMapping("/responseBodys")
	@ResponseBody
	public String getResponseBodys(){
		return "responseBodys";
	}
	
	/**
	 * http://localhost:9090/webApp/samplesString
	 * 
	 * URL= prefix + center + suffix
	 * Page found: /webApp/WEB-INF/views/samplesString.jsp
	 * Please refer to spring-mvc-servlet.xml
	 * @return
	 */
	@RequestMapping("/samplesString")
	public String goToSamplesString(Model model){
		//TODO
		System.out.println("samplesString");
		model.addAttribute("msg", "samplesString");
		return "samplesString";
	}
	
	/**
	 * http://localhost:9090/webApp/samplesStringRedirect
	 * URL address will also changed
	 * Redirect-- after run this controller it will can "samplesString" once more
	 * 
	 * TODO Test the request will continued...
	 * 
	 * redirect good at after check login then redirect to the page where you come from.
	 * @return
	 */
	@RequestMapping("/samplesStringRedirect")
	public String goToSamplesStringRedirect(){
		//TODO
		System.out.println("samplesStringRedirect");
		return "redirect:samplesString";
	}
	
	/**
	 * http://localhost:9090/webApp/samplesVoid
	 * 
	 * URL= prefix + center + suffix
	 * Page found: /webApp/WEB-INF/views/samplesVoid.jsp
	 * Please refer to spring-mvc-servlet.xml
	 */
	@RequestMapping("/samplesVoid")  
	public void goToSamplesVoid(Model model) {
		model.addAttribute("msg","samplesVoid");
		//TODO  samples Void
	}
	
	/**
	 * http://localhost:9090/webApp/samplesModel
	 * URL= prefix + center + suffix
	 * Page found: /webApp/WEB-INF/views/samplesModel.jsp
	 * 
	 * Also can display the model message. ${msg}
	 * TODO: this ${} may not need JSTL. please check the jsp page 
	 * @param model
	 * @return
	 */
	@RequestMapping("/samplesModel")  
	public Model goToSamplesModel(Model model) {
		//TODO
		model.addAttribute("msg","samplesModel");
		return model;
	}
	
	/**
	 * http://localhost:9090/webApp/showCreateUser
	 * USE ModelAndView to build an empty User
	 * 
	 * If not add an user Model to page 
	 * 	//modelAndView.addObject("user", new User());
	 * 	HTTP Status 500 - An exception occurred processing JSP page /WEB-INF/views/createUser.jsp at line 11
	 * 
	 * @return
	 */
	@RequestMapping("/showCreateUser") 
	public ModelAndView showCreateUser(){
		ModelAndView modelAndView = new ModelAndView("createUser");
		modelAndView.addObject("user", new User("haha",1L));
		return modelAndView;
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/createUser", method=RequestMethod.POST)  
	@ResponseBody
	public String createUser(User user){
		return "SUCCESS"+user.toString();
	}
	
}
