package View;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import Dependency.Main;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;

public abstract class User extends Main {

	public JFrame frame;
	public JTable table;
	public JScrollPane scrollPane;
	
	public User() {
		initialize();
		generateTable();
	}
	
	public abstract void generateTable();
	public abstract void AddUserClicked();
	public abstract void EditUserClicked();
	public abstract void DeleteUserClicked();
	public abstract void BackClicked();
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 835, 503);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Add User");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(153,130,188));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddUserClicked();
			}
		});
		
		JButton btnNewButton2 = new JButton("Edit User");
		btnNewButton2.setForeground(Color.WHITE);
		btnNewButton2.setBackground(new Color(153,130,188));
		btnNewButton2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditUserClicked();
			}
		});
		
		JLabel lblNewLabel = new JLabel("USER MANAGEMENT");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnNewButton3 = new JButton("Delete User");
		btnNewButton3.setForeground(Color.WHITE);
		btnNewButton3.setBackground(new Color(153,130,188));
		btnNewButton3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteUserClicked();
			}
		});
		
		JButton btnNewButton4 = new JButton("Back");
		btnNewButton4.setForeground(Color.WHITE);
		btnNewButton4.setBackground(new Color(222,62,68));
		btnNewButton4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BackClicked();
			}
		});
		
		JLabel label = new JLabel("CYBER CAFE BOOKING SYSTEM");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnNewButton2, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnNewButton3, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE))
							.addGap(318)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton4, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton3, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton4, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
		

	}
}
