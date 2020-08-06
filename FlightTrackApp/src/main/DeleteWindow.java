package main;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Toolkit;

public class DeleteWindow {
	public static String deleteWord;
	public static int index = 100;
	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteWindow window = new DeleteWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DeleteWindow() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(DeleteWindow.class.getResource("/main/icon.jpg")));
		frame.setBounds(100, 100, 401, 313);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 97, 199, 159);
		frame.getContentPane().add(scrollPane);

		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		DefaultListModel DLM = new DefaultListModel();
		// not editable is made in order to prevent user to modify it randomly
		for (int i = 0; i < RUNTHISCLASS.size; i++) {
			DLM.addElement(City.cityList[i]);
		}
		list.setModel(DLM);

		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setBounds(244, 225, 110, 31);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// if no city is chosen, warning will pop up
				if (list.getSelectedValue() == null) {
					JOptionPane.showMessageDialog(null, "Please choose a city", "Warning!",
							JOptionPane.WARNING_MESSAGE);
					frame.setVisible(false);
					DeleteWindow.main(null);
				} else {
					deleteWord = list.getSelectedValue().toString();
					index = list.getSelectedIndex();
					if (index < 5) {

						// default cities cannot be deleted
						JOptionPane.showMessageDialog(null, "Default cities can not be deleted", "Warning!",
								JOptionPane.WARNING_MESSAGE);
						DeleteWindow.main(null);
						frame.setVisible(false);
					}
					// if everything above works perfectly, the selected city will be deleted and
					// other cities will be swiped in order to close the gap
					else {
						while (City.cityList[index] != null) {
							City.cityList[index] = City.cityList[index + 1];
							index++;

							RUNTHISCLASS.size--;
							RUNTHISCLASS.main(null);
							frame.setVisible(false);
						}
					}
				}
			}
		});
		JLabel lblNewLabel = new JLabel("Choose a city to delete");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 56, 199, 30);
		frame.getContentPane().add(lblNewLabel);

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(10, 22, 91, 23);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RUNTHISCLASS.main(null);
				frame.setVisible(false);
			}
		});
	}
}
