package main;

import java.time.LocalTime;
import java.util.Calendar;
import static java.time.temporal.ChronoUnit.*;

public class FlightThread extends Thread {
	public static int c;
	public static int rowCurrent;
	public static Calendar cal;
	public static LocalTime timeArrivalDelayCheck, timeDepartureDelayCheck;

	public FlightThread(int c, Calendar cal, LocalTime timeDepartureDelayCheck, LocalTime timeArrivalDelayCheck,
			int rowCurrent) {
		FlightThread.c = c;
		FlightThread.cal = cal;
		FlightThread.timeDepartureDelayCheck = timeDepartureDelayCheck;
		FlightThread.timeArrivalDelayCheck = timeArrivalDelayCheck;
		FlightThread.rowCurrent = rowCurrent;
	}

	@SuppressWarnings("deprecation")
	public void run() {
		while (true) {

			// TimeCheck holds the time of the system
			String TimeCheck = String.format("%02d", cal.get(Calendar.HOUR_OF_DAY)) + ":"
					+ String.format("%02d", cal.get(Calendar.MINUTE));
			// datas are copied to Current flight table
			for (int i = 0; i < 9; i++) {
				DataFlight.data2[rowCurrent][i] = DataFlight.data[c][i];
			}
			// if the flight arrival time comes and is approved, the flight will finish
			if (timeArrivalDelayCheck.equals(LocalTime.parse(TimeCheck)) == true
					&& DataFlight.data2[rowCurrent][9].equals("Approved")) {
				DataFlight.data2[rowCurrent][9] = "Finished";
				ScheduleWindow.table2.repaint();
				stop();	//thread killed as the flight finished
			}
			//if nothing is typed to the situation, it means there must be "Started"
			if (DataFlight.data2[rowCurrent][9] == null) {
				DataFlight.data2[rowCurrent][9] = "Started";
			}
			//PermissionWindow will pop up 10 minutes (as a system time) before it arrives. 
			else if (DataFlight.data2[rowCurrent][9] == "Started"
					&& (int) MINUTES.between(LocalTime.parse(TimeCheck), timeArrivalDelayCheck) == 10) {
				PermissionWindow.main(null);
				// if no decision is given, it is pending
				if (timeArrivalDelayCheck.equals(LocalTime.parse(TimeCheck)) == false) {
					DataFlight.data2[rowCurrent][9] = "Pending...";
				}
			}
			ScheduleWindow.table2.repaint();
			try {
				sleep(500);//in order not to miss any flight, they are checked twice in a second
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}