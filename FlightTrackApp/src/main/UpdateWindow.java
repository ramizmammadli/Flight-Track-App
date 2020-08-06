package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class UpdateWindow {
	public static String oldWord;
	private JFrame frame;
	public static String ChooseWord = null;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateWindow window = new UpdateWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UpdateWindow() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateWindow.class.getResource("/main/icon.jpg")));
		frame.setBounds(100, 100, 570, 404);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 112, 337, 137);
		frame.getContentPane().add(scrollPane);

		JList list = new JList();

		list.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		scrollPane.setViewportView(list);
		DefaultListModel DLM = new DefaultListModel();

		// destinations are added to the table
		for (int i = 0; i < RUNTHISCLASS.size; i++) {
			DLM.addElement(City.cityList[i]);
		}
		list.setModel(DLM);

		// runs RUNTHISCLASS in order to go back
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(10, 24, 115, 30);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RUNTHISCLASS.main(null);
				frame.setVisible(false);
			}
		});

		JLabel lblNewLabel = new JLabel("Choose a city to update");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(36, 65, 210, 36);
		frame.getContentPane().add(lblNewLabel);

		JButton btnNewButton_1 = new JButton("Done");
		btnNewButton_1.setBounds(409, 318, 101, 30);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// if no city is choosen, this warning pops up
				if (list.getSelectedValue() == null) {
					JOptionPane.showMessageDialog(null, "Please choose a city", "Warning!",
							JOptionPane.WARNING_MESSAGE);
					frame.setVisible(false);
					UpdateWindow.main(null);
				}

				else {
					ChooseWord = list.getSelectedValue().toString();
					int index = list.getSelectedIndex();

					// default cities cannot be updated, so if one of them is chosen, this warning
					// pops up
					if (index < 5) {
						JOptionPane.showMessageDialog(null, "Default cities can not be updated", "Warning!",
								JOptionPane.WARNING_MESSAGE);
						frame.setVisible(false);
						UpdateWindow.main(null);
					}

					else {
						frame.setVisible(true);
						int i = 0;
						// if nothing is typed to the field, this warning pops up
						if (textField.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Please enter a city", "Warning!",
									JOptionPane.WARNING_MESSAGE);
							frame.setVisible(false);
							UpdateWindow.main(null);
						} else {
							String UpdateWord = textField.getText();
							while (ChooseWord != City.cityList[i] && i <= RUNTHISCLASS.size) {
								i++;
							}
							//the updated destination is added to the related array of strings
							if (ChooseWord == City.cityList[i]) {
								City.cityList[i] = UpdateWord;
								City.str[i] = UpdateWord;
							}
							frame.setVisible(false);
							RUNTHISCLASS.main(null);
						}
					}
				}
			}
		});

		JLabel lblNewLabel_1 = new JLabel("Enter the new city:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(36, 272, 186, 29);
		frame.getContentPane().add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(36, 320, 337, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

	}
}