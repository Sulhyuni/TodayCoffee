package com.today.error.controller;

import javax.servlet.http.HttpServletRequest;

public class ErrorController  {

	public String execute(HttpServletRequest request) throws Exception{
		System.out.println("ErrorController.execute().request : " + request);
		String uri = request.getRequestURI();
		String jsp = null;
		switch(uri) {
		case"/error/500.do": 
			jsp = "error/500"; 
			break;
		case"/error/404.do": 
			jsp = "error/404"; 
			break;
		case"/error/loginError.do": 
			jsp = "error/loginError"; 
			break;
		case"/error/authError.do": 
			jsp = "error/authError";
			break;
		default:
			jsp = "redirect:/error/404.do";
			request.getSession().setAttribute("uri", uri);
		}
		return jsp;
	} // end of execute()
} // end of class