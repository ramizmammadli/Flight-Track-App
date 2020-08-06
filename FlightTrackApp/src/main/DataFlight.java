package main;

public class DataFlight {
//default scheduled flight information is kept in data matrix
	public static String[][] data  = {
			{FlightInfo.InfoArray[0].FlightNo, FlightInfo.InfoArray[0].AirCraft, FlightInfo.InfoArray[0].Airline, City.cityList[0], City.cityList[1], FlightInfo.InfoArray[0].FlightWeek, FlightInfo.InfoArray[0].Departure.toString(), FlightInfo.InfoArray[0].Arrival.toString(), FlightInfo.InfoArray[0].Delay.toString()},
			{FlightInfo.InfoArray[1].FlightNo, FlightInfo.InfoArray[1].AirCraft, FlightInfo.InfoArray[1].Airline, City.cityList[1], City.cityList[2], FlightInfo.InfoArray[1].FlightWeek, FlightInfo.InfoArray[1].Departure.toString(), FlightInfo.InfoArray[1].Arrival.toString(), FlightInfo.InfoArray[1].Delay.toString()},
			{FlightInfo.InfoArray[2].FlightNo, FlightInfo.InfoArray[2].AirCraft, FlightInfo.InfoArray[2].Airline, City.cityList[3], City.cityList[4], FlightInfo.InfoArray[2].FlightWeek, FlightInfo.InfoArray[2].Departure.toString(), FlightInfo.InfoArray[2].Arrival.toString(), FlightInfo.InfoArray[2].Delay.toString()},
			{FlightInfo.InfoArray[3].FlightNo, FlightInfo.InfoArray[3].AirCraft, FlightInfo.InfoArray[3].Airline, City.cityList[4], City.cityList[0], FlightInfo.InfoArray[3].FlightWeek, FlightInfo.InfoArray[3].Departure.toString(), FlightInfo.InfoArray[3].Arrival.toString(), FlightInfo.InfoArray[3].Delay.toString()},
			{FlightInfo.InfoArray[4].FlightNo, FlightInfo.InfoArray[4].AirCraft, FlightInfo.InfoArray[4].Airline, City.cityList[0], City.cityList[3], FlightInfo.InfoArray[4].FlightWeek, FlightInfo.InfoArray[4].Departure.toString(), FlightInfo.InfoArray[4].Arrival.toString(), FlightInfo.InfoArray[4].Delay.toString()},
			{FlightInfo.InfoArray[5].FlightNo, FlightInfo.InfoArray[5].AirCraft, FlightInfo.InfoArray[5].Airline, City.cityList[2], City.cityList[3], FlightInfo.InfoArray[5].FlightWeek, FlightInfo.InfoArray[5].Departure.toString(), FlightInfo.InfoArray[5].Arrival.toString(), FlightInfo.InfoArray[5].Delay.toString()},
			{FlightInfo.InfoArray[6].FlightNo, FlightInfo.InfoArray[6].AirCraft, FlightInfo.InfoArray[6].Airline, City.cityList[1], City.cityList[0], FlightInfo.InfoArray[6].FlightWeek, FlightInfo.InfoArray[6].Departure.toString(), FlightInfo.InfoArray[6].Arrival.toString(), FlightInfo.InfoArray[6].Delay.toString()},
			{FlightInfo.InfoArray[7].FlightNo, FlightInfo.InfoArray[7].AirCraft, FlightInfo.InfoArray[7].Airline, City.cityList[3], City.cityList[1], FlightInfo.InfoArray[7].FlightWeek, FlightInfo.InfoArray[7].Departure.toString(), FlightInfo.InfoArray[7].Arrival.toString(), FlightInfo.InfoArray[7].Delay.toString()},
			{FlightInfo.InfoArray[8].FlightNo, FlightInfo.InfoArray[8].AirCraft, FlightInfo.InfoArray[8].Airline, City.cityList[1], City.cityList[2], FlightInfo.InfoArray[8].FlightWeek, FlightInfo.InfoArray[8].Departure.toString(), FlightInfo.InfoArray[8].Arrival.toString(), FlightInfo.InfoArray[8].Delay.toString()},
			{FlightInfo.InfoArray[9].FlightNo, FlightInfo.InfoArray[9].AirCraft, FlightInfo.InfoArray[9].Airline, City.cityList[0], City.cityList[4], FlightInfo.InfoArray[9].FlightWeek, FlightInfo.InfoArray[9].Departure.toString(), FlightInfo.InfoArray[9].Arrival.toString(), FlightInfo.InfoArray[9].Delay.toString()},
			{null, null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null, null},
	};
	//data2 matrix is initially empty, but datas will be added to it in next steps
	public static String[][] data2  = {
			{null, null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null, null, null},
	};
	//column names of scheduled flights' table
	public static	String[] columnNames = {
			"Flight No", "Aircraft", "Airlines", "From", "To", "Weekday", "Departure", "Arrival", "Delay"
		};
	//column names of current flights' table
	public static	String[] columnNames2 = {
			"Flight No", "Aircraft", "Airlines", "From", "To", "Weekday", "Departure", "Arrival", "Delay", "Situation" 
		};
	//size of tables
	public static int sizeData = 9;
	public static int sizeData2 = 0;
}