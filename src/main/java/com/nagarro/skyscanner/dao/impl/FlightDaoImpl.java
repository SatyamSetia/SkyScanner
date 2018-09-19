package com.nagarro.skyscanner.dao.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.nagarro.skyscanner.constant.HqlQueries;
import com.nagarro.skyscanner.dao.FlightDao;
import com.nagarro.skyscanner.model.Flight;
import com.nagarro.skyscanner.utils.HibernateUtils;


/**
 * @author satyamsetia
 * @description DAO for flight searching from database. 
 *
 */
public class FlightDaoImpl implements FlightDao {
	
	private Session session;

	public FlightDaoImpl() {
		this.session = HibernateUtils.createSession();
	}
	
	public ArrayList<Flight> getFlights(Flight flight, String orderBy, String travelDate) {
		LocalDate date = LocalDate.parse(travelDate);
		Query query = null;
		if(orderBy.equals("byFare")) {
			query = session.createQuery(HqlQueries.SELECT_FLIGHTS_FROM_TABLE_ORDERBY_FARE);
		} else {
			query = session.createQuery(HqlQueries.SELECT_FLIGHTS_FROM_TABLE_ORDERBY_BOTH);
		}
		query.setParameter("departure", flight.getDeparture());
		query.setParameter("arrival", flight.getArrival());
		query.setParameter("travelDate", date);
		List<Flight> flightList = query.getResultList();
		ArrayList<Flight> flights = new ArrayList<Flight>();
		if(flight.getFlightClass().equals("Business")) {
			for (Flight f : flightList) {
				if(f.getFlightClass().equals("EB")) {
					flights.add(f);	
				}
			}
		} else {
			flights = (ArrayList<Flight>) flightList;
		}
		return flights;
	}
}
