package com.nagarro.skyscanner.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author satyamsetia
 *@description Controller for handling logout.
 */
@Controller
public class LogoutController {
	
	@RequestMapping(value="/logout")  
    public ModelAndView logout(HttpServletRequest request){
		request.getSession().invalidate();
		return new ModelAndView("index");
    }
}
