package com.nagarro.skyscanner.constant;

/**
 * @author satyamsetia
 * @description HQL queries are defined here.
 *
 */
public class HqlQueries {

	private HqlQueries() {

	}

	public static final String SELECT_USER_FROM_TABLE = "FROM com.nagarro.skyscanner.model.User as dbUser WHERE dbUser.username= :username AND dbUser.password= :password";

	public static final String SELECT_FLIGHTS_FROM_TABLE_ORDERBY_FARE = "FROM com.nagarro.skyscanner.model.Flight as dbFlight WHERE dbFlight.departure= :departure AND dbFlight.arrival= :arrival AND dbFlight.seatAvailabilty= 'Y' AND dbFlight.validTill>= :travelDate order by dbFlight.fare";

	public static final String SELECT_FLIGHTS_FROM_TABLE_ORDERBY_BOTH = "FROM com.nagarro.skyscanner.model.Flight as dbFlight WHERE dbFlight.departure= :departure AND dbFlight.arrival= :arrival AND dbFlight.seatAvailabilty= 'Y' AND dbFlight.validTill>= :travelDate order by dbFlight.fare, dbFlight.flightDuration";
}
