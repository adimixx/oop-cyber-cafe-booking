package View;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Dependency.Main;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public abstract class Computer_Menu extends  Main{

	public JFrame frame;
	public JButton exit;
	public JButton addComputer;
	public JButton refresh;
	public JButton updateComputer;
	public JScrollPane scrollPane;
	public JTable table;
	public JLabel lblNewLabel;
	public JLabel lblNewLabel_1;
	
	
	public Computer_Menu() {
		initialize();
		generateActiveComputer();
	}

	public abstract void onClick_Exit(ActionEvent e);
	public abstract void onClick_AddComputer(ActionEvent e);
	public abstract void onClick_UpdateComputer(ActionEvent e);
	public abstract void onClick_RefreshPage(ActionEvent e);
	public abstract void generateActiveComputer();
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 839, 505);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		
		exit = new JButton("Back");
		exit.setBackground(new Color(222,62,68));
		exit.setForeground(Color.WHITE);
		exit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClick_Exit(e);
			}
		});
		
		lblNewLabel = new JLabel("Computer Management");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		 addComputer = new JButton("Add Computer");
		 addComputer.setBackground(new Color(153,130,188));
		 addComputer.setForeground(Color.WHITE);
		 addComputer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					onClick_AddComputer(e);
				}
			});
		
		lblNewLabel_1 = new JLabel("Active Computer");
		
		refresh = new JButton("Refresh");
		refresh.setBackground(new Color(153,130,188));
		refresh.setForeground(Color.WHITE);
		refresh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClick_RefreshPage(e);
			}
		});
		
		updateComputer = new JButton("Update Computer");
		updateComputer.setBackground(new Color(153,130,188));
		updateComputer.setForeground(Color.WHITE);
		updateComputer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		updateComputer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClick_UpdateComputer(e);
			}
		});
		
		//JButton exit = new JButton("Exit");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(addComputer)
							.addGap(18)
							.addComponent(updateComputer, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 437, Short.MAX_VALUE)
							.addComponent(exit, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(295)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 228, Short.MAX_VALUE))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addComponent(refresh, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 768, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(17)
							.addComponent(lblNewLabel)
							.addGap(8)
							.addComponent(refresh))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_1)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(addComputer, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(updateComputer, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(exit, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(37))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
