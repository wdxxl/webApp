package com.wdxxl.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wdxxl.controller.login.LoginedUsers;
import com.wdxxl.utils.Constants;

/**
 * this class used to checking Session Created and Session Destroyed.
 * 
 * 
 * this function is good to used to tracking how many session are currently active.
 * (but this httpSessionListener only checking session, not used to tracking user sign in or not.)
 * @author 
 *
 */
public class SessionListener implements HttpSessionListener {
	private static Logger logger  =  LoggerFactory.getLogger(SessionListener.class);

	public void sessionCreated(HttpSessionEvent httpSessionEvent) {
		ServletContext ctx = httpSessionEvent.getSession( ).getServletContext( );  
        Integer numSessions = (Integer) ctx.getAttribute("numSessions");  
        if (numSessions == null) {  
            numSessions = new Integer(1);  
        }  
        else {  
            int count = numSessions.intValue( );  
            numSessions = new Integer(count + 1);  
        }  
        ctx.setAttribute("numSessions", numSessions);  
		logger.debug("Session Created. Current NumSessions = "+numSessions);
	}

	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
		ServletContext ctx = httpSessionEvent.getSession().getServletContext();  
		Integer numSessions = (Integer)ctx.getAttribute("numSessions");  
		if(numSessions == null){
		   numSessions = new Integer(0);  
		}else{  
		  int count = numSessions.intValue( );  
		  numSessions = new Integer(count - 1);  
		}  
		ctx.setAttribute("numSessions", numSessions);
		logger.debug("Session Destroyed. Current NumSessions = "+numSessions);
		
		
		HttpSession session = httpSessionEvent.getSession();
		String uuid = (String) session.getAttribute(Constants.TOKEN_KEY);
		if (uuid != null) {
			LoginedUsers.removeUser(uuid);
		}
	}
}

