package com.wdxxl.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginFilter implements Filter {
	
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException{
		//Do Some Validation
		System.out.println("LoginFilter doFilter.");
		//If Already Login then Continue Else return Exception or sendRedirect or forword
		chain.doFilter(request, response);
	}

	public void destroy() {
		
	}

}
