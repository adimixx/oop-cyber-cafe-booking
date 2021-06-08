package View;

import Dependency.Main;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Color;

public abstract class Location_Menu extends Main {

	public JFrame frame;
	public JScrollPane scrollPane;
	public JTable table;
	public JButton back;
	public JButton addLocation;
	public JButton deleteLocation;
	public JButton refreshPage;
	
	public abstract void generateLocation();
	public abstract void onClick_Exit(ActionEvent e);
	public abstract void onClick_AddLocation(ActionEvent e);
	public abstract void onClick_DeleteLocation(ActionEvent e);
	public abstract void onClick_RefreshPage(ActionEvent e);
	
	public Location_Menu() {
		initialize();
		generateLocation();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 558, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		
		back = new JButton("Back");
		back.setBackground(new Color(222,62,68));
		back.setForeground(Color.WHITE);
		back.setFont(new Font("Tahoma", Font.PLAIN, 12));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClick_Exit(e);
			}
		});
		
		addLocation = new JButton("Add Location");
		addLocation.setBackground(new Color(153,130,188));
		addLocation.setForeground(Color.WHITE);
		addLocation.setFont(new Font("Tahoma", Font.PLAIN, 12));
		addLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClick_AddLocation(e);
			}
		});
		
		deleteLocation = new JButton("Delete Location");
		deleteLocation.setBackground(new Color(153,130,188));
		deleteLocation.setForeground(Color.WHITE);
		deleteLocation.setFont(new Font("Tahoma", Font.PLAIN, 12));
		deleteLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClick_DeleteLocation(e);
			}
		});
		
		refreshPage = new JButton("Refresh");
		refreshPage.setBackground(new Color(153,130,188));
		refreshPage.setForeground(Color.WHITE);
		refreshPage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		refreshPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClick_RefreshPage(e);
			}
		});
		
		JLabel lblNewLabel = new JLabel("Location Management");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(addLocation, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(deleteLocation)
									.addPreferredGap(ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
									.addComponent(back, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
								.addComponent(refreshPage))
							.addContainerGap())
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
							.addGap(146))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(refreshPage)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(back, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(addLocation, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(deleteLocation, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
