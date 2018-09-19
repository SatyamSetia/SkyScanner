package com.nagarro.skyscanner.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flight_table")
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "FLIGHT_NO", nullable = false)
	private String flightNo;
	
	@Column(name = "DEP_LOC", nullable = false)
	private String departure;
	
	@Column(name = "ARR_LOC", nullable = false)
	private String arrival;
	
	@Column(name = "VALID_TILL", nullable = false)
	private LocalDate validTill;
	
	@Column(name = "FLIGHT_TIME", nullable = false)
	private Integer flightTime;
	
	@Column(name = "FLIGHT_DUR", nullable = false)
	private double flightDuration;
	
	@Column(name = "FARE", nullable = false)
	private Integer fare;
	
	@Column(name = "SEAT_AVAILABILITY", nullable = false)
	private String seatAvailabilty;
	
	@Column(name = "CLASS", nullable = false)
	private String flightClass;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public LocalDate getValidTill() {
		return validTill;
	}
	public void setValidTill(LocalDate validTill) {
		this.validTill = validTill;
	}
	public Integer getFlightTime() {
		return flightTime;
	}
	public void setFlightTime(Integer flightTime) {
		this.flightTime = flightTime;
	}
	public double getFlightDuration() {
		return flightDuration;
	}
	public void setFlightDuration(double flightDuration) {
		this.flightDuration = flightDuration;
	}
	public Integer getFare() {
		return fare;
	}
	public void setFare(Integer fare) {
		this.fare = fare;
	}
	public String getSeatAvailabilty() {
		return seatAvailabilty;
	}
	public void setSeatAvailabilty(String seatAvailabilty) {
		this.seatAvailabilty = seatAvailabilty;
	}
	public String getFlightClass() {
		return flightClass;
	}
	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

}
