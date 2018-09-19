package com.nagarro.skyscanner.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.skyscanner.model.User;
import com.nagarro.skyscanner.service.UserService;

/**
 * @author satyamsetia
 * @description Controller for handling authentication.
 *
 */
@Controller
public class AuthenticationController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/",method = RequestMethod.GET)  
    public ModelAndView login(){  
       return new ModelAndView("index");  
    }

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("authenticate") User userBeforeValidation) {
		ModelAndView mav = null;
		User userAfterValidation = userService.validateUser(userBeforeValidation);
		if (userAfterValidation!=null) {
			mav = new ModelAndView("profile");
			mav.addObject("firstname", userAfterValidation.getUsername());
			HttpSession session = request.getSession(true);
			session.setAttribute("username", userAfterValidation.getUsername());
		} else {
			mav = new ModelAndView("index");
			mav.addObject("loginMessage", "Either Username or Password is wrong!!");
		}
		return mav;
	}

}
