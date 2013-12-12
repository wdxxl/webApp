package com.wdxxl.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.wdxxl.model.AppUser;



public class AppUserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return AppUser.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmpty(errors, "loginName", null, "loginName cannot be null");
		AppUser appUser = (AppUser) obj;  
	       if (null == appUser.getPassword() || "".equals(appUser.getPassword()))  
	           errors.rejectValue("password", null, "Password is empty.");
	}

}
