package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class ScheduleWindow {

	private JFrame frame;
	public static JTable table, table2;
	public static int size;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_2;
	public static int day = -1, month = -1, year = -1;
	public static int hour = -1, minute = -1, weekDay;
	public static Calendar cal = Calendar.getInstance();
	public static Thread time;
	public static int checkData2 = 0;
	public static int c = 0;
	public static String timeCheck;
	public static int rowCurrent = 0;
	public static LocalTime timeDepartureDelayCheck, timeArrivalDelayCheck;
	public static boolean approveB = false, rejectB = false, startB = false, pauseB = false, checkB = true;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScheduleWindow window = new ScheduleWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ScheduleWindow() {
		initialize();
	}

	public void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(ScheduleWindow.class.getResource("/main/icon.jpg")));
		frame.setBounds(100, 100, 955, 679);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false); // it is set as not resizable

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 131, -4, 9);
		frame.getContentPane().add(scrollPane);

		// this button runs AddScheduleWindow to let user add new flights
		JButton btnNewButton = new JButton("Add Flight");
		btnNewButton.setBounds(51, 390, 197, 31);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddScheduleWindow.main(null);
				table.repaint();
				table2.repaint();
			}
		});
		// this button runs UpdateScheduleWindow to let user update the existing flights
		JButton btnUpdateFlight = new JButton("Update Flight");
		btnUpdateFlight.setBounds(348, 390, 197, 31);
		frame.getContentPane().add(btnUpdateFlight);
		btnUpdateFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateScheduleWindow.main(null);
				table.repaint();
				table2.repaint();
			}
		});
		// this button runs DeleteScheduleWindow to let user delete the existing flights
		JButton btnDeleteFlight = new JButton("Delete Flight");
		btnDeleteFlight.setBounds(684, 390, 197, 31);
		frame.getContentPane().add(btnDeleteFlight);
		btnDeleteFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteScheduleWindow.main(null);
				table.repaint();
				table2.repaint();
			}
		});

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 245, 923, 134);
		frame.getContentPane().add(scrollPane_1);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 475, 923, 134);
		frame.getContentPane().add(scrollPane_2);

		JLabel lblNewLabel = new JLabel("Scheduled Flights");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setForeground(Color.CYAN);
		lblNewLabel.setBounds(334, 197, 197, 44);
		frame.getContentPane().add(lblNewLabel);

		table = new JTable(DataFlight.data, DataFlight.columnNames);
		scrollPane_1.setViewportView(table);
		JLabel lblCurrentFlights = new JLabel("Current Flights");
		lblCurrentFlights.setForeground(Color.CYAN);
		lblCurrentFlights.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblCurrentFlights.setBounds(375, 430, 170, 44);
		frame.getContentPane().add(lblCurrentFlights);

		table2 = new JTable(DataFlight.data2, DataFlight.columnNames2);
		scrollPane_2.setViewportView(table2);

		JLabel lblNewLabel_2 = new JLabel("Set date and time\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2.setBounds(10, 75, 161, 23);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel DateLbl = new JLabel("Date:");
		DateLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		DateLbl.setBounds(10, 117, 45, 23);
		frame.getContentPane().add(DateLbl);

		JLabel Timelbl = new JLabel("Time:");
		Timelbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		Timelbl.setBounds(10, 148, 40, 14);
		frame.getContentPane().add(Timelbl);

		textField = new JTextField();
		textField.setToolTipText("Day");
		textField.setBounds(51, 120, 19, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setToolTipText("Hour");
		textField_1.setColumns(10);
		textField_1.setBounds(51, 147, 19, 20);
		frame.getContentPane().add(textField_1);

		JLabel lblNewLabel_5 = new JLabel("/");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(78, 124, 19, 14);
		frame.getContentPane().add(lblNewLabel_5);

		JLabel slash1 = new JLabel(":");
		slash1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		slash1.setBounds(78, 148, 19, 14);
		frame.getContentPane().add(slash1);

		textField_3 = new JTextField();
		textField_3.setToolTipText("Minute");
		textField_3.setColumns(10);
		textField_3.setBounds(92, 147, 19, 20);
		frame.getContentPane().add(textField_3);

		JLabel label_1 = new JLabel("/");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(118, 124, 19, 14);
		frame.getContentPane().add(label_1);

		textField_5 = new JTextField();
		textField_5.setToolTipText("Year");
		textField_5.setColumns(10);
		textField_5.setBounds(129, 120, 42, 20);
		frame.getContentPane().add(textField_5);

		textField_2 = new JTextField();
		textField_2.setToolTipText("Month");
		textField_2.setColumns(10);
		textField_2.setBounds(92, 120, 19, 20);
		frame.getContentPane().add(textField_2);

		JLabel sysTime = new JLabel("HH : MM");
		sysTime.setFont(new Font("Tahoma", Font.BOLD, 16));
		sysTime.setBounds(754, 109, 77, 31);
		frame.getContentPane().add(sysTime);

		JLabel sysWeekday = new JLabel("Weekday");
		sysWeekday.setFont(new Font("Tahoma", Font.BOLD, 16));
		sysWeekday.setBounds(754, 183, 100, 23);
		frame.getContentPane().add(sysWeekday);

		JLabel sysDate = new JLabel("dd/mm/yyyy");
		sysDate.setFont(new Font("Tahoma", Font.BOLD, 17));
		sysDate.setBounds(733, 144, 122, 23);
		frame.getContentPane().add(sysDate);

		JButton btnNewButton_3 = new JButton("Set");
		btnNewButton_3.setBounds(10, 185, 161, 23);
		frame.getContentPane().add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// if any text field is empty, this warning will pop up
				if (textField.getText().isEmpty() || textField_1.getText().isEmpty() || textField_2.getText().isEmpty()
						|| textField_3.getText().isEmpty() || textField_5.getText().isEmpty()) {

					JOptionPane.showMessageDialog(null, "Please fill all the blanks to set the time", "Warning!",
							JOptionPane.WARNING_MESSAGE);
				}
				// time components must be in proper way
				else if (Integer.parseInt(textField.getText()) > 31 || Integer.parseInt(textField.getText()) <= 0
						|| Integer.parseInt(textField_1.getText()) > 23 || Integer.parseInt(textField_1.getText()) < 0
						|| Integer.parseInt(textField_3.getText()) > 59 || Integer.parseInt(textField_3.getText()) < 0
						|| Integer.parseInt(textField_2.getText()) > 12
						|| Integer.parseInt(textField_2.getText()) <= 0) {

					JOptionPane.showMessageDialog(null, "Please enter a valid date", "Warning!",
							JOptionPane.WARNING_MESSAGE);

				}
				// if everything works perfectly, the values will be parsed to integer and
				// copied to respective variables
				else {
					minute = Integer.parseInt(textField_3.getText());
					hour = Integer.parseInt(textField_1.getText());
					day = Integer.parseInt(textField.getText());
					month = Integer.parseInt(textField_2.getText()) - 1;
					year = Integer.parseInt(textField_5.getText());

					// cal is the object of Calendar class, here the time components are set to the
					// object and it will be displayed on the frame.
					// String.format is used in order to display the time in proper way
					cal.set(year, month, day, hour, minute);
					sysTime.setText(String.format("%02d", cal.get(Calendar.HOUR_OF_DAY)) + ":"
							+ String.format("%02d", cal.get(Calendar.MINUTE)));
					sysDate.setText(String.format("%02d", cal.get(Calendar.DAY_OF_MONTH)) + "/"
							+ String.format("%02d", (cal.get(Calendar.MONTH) + 1)) + "/"
							+ String.format("%02d", cal.get(Calendar.YEAR)));
					sysWeekday.setText(cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.ENGLISH));
				}
			}
		});

		JLabel lblSystemTime = new JLabel("System time");
		lblSystemTime.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSystemTime.setBounds(733, 75, 122, 23);
		frame.getContentPane().add(lblSystemTime);

		JLabel lblTimeManagement = new JLabel("Manage Time");
		lblTimeManagement.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTimeManagement.setBounds(373, 51, 125, 23);
		frame.getContentPane().add(lblTimeManagement);

		JButton btnStart = new JButton("Start");
		btnStart.setBounds(373, 85, 116, 23);
		frame.getContentPane().add(btnStart);
		btnStart.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				startB = true;

				// if time is not started, this warning will pop up
				if (minute == -1 || year == -1 || day == -1 || hour == -1 || month == -1) {
					JOptionPane.showMessageDialog(null, "Please set time to start", "Warning!",
							JOptionPane.WARNING_MESSAGE);

				}

				else if (checkB == true) {

					// time thread is started if everything above works perfectly
					time = new Thread() {
						public void run() {
							// in every loop, the time will be set and displayed again
							cal.set(year, month, day, hour, minute);

							while (true) {
								sysTime.setText(String.format("%02d", cal.get(Calendar.HOUR_OF_DAY)) + ":"
										+ String.format("%02d", cal.get(Calendar.MINUTE)));
								sysDate.setText(String.format("%02d", cal.get(Calendar.DAY_OF_MONTH)) + "/"
										+ String.format("%02d", (cal.get(Calendar.MONTH) + 1)) + "/"
										+ String.format("%02d", cal.get(Calendar.YEAR)));
								sysWeekday.setText(
										cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.ENGLISH));
								// in this for loop, every flight is checked whether it's their flight time or
								// not in every second
								for (c = 0; c < DataFlight.sizeData; c++) {
									// timeDepartureDelayCheck and timeArrivalDelayCheck are the times of flight
									// with the addition of delay

									timeDepartureDelayCheck = LocalTime.parse(DataFlight.data[c][6])
											.plusMinutes(Integer.parseInt(DataFlight.data[c][8]));
									timeArrivalDelayCheck = LocalTime.parse(DataFlight.data[c][7])
											.plusMinutes(Integer.parseInt(DataFlight.data[c][8]));

									// if it's time for departure, new thread of flight is started directly with
									// creating FlightThread object, but without
									// saving to any object variable. Number of current flights (rowCurrent) is
									// increased by 1
									if (timeDepartureDelayCheck.equals(LocalTime.parse(sysTime.getText()))) {

										(new FlightThread(c, cal, timeDepartureDelayCheck, timeArrivalDelayCheck,
												rowCurrent)).start();
										rowCurrent++;
									}
								}
								try { // thread waits for 1 second (1000 ms)
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								cal.add(Calendar.MINUTE, 1); // and in every turn, minute is added by 1
							}
						}
					};
					time.start();

					// if the time is already started and going on, this warning will pop up
				} else if (checkB == false) {
					JOptionPane.showMessageDialog(null, "Time can only be started for once", "Warning!",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		JButton btnPause = new JButton("Pause");
		btnPause.setBounds(435, 115, 110, 23);
		frame.getContentPane().add(btnPause);
		btnPause.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				// if the time is not set, it cannot be paused
				if (minute == -1 || year == -1 || day == -1 || hour == -1 || month == -1) {
					JOptionPane.showMessageDialog(null, "Please set time to start", "Warning!",
							JOptionPane.WARNING_MESSAGE);
					// if the time is not started, is cannot be paused
				} else if (startB == false && checkB == true) {
					JOptionPane.showMessageDialog(null, "Time cannot be paused until it is started", "Warning!",
							JOptionPane.WARNING_MESSAGE);
				}
				// if everything works perfectly, time will be suspend until it's resumed
				else {
					time.suspend();
					pauseB = true;
				}
			}
		});

		JButton btnResume = new JButton("Resume");
		btnResume.setBounds(315, 115, 110, 23);
		frame.getContentPane().add(btnResume);
		btnResume.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				// if time cannot be resumed until it's paused
				if (pauseB == false) {
					JOptionPane.showMessageDialog(null, "Time cannot be resumed until it's paused", "Warning!",
							JOptionPane.WARNING_MESSAGE);
				} else {
					time.resume();
				}
			}
		});

		JButton btnReset = new JButton("Clean");
		btnReset.setBounds(373, 146, 116, 23);
		frame.getContentPane().add(btnReset);
		btnReset.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")

			// if the time is not set, it cannot be cleaned
			public void actionPerformed(ActionEvent e) {
				if (minute == -1 || year == -1 || day == -1 || hour == -1 || month == -1) {
					JOptionPane.showMessageDialog(null, "Please set time to clean", "Warning!",
							JOptionPane.WARNING_MESSAGE);
					// if the time is not started, it cannot be cleaned
				} else if (startB == false) {
					JOptionPane.showMessageDialog(null, "Please start first", "Warning!", JOptionPane.WARNING_MESSAGE);
				} else {
					time.stop();
					sysTime.setText("HH : MM");
					sysDate.setText("dd/mm/yyyy");
					sysWeekday.setText("Weekday");
				}
			}
		});

		JLabel lblNewLabel_1 = new JLabel("Press this button to finish the app and write datas to the related file:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(304, 624, 397, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JButton btnFinish = new JButton("Finish");
		btnFinish.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				// yes-no pop up. just to make the decision certain
				int result = JOptionPane.showConfirmDialog(frame,
						"All the datas will be saved to the file and the app will be closed" + ". Are you sure? ",
						"Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {
					if (startB == false) {

						// if the time is not started, it cannot be finished
						JOptionPane.showMessageDialog(null,
								"Please start the time first to finish the program properly", "Warning!",
								JOptionPane.WARNING_MESSAGE);
					} else {

						// if everything works perfectly, time will stop, frame will be disposed and all
						// the datas will be written to the file
						time.stop();
						frame.dispose();
						File file = new File("FlightTrackApp_18011903.txt");
						PrintWriter pw;
						try {
							pw = new PrintWriter(file);
							pw.write("Name of the Destinations: \n");

							for (int j = 0; j < RUNTHISCLASS.size; j++) {
								pw.append(City.cityList[j] + "\n");
							}
							pw.append(
									"=========================================================================================");
							pw.append("\nScheduled Flights: \n");
							for (int i = 0; i < DataFlight.sizeData; i++) {
								pw.append((i + 1) + ": ");
								for (int j = 0; j < 8; j++) {
									pw.append(DataFlight.data[i][j] + ", ");
								}
								pw.append(DataFlight.data[i][8]);
								pw.append("\n");
							}
							pw.append(
									"=========================================================================================");
							pw.append("\nCurrently happened Flights: \n");
							for (int i = 0; i < rowCurrent; i++) {
								pw.append((i + 1) + ": ");
								for (int j = 0; j < 9; j++) {
									pw.append(DataFlight.data2[i][j] + ", ");
								}
								pw.append(DataFlight.data2[i][9]);
								pw.append("\n");
							}
							pw.append(
									"=========================================================================================");
							pw.append("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t  Ramiz Mammadli - 18011903.");
							pw.close();
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnFinish.setBounds(711, 620, 127, 23);
		frame.getContentPane().add(btnFinish);
	}
}