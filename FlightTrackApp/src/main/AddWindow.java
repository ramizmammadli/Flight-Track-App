package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class AddWindow {
	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddWindow window = new AddWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AddWindow() {
		initialize();
	}

	public void initialize() {

		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(AddWindow.class.getResource("/main/icon.jpg")));
		frame.setBounds(100, 100, 384, 229);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		JLabel lblNewLabel = new JLabel("Add City Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setToolTipText("");
		lblNewLabel.setBounds(35, 57, 186, 36);
		frame.getContentPane().add(lblNewLabel);
		
		//name of new destination will be added here.
		JTextField textArea = new JTextField();
		textArea.setBounds(35, 95, 304, 34);
		frame.getContentPane().add(textArea);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.setVisible(true);
				String addition = textArea.getText();
				//if user didn't enter anything, warning pop up will show up and AddWindow will be run again
				if (addition.isEmpty() == true) {
					JOptionPane.showMessageDialog(null, "Please enter a city name.", "Warning!",
							JOptionPane.INFORMATION_MESSAGE);
					AddWindow.main(null);
					frame.setVisible(false);
				}
				
				//else, the entered city will be added to 
				if (addition.isEmpty() == false) {
					City.cityList[RUNTHISCLASS.size] = addition;
					RUNTHISCLASS.size++;
					frame.setVisible(false);
					RUNTHISCLASS.main(null);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton.setBounds(35, 140, 304, 36);
		frame.getContentPane().add(btnNewButton);
	
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(10, 23, 90, 23);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RUNTHISCLASS.main(null);
				frame.setVisible(false);
			}
		});
	}
}
