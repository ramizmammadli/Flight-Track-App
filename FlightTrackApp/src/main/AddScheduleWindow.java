package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Toolkit;

public class AddScheduleWindow {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddScheduleWindow window = new AddScheduleWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AddScheduleWindow() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(AddScheduleWindow.class.getResource("/main/icon.jpg")));
		frame.setBounds(100, 100, 446, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		JLabel lblNewLabel = new JLabel("Add Flight Information");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(23, 28, 211, 37);
		frame.getContentPane().add(lblNewLabel);

		// all the datas of new flight will be entered to these text fields
		textField = new JTextField();
		textField.setBounds(268, 78, 106, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(268, 109, 106, 20);
		frame.getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(268, 140, 106, 20);
		frame.getContentPane().add(textField_2);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(268, 272, 106, 20);
		frame.getContentPane().add(textField_6);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(268, 303, 106, 20);
		frame.getContentPane().add(textField_7);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(268, 334, 106, 20);
		frame.getContentPane().add(textField_8);

		// this combo box contains list of cities for departure
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(268, 171, 106, 22);
		frame.getContentPane().add(comboBox);

		for (int i = 0; i < RUNTHISCLASS.size; i++) {
			comboBox.addItem(City.cityList[i]);
		}

		// this combo box contains list of cities for arrival
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(268, 206, 106, 22);
		frame.getContentPane().add(comboBox_1);

		for (int i = 0; i < RUNTHISCLASS.size; i++) {
			comboBox_1.addItem(City.cityList[i]);
		}

		// this combo box contains list of weekdays
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(268, 239, 106, 22);
		frame.getContentPane().add(comboBox_2);

		for (int i = 0; i < 7; i++) {
			comboBox_2.addItem(FlightInfo.Weekdays[i]);
		}

		JLabel lblNewLabel_1 = new JLabel("Flight No:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1.setBounds(75, 76, 115, 22);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblAddAirlines = new JLabel("Airlines");
		lblAddAirlines.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblAddAirlines.setBounds(75, 108, 115, 22);
		frame.getContentPane().add(lblAddAirlines);

		JLabel lblAddAircraft = new JLabel("Aircraft:");
		lblAddAircraft.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblAddAircraft.setBounds(75, 139, 115, 22);
		frame.getContentPane().add(lblAddAircraft);

		JLabel lblDepartureCity = new JLabel("Departure city:");
		lblDepartureCity.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblDepartureCity.setBounds(75, 171, 115, 22);
		frame.getContentPane().add(lblDepartureCity);

		JLabel lblArrivalCity = new JLabel("Arrival city:");
		lblArrivalCity.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblArrivalCity.setBounds(75, 206, 115, 22);
		frame.getContentPane().add(lblArrivalCity);

		JLabel lblWeekday = new JLabel("Weekday:");
		lblWeekday.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblWeekday.setBounds(75, 239, 115, 22);
		frame.getContentPane().add(lblWeekday);

		JLabel lblDepartureTime = new JLabel("Departure time:");
		lblDepartureTime.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblDepartureTime.setBounds(75, 272, 115, 22);
		frame.getContentPane().add(lblDepartureTime);

		JLabel lblArrivalTime = new JLabel("Arrival time:");
		lblArrivalTime.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblArrivalTime.setBounds(75, 303, 115, 22);
		frame.getContentPane().add(lblArrivalTime);

		JLabel lblDelay = new JLabel("Delay:");
		lblDelay.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblDelay.setBounds(75, 334, 115, 22);
		frame.getContentPane().add(lblDelay);

		JButton btnNewButton_1 = new JButton("Done");
		btnNewButton_1.setBounds(75, 377, 299, 37);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// if any of the text fields are empty, this warning will pop up
				if (textField.getText().isEmpty() || textField_1.getText().isEmpty() || textField_2.getText().isEmpty()
						|| textField_6.getText().isEmpty() || textField_7.getText().isEmpty()
						|| textField_8.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all the blanks", "Warning!",
							JOptionPane.WARNING_MESSAGE);
					frame.setVisible(false);
					AddScheduleWindow.main(null);
				}

				else {
					for (int i = 0; i < DataFlight.sizeData; i++) {

						// if entered flight number already exists among the Scheduled flight, this
						// warning will pop up
						if (textField.getText().equals(DataFlight.data[i][0])) {
							JOptionPane.showMessageDialog(null, "Flight number already exist in the schedule.",
									"Warning!", JOptionPane.WARNING_MESSAGE);
							frame.setVisible(false);
							AddScheduleWindow.main(null);
						}
					}
				}
				// departure and arrival times cannot be the same
				if (comboBox.getSelectedItem().toString() == comboBox_1.getSelectedItem().toString()) {
					JOptionPane.showMessageDialog(null, "Departure and Arrival city cannot be the same.", "Warning!",
							JOptionPane.WARNING_MESSAGE);
					frame.setVisible(false);
					AddScheduleWindow.main(null);
				}
				// logically, departure time cannot be after the arrival time
				else if (LocalTime.parse(textField_7.getText()).compareTo(LocalTime.parse(textField_6.getText())) < 1) {
					JOptionPane.showMessageDialog(null,
							"Departure time cannot be later than or at the same time with Arrival time", "Warning!",
							JOptionPane.WARNING_MESSAGE);
					frame.setVisible(false);
					AddScheduleWindow.main(null);
				}
				// if everything works perfectly, all the datas will be added to the Scheduled
				// flights' table
				else {
					DataFlight.data[DataFlight.sizeData][0] = textField.getText();
					DataFlight.data[DataFlight.sizeData][1] = textField_1.getText();
					DataFlight.data[DataFlight.sizeData][2] = textField_2.getText();
					DataFlight.data[DataFlight.sizeData][3] = comboBox.getSelectedItem().toString();
					DataFlight.data[DataFlight.sizeData][4] = comboBox_1.getSelectedItem().toString();
					DataFlight.data[DataFlight.sizeData][5] = comboBox_2.getSelectedItem().toString();
					DataFlight.data[DataFlight.sizeData][6] = textField_6.getText();
					DataFlight.data[DataFlight.sizeData][7] = textField_7.getText();
					DataFlight.data[DataFlight.sizeData][8] = textField_8.getText();
					DataFlight.sizeData++;
					frame.setVisible(false);
				}
			}
		});

	}
}