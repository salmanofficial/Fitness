package com.gms.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(GMSException.class)
	String showGMsErrors(HttpServletRequest request){
		request.setAttribute("error", "GMSException");
		return "errorPage";
	}
	@ExceptionHandler(Exception.class)
	String redirectToErrorPage(ModelMap model){
		model.addAttribute("error", "Please Contact Site Admin");
		return "errorPage";
	}

}
