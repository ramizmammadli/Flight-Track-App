package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class DeleteScheduleWindow {

	private JFrame frame;
	public static int row;
	public static int opt = -1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteScheduleWindow window = new DeleteScheduleWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DeleteScheduleWindow() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(
				Toolkit.getDefaultToolkit().getImage(DeleteScheduleWindow.class.getResource("/main/icon.jpg")));
		frame.setBounds(100, 100, 892, 438);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 87, 860, 230);
		frame.getContentPane().add(scrollPane);

		// table is set as not editable in order to prevent user to edit the table
		// randomly
		DefaultTableModel model = new DefaultTableModel(DataFlight.data, DataFlight.columnNames) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		ScheduleWindow.table = new JTable(model);
		scrollPane.setViewportView(ScheduleWindow.table);

		JButton btnNewButton = new JButton("Done");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opt = ScheduleWindow.table.getSelectedRow();
				// if no flight is selected, this warning pops up
				if (opt == -1) {
					JOptionPane.showMessageDialog(null, "Please choose a flight", "Warning!",
							JOptionPane.WARNING_MESSAGE);
					DeleteScheduleWindow.main(null);
					frame.setVisible(false);
				}
				// if everything works perfectly, the chosen flight will be deleted and the
				// flights coming after chosen one will be swiped in order to close the gap
				else {
					for (int i = opt; i <= DataFlight.sizeData; i++) {
						for (int j = 0; j <= 8; j++) {
							DataFlight.data[i][j] = DataFlight.data[i + 1][j];
						}
					}

					DataFlight.sizeData--;
					frame.setVisible(false);
					ScheduleWindow.table.repaint();
				}
			}
		});
		btnNewButton.setBounds(644, 359, 111, 23);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Choose a row to delete:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 38, 215, 23);
		frame.getContentPane().add(lblNewLabel);
	}
}