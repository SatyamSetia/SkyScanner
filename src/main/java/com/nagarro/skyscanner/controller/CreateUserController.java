package com.nagarro.skyscanner.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.skyscanner.dto.SignupUser;
import com.nagarro.skyscanner.model.User;
import com.nagarro.skyscanner.service.UserService;

/**
 * @author satyamsetia
 * @description Controller for handling registration process.
 *
 */
@Controller
public class CreateUserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView createUser(@ModelAttribute("register") SignupUser user) {
			
		ModelAndView mav = new ModelAndView("index");
		if(user.getPassword().equals(user.getConfirmPassword())) {
			User userBeforeCreation = new User();
			userBeforeCreation.setUsername(user.getUsername());
			userBeforeCreation.setPassword(user.getPassword());
			userService.registerUser(userBeforeCreation);
		} else {
			mav.addObject("signupMessage", "Passwords do not match, please try again.");
		}
		return mav;		
	}
	

}
