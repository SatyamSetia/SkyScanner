package com.nagarro.skyscanner.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.skyscanner.dao.impl.FlightDaoImpl;
import com.nagarro.skyscanner.dto.FlightSearchCriteria;
import com.nagarro.skyscanner.model.Flight;

@Service
public class FlightService {
	
	@Autowired
	FlightDaoImpl flightDao;
	
	public boolean validateSearchCriteria(FlightSearchCriteria inputs) {
		boolean locationFlag = inputs.getDeparture().length()==3 && inputs.getArrival().length()==3;
		boolean travelClassFlag = inputs.getTravelClass().equals("Economy") || inputs.getTravelClass().equals("Business");
		boolean sortingFlag = inputs.getSortOrder().equals("byFare") || inputs.getSortOrder().equals("byBoth");
		return locationFlag && travelClassFlag && sortingFlag;
	}
	
	public ArrayList<Flight> searchFlights(Flight flight, String orderBy, String travelDate) {
		return flightDao.getFlights(flight,orderBy, travelDate);
	}

}
