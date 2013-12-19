package com.wdxxl.filter;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wdxxl.controller.login.LoginedUsers;

/**
 * LoginFilter used to checking weather user was login.
 * if not or the session have been destroyed, 
 * redirect to login page, otherwise continue.
 * 
 * @author 
 *
 */
public class LoginFilter implements Filter {
	private static Logger logger  =  LoggerFactory.getLogger(LoginFilter.class );
	
	private Pattern allowedResources;
	
	private final static String resPattern_Default = ".*((login)|(showLogin)|(resources/)).*";
	
	public void init(FilterConfig filterConfig) throws ServletException {
		allowedResources = Pattern.compile(resPattern_Default);
	}
	
	/**
	 * login request, resources don't need to be filtered
	 * @param request
	 * @return boolean
	 */
	boolean isUrlNeedsFilter(HttpServletRequest request) {
		String uri = request.getRequestURI();
		return !allowedResources.matcher(uri).matches();
	}
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException{
		logger.debug("[IN] doFilter.");
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		boolean doContinue = true;
		if(isUrlNeedsFilter(httpServletRequest)){// used to check is /resources/ and /login and /showLogin or not
			if(LoginedUsers.getUser(httpServletRequest) == null){
				doContinue = false;
			}
		}
		
		if(doContinue == false){
			logger.debug("Redirect to showLogin Page¡£ URI info ({})", httpServletRequest.getRequestURI());
			HttpServletResponse httpServletResponse = (HttpServletResponse) response;
			httpServletResponse.sendRedirect(httpServletResponse.encodeRedirectURL(httpServletRequest.getContextPath() + "/showLogin"));
			return;
		}
		
		chain.doFilter(request, response);
	}

	public void destroy() {
		
	}

}
