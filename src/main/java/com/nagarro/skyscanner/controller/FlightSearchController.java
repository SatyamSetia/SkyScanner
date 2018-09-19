package com.nagarro.skyscanner.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.skyscanner.dto.FlightSearchCriteria;
import com.nagarro.skyscanner.model.Flight;
import com.nagarro.skyscanner.service.FlightService;

/**
 * @author satyamsetia
 * @description Controller for handling flight search request.
 *
 */
@Controller
public class FlightSearchController {
	
	@Autowired
	FlightService flightService;
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public ModelAndView createUser(@ModelAttribute("search") FlightSearchCriteria searchCriteria) {
				
		if(!flightService.validateSearchCriteria(searchCriteria)) {
			System.out.println("invalid inputs");
			return new ModelAndView("profile");
		}
		Flight flight = new Flight();
		flight.setDeparture(searchCriteria.getDeparture().toUpperCase());
		flight.setArrival(searchCriteria.getArrival().toUpperCase());
		flight.setFlightClass(searchCriteria.getTravelClass());
		flight.setFlightClass(searchCriteria.getTravelClass());
		List<Flight> flights = flightService.searchFlights(flight,searchCriteria.getSortOrder(),searchCriteria.getTravelDate());
		ModelAndView mav = new ModelAndView();
		mav.addObject("flights", flights);
		mav.addObject("searchCriteria",searchCriteria);
		String status = "We found "+flights.size()+" flights from "+searchCriteria.getDeparture()+" to "+searchCriteria.getArrival()+" on "+searchCriteria.getTravelDate();
		mav.addObject("message", status);
		mav.setViewName("profile");
		return mav;		
	}

}
