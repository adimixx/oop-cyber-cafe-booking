package View;

import Dependency.Main;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Font;

public abstract class Location_New extends Main{

	public JFrame frame;
	public JTextField nameField;
	public JLabel label;
	public JLabel addLocationName;
	public JButton cancel;
	public JButton addLocation;
	
	public Location_New() {
		initialize();
	}
	
	public abstract void onClick_Cancel();
	public abstract void onClick_InsertLocation();
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 449, 290);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label = new JLabel("Add Location");
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		addLocationName = new JLabel("Location Name:");
		addLocationName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		nameField = new JTextField();
		nameField.setColumns(10);
		
		cancel = new JButton("Cancel");
		cancel.setBackground(new Color(222,62,68));
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClick_Cancel();
			}
		});
		
		addLocation = new JButton("Add Location");
		addLocation.setBackground(new Color(153,130,188));
		addLocation.setForeground(Color.WHITE);
		addLocation.setFont(new Font("Tahoma", Font.PLAIN, 12));
		addLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClick_InsertLocation();
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(155)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(51)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(cancel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(addLocation))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(addLocationName, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
									.addGap(51)
									.addComponent(nameField, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(54, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(label)
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(nameField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(addLocationName))
					.addPreferredGap(ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(addLocation, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(cancel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(45))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
