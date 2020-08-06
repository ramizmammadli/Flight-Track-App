package main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.time.LocalTime;
import java.awt.Toolkit;

public class RUNTHISCLASS {

	private JFrame frame;
	public static int size = 5; // default number of cities

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RUNTHISCLASS window = new RUNTHISCLASS();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		for (int i = 0; i < 5; i++) {// default cities are copied to String array of cities
			City.cityList[i] = City.str[i];
		}

	}

	public RUNTHISCLASS() {
		initialize();
	}

	private void initialize() {

		frame = new JFrame();
		// icon is set
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(RUNTHISCLASS.class.getResource("/main/icon.jpg")));
		frame.setBounds(100, 100, 379, 435);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		JLabel lblNewLabel = new JLabel("Destinations");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(23, 34, 169, 32);
		frame.getContentPane().add(lblNewLabel);
		// scroll pane is used in text area of cities
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 77, 319, 175);
		frame.getContentPane().add(scrollPane);

		// it is set as not editable in order to prevent user to make any changes on the
		// text area
		JTextArea textCity = new JTextArea();
		textCity.setEditable(false);
		scrollPane.setViewportView(textCity);

		// cities are copied to textArea
		if (size != 0)
			textCity.setText(City.cityList[0] + "\n");

		for (int i = 1; i < size; i++) {
			textCity.append(City.cityList[i] + "\n");
		}

		// this button runs addWindow in order to let user add cities
		JButton AddButton = new JButton("Add");
		AddButton.setBounds(23, 280, 99, 34);
		frame.getContentPane().add(AddButton);
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddWindow.main(null);
				frame.setVisible(false);
			}
		});
		// this button runs updateWindow in order to let user update cities. But the
		// default cities cannot be updated
		JButton UpdateCity = new JButton("Update");
		UpdateCity.setBounds(132, 280, 99, 34);
		frame.getContentPane().add(UpdateCity);
		UpdateCity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateWindow.main(null);
				frame.setVisible(false);
			}
		});
		// this button runs deleteWindow in order to let user delete cities. But the
		// default cities cannot be deleted
		JButton DeleteCity = new JButton("Delete");
		DeleteCity.setBounds(241, 280, 99, 34);
		frame.getContentPane().add(DeleteCity);
		DeleteCity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteWindow.main(null);
				frame.setVisible(false);
			}
		});
		// this button runs ScheduleWindow in order to let user proceed the next step
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScheduleWindow.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(23, 325, 317, 55);
		frame.getContentPane().add(btnNewButton);
		// default flights which exist in schedule table when it is first opened
		FlightInfo.InfoArray[0] = new FlightInfo("EK100", "Fly Emirates", "Boeing 737", "Sunday",
				LocalTime.parse("18:45"), LocalTime.parse("23:40"), 0, null, null);
		FlightInfo.InfoArray[1] = new FlightInfo("J28079", "AZAL", "Airbus a380", "Wednesday", LocalTime.parse("03:26"),
				LocalTime.parse("03:37"), 6, null, null);
		FlightInfo.InfoArray[2] = new FlightInfo("TG911", "Thai Airlines", "Boeing 777", "Tuesday",
				LocalTime.parse("02:35"), LocalTime.parse("10:48"), 0, null, null);
		FlightInfo.InfoArray[3] = new FlightInfo("LH767", "Lufthansa", "Boeing 767", "Wednesday", LocalTime.parse("03:15"),
				LocalTime.parse("03:27"), 3, null, null);
		FlightInfo.InfoArray[4] = new FlightInfo("SU1731", "Aeorflot", "Airbus a320", "Saturday",
				LocalTime.parse("10:00"), LocalTime.parse("15:20"), 0, null, null);
		FlightInfo.InfoArray[5] = new FlightInfo("BA142", "British Airways", "Boeing 787", "Monday",
				LocalTime.parse("13:20"), LocalTime.parse("16:20"), 0, null, null);
		FlightInfo.InfoArray[6] = new FlightInfo("THY103", "Turkish Airlines", "Boeing 737-800", "Wednesday",
				LocalTime.parse("03:49"), LocalTime.parse("09:59"), 0, null, null);
		FlightInfo.InfoArray[7] = new FlightInfo("PGT6226", "Pegasus Airlines", "Airbus a321", "Monday",
				LocalTime.parse("20:00"), LocalTime.parse("23:25"), 0, null, null);
		FlightInfo.InfoArray[8] = new FlightInfo("SXS145", "Sunexpress", "Boeing 737", "Tuesday",
				LocalTime.parse("02:50"), LocalTime.parse("10:00"), 0, null, null);
		FlightInfo.InfoArray[9] = new FlightInfo("QTR0744", "Qatar Airways", "Airbus a350", "Saturday",
				LocalTime.parse("08:00"), LocalTime.parse("12:30"), 0, null, null);

		// if new data is entered to the table, it will be added to InfoArray as well using constructor
		for (int i = 10; i <= DataFlight.sizeData; i++) {
			FlightInfo.InfoArray[i] = new FlightInfo(DataFlight.data[i][0], DataFlight.data[i][2],
					DataFlight.data[i][1], DataFlight.data[i][5], LocalTime.parse(DataFlight.data[i][6]),
					LocalTime.parse(DataFlight.data[i][7]), Integer.parseInt(DataFlight.data[i][8]),
					DataFlight.data[i][3], DataFlight.data[i][4]);
		}
	}
}