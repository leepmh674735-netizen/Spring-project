package com.apress.spring;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import jakarta.servlet.http.HttpServletRequest;

public class SimpleController extends AbstractController {
	
	@Override
	protected ModelAndView handleRequsetInternal (HttpServletRequest request,)
	      HttpServletResponse response) throws Exception {
	    	  
	    	  ModelAndView model = new ModelAndView("showMessage");
	    	  model.addObject("message", "스프링 MVC Have you ever tired that before? ");
	    	  
	    	  return model;
	  }

}