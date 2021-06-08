package View;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import Dependency.Main;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public abstract class Transaction extends Main{
	public JFrame frame;
	public JTable table;
	public JLabel lblActiveComputers;
	public JScrollPane scrollPane;
	public JButton btnHistoryActive;	
	/**
	 * Create the application.
	 */
	public Transaction() {
		initialize();
		generateActiveTable();
	}
	
	public abstract void generateActiveTable();
	public abstract void generateHistoryTable();
	public abstract void BackClicked(ActionEvent e);
	public abstract void onClick_btnHistoryActive(ActionEvent e);
	public abstract void onClick_btnNewCustomer(ActionEvent e);
	public abstract void onClick_btnAddHour(ActionEvent e);
	public abstract void onClick_btnEndHour(ActionEvent e);

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 829, 506);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel label = new JLabel("CYBER CAFE BOOKING SYSTEM");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblTransactionWindow = new JLabel("TRANSACTION MANAGER");
		lblTransactionWindow.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblActiveComputers = new JLabel("Active Computer Sessions: ");
		lblActiveComputers.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.DARK_GRAY);
		scrollPane.setViewportBorder(null);
		
		btnHistoryActive = new JButton("View History");
		btnHistoryActive.setForeground(Color.WHITE);
		btnHistoryActive.setBackground(new Color(153,130,188));
		btnHistoryActive.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHistoryActive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClick_btnHistoryActive(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("New Customer");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(153,130,188));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClick_btnNewCustomer(e);
			}
		});
		
		JButton btnNewButton_2 = new JButton("Add Hour");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(new Color(153,130,188));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClick_btnAddHour(e);
			}
		});
		
		JButton btnNewButton_3 = new JButton("End Session");
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(new Color(153,130,188));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClick_btnEndHour(e);
			}
		});
		
		JButton btnNewButton_2_1 = new JButton("Back");
		btnNewButton_2_1.setForeground(Color.WHITE);
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2_1.setBackground(new Color(222,62,68));
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BackClicked(e);
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addComponent(lblActiveComputers)
							.addPreferredGap(ComponentPlacement.RELATED, 498, Short.MAX_VALUE)
							.addComponent(btnHistoryActive, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20, 20, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 777, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnNewButton_2)
									.addGap(18)
									.addComponent(btnNewButton_3)
									.addPreferredGap(ComponentPlacement.RELATED, 322, Short.MAX_VALUE)
									.addComponent(btnNewButton_2_1, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 376, Short.MAX_VALUE)
									.addComponent(lblTransactionWindow, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)))))
					.addGap(27))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
						.addComponent(lblTransactionWindow))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addComponent(lblActiveComputers))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnHistoryActive, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_2_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(40))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
