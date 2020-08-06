package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import java.time.LocalTime;
import java.awt.Toolkit;

public class UpdateScheduleWindow {

	private JFrame frame;
	public static JTable table;
	private JTextField FlightText;
	private JTextField AircraftText;
	private JTextField AirlinesText;
	private JTextField DepartureTimeText;
	private JTextField ArrivalTimeText;
	private JTextField DelayText;
	private JComboBox WeekdayCombo;
	public static String[] updateArray = new String[100];
	public static int row, rowTable = -1;
	private JLabel label;
	private JLabel lblAircraft;
	private JLabel lblAirlines;
	private JLabel lblDepartureCity;
	private JLabel lblArrivalCity;
	private JLabel lblWeekdays;
	private JLabel lblDepartureTime;
	private JLabel lblArrivalTime;
	private JLabel lblDelay;
	private JComboBox comboBox;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateScheduleWindow window = new UpdateScheduleWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UpdateScheduleWindow() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateScheduleWindow.class.getResource("/main/icon.jpg")));
		frame.setBounds(100, 100, 948, 654);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 90, 916, 224);
		frame.getContentPane().add(scrollPane);
		
		//table is set as not editable in order to prevent user to edit the table randomly
		DefaultTableModel model = new DefaultTableModel(DataFlight.data, DataFlight.columnNames) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		ScheduleWindow.table = new JTable(model);
		scrollPane.setViewportView(ScheduleWindow.table);

		//following text areas are responsible from related datas of the flight
		FlightText = new JTextField();
		FlightText.setToolTipText("Flight No");
		FlightText.setBounds(197, 375, 137, 28);
		frame.getContentPane().add(FlightText);
		FlightText.setColumns(10);

		AircraftText = new JTextField();
		AircraftText.setToolTipText("AirCraft");
		AircraftText.setColumns(10);
		AircraftText.setBounds(197, 414, 137, 28);
		frame.getContentPane().add(AircraftText);

		AirlinesText = new JTextField();
		AirlinesText.setToolTipText("Airlines");
		AirlinesText.setColumns(10);
		AirlinesText.setBounds(197, 453, 137, 28);
		frame.getContentPane().add(AirlinesText);
		
		//contains the list of cities to choose departure city
		JComboBox DepartCombo = new JComboBox();
		DepartCombo.setBounds(197, 495, 137, 22);
		frame.getContentPane().add(DepartCombo);
		frame.getContentPane().add(DepartCombo);

		for (int i = 0; i < RUNTHISCLASS.size; i++) {
			DepartCombo.addItem(City.cityList[i]);
		}

		//contains the list of cities to choose arrival city
		JComboBox ArrivalCombo = new JComboBox();
		ArrivalCombo.setBounds(197, 531, 137, 22);
		frame.getContentPane().add(ArrivalCombo);
		for (int i = 0; i < RUNTHISCLASS.size; i++) {
			ArrivalCombo.addItem(City.cityList[i]);
		}
		
		//contains the list of weekdays 
		WeekdayCombo = new JComboBox();
		WeekdayCombo.setToolTipText("Weekdays");
		WeekdayCombo.setBounds(680, 378, 137, 22);
		frame.getContentPane().add(WeekdayCombo);

		for (int i = 0; i < 7; i++) {
			WeekdayCombo.addItem(FlightInfo.Weekdays[i]);
		}

		DepartureTimeText = new JTextField();
		DepartureTimeText.setToolTipText("Departure time, such as 00:00");
		DepartureTimeText.setColumns(10);
		DepartureTimeText.setBounds(680, 414, 137, 28);
		frame.getContentPane().add(DepartureTimeText);

		ArrivalTimeText = new JTextField();
		ArrivalTimeText.setToolTipText("Arrival time, such as 23:59");
		ArrivalTimeText.setColumns(10);
		ArrivalTimeText.setBounds(680, 453, 137, 28);
		frame.getContentPane().add(ArrivalTimeText);

		DelayText = new JTextField();
		DelayText.setToolTipText("Delay (in minutes)");
		DelayText.setColumns(10);
		DelayText.setBounds(680, 492, 137, 28);
		frame.getContentPane().add(DelayText);

		label = new JLabel("Flight No:");
		label.setFont(new Font("Times New Roman", Font.BOLD, 13));
		label.setBounds(41, 375, 115, 22);
		frame.getContentPane().add(label);

		lblAircraft = new JLabel("Aircraft:");
		lblAircraft.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblAircraft.setBounds(41, 414, 115, 22);
		frame.getContentPane().add(lblAircraft);

		lblAirlines = new JLabel("Airlines:");
		lblAirlines.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblAirlines.setBounds(41, 453, 115, 22);
		frame.getContentPane().add(lblAirlines);

		lblDepartureCity = new JLabel("Departure city:");
		lblDepartureCity.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblDepartureCity.setBounds(41, 492, 115, 22);
		frame.getContentPane().add(lblDepartureCity);

		lblArrivalCity = new JLabel("Arrival city:");
		lblArrivalCity.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblArrivalCity.setBounds(41, 531, 115, 22);
		frame.getContentPane().add(lblArrivalCity);

		lblWeekdays = new JLabel("Weekdays:");
		lblWeekdays.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblWeekdays.setBounds(555, 378, 115, 22);
		frame.getContentPane().add(lblWeekdays);

		lblDepartureTime = new JLabel("Departure time:");
		lblDepartureTime.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblDepartureTime.setBounds(555, 414, 115, 22);
		frame.getContentPane().add(lblDepartureTime);

		lblArrivalTime = new JLabel("Arrival time:");
		lblArrivalTime.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblArrivalTime.setBounds(555, 453, 115, 22);
		frame.getContentPane().add(lblArrivalTime);

		lblDelay = new JLabel("Delay:");
		lblDelay.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblDelay.setBounds(555, 492, 115, 22);
		frame.getContentPane().add(lblDelay);

		JButton DoneButton = new JButton("Done");
		DoneButton.setToolTipText("Click to continue");
		DoneButton.setBounds(732, 561, 146, 34);
		frame.getContentPane().add(DoneButton);
		DoneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//row will be selected by clicking
				rowTable = ScheduleWindow.table.getSelectedRow();
				// if any of the text fields are empty, this warning will pop up
				if (FlightText.getText().isEmpty() || AircraftText.getText().isEmpty()
						|| AirlinesText.getText().isEmpty() || DepartureTimeText.getText().isEmpty()
						|| ArrivalTimeText.getText().isEmpty() || DelayText.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all the blanks", "Warning!",
							JOptionPane.WARNING_MESSAGE);
					frame.setVisible(false);
					UpdateScheduleWindow.main(null);
				}
				
				// departure time cannot be the same with or later than arrival time 
				else if (LocalTime.parse(ArrivalTimeText.getText())
						.compareTo(LocalTime.parse(DepartureTimeText.getText())) < 1) {
					JOptionPane.showMessageDialog(null,
							"Departure time cannot be later than or at the same time with Arrival time", "Warning!",
							JOptionPane.WARNING_MESSAGE);
					frame.setVisible(false);
					UpdateScheduleWindow.main(null);
				}
				// if everything works perfectly, the flight will be updated in the Scheduled
				// flights' table
				else  {
					updateArray[0] = FlightText.getText();
					updateArray[1] = AircraftText.getText();
					updateArray[2] = AirlinesText.getText();
					updateArray[3] = DepartCombo.getSelectedItem().toString();
					updateArray[4] = ArrivalCombo.getSelectedItem().toString();
					updateArray[5] = WeekdayCombo.getSelectedItem().toString();
					updateArray[6] = DepartureTimeText.getText();
					updateArray[7] = ArrivalTimeText.getText();
					updateArray[8] = DelayText.getText();
					
					for (int i = 0; i <= 8; i++) {
						DataFlight.data[rowTable][i] = updateArray[i];
					}
					frame.setVisible(false);
					ScheduleWindow.table2.repaint();
				}
			}
		});

		JLabel lblNewLabel = new JLabel("Choose a flight to update:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 30, 240, 36);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Enter new flight information:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 338, 240, 26);
		frame.getContentPane().add(lblNewLabel_1);

	}
}