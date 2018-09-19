package com.nagarro.skyscanner.dao;

import java.util.ArrayList;

import com.nagarro.skyscanner.model.Flight;

public interface FlightDao {
	
	ArrayList<Flight> getFlights(Flight flight, String orderBy, String travelDate);

}
