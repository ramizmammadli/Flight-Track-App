package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class PermissionWindow {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PermissionWindow window = new PermissionWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PermissionWindow() {
		initialize();
	}

	private void initialize() {

		// this window will be used as a control tower. when there's 10 minutes left 
		//(as a system time) this window will pop up
		
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(PermissionWindow.class.getResource("/main/icon.jpg")));
		frame.setBounds(100, 100, 482, 219);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNotify = new JLabel("New label");
		lblNotify.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNotify.setBounds(79, 53, 323, 30);
		frame.getContentPane().add(lblNotify);
		
		//flight number is printed in the window
		lblNotify.setText("Flight no: " + DataFlight.data2[FlightThread.rowCurrent][0] + " is close to the airport!");
		JButton btnApproveFlight = new JButton("Approve Flight");
		btnApproveFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if the flight is approved, the situation in the table 2 will be updated as approved
				DataFlight.data2[FlightThread.rowCurrent][9] = "Approved";
				frame.setVisible(false);

			}
		});
		btnApproveFlight.setBounds(61, 118, 119, 30);
		frame.getContentPane().add(btnApproveFlight);

		JButton btnRejectFlight = new JButton("Reject Flight");
		btnRejectFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//if the flight is approved, the situation in the table 2 will be updated as approved
				DataFlight.data2[FlightThread.rowCurrent][9] = "Rejected";
				frame.setVisible(false);
			}
		});
		btnRejectFlight.setBounds(298, 118, 119, 30);
		frame.getContentPane().add(btnRejectFlight);
	}
}
