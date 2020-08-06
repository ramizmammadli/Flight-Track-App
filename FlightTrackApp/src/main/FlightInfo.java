package main;

import java.time.LocalTime;

//this class holds weekdays and related variables. it will be used during the modification of tables
public class FlightInfo {
	public String FlightNo;
	public String Airline;
	public String AirCraft;
	public String FlightWeek;
	public LocalTime Departure;
	public LocalTime Arrival;
	public Integer Delay;
	public static FlightInfo[] InfoArray = new FlightInfo[100];
	public String DepartCity;
	public String ArrivalCity;
	public static String[] Weekdays = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
	public FlightInfo() {

	}

	public FlightInfo(String flightNo, String airline, String airCraft, String flightWeek, LocalTime departure,
			LocalTime arrival, Integer delay, String departCity, String arrivalCity) {
		this.FlightNo = flightNo;
		this.Airline = airline;
		this.AirCraft = airCraft;
		this.FlightWeek = flightWeek;
		this.Departure = departure;
		this.Arrival = arrival;
		this.Delay = delay;
		this.DepartCity = departCity;
		this.ArrivalCity = arrivalCity;
	}

}