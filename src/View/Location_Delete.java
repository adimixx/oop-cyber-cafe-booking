package View;

import Dependency.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Font;

public abstract class Location_Delete extends Main{

	public JFrame frame;
	public JLabel label;
	public JLabel label1;
	@SuppressWarnings("rawtypes")
	public JComboBox locationCombo = new JComboBox();
	public JButton cancel;
	public JButton deleteLocation;

	
	public abstract void onClick_Exit();
	public abstract void onClick_DeleteLocation();

	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 480, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		label = new JLabel("Delete Location");
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		label1 = new JLabel("Location Name");
		label1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		cancel = new JButton("Cancel");
		cancel.setBackground(new Color(222,62,68));
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClick_Exit();
			}
		});
		
		deleteLocation = new JButton("Delete");
		deleteLocation.setBackground(new Color(153,130,188));
		deleteLocation.setForeground(Color.WHITE);
		deleteLocation.setFont(new Font("Tahoma", Font.PLAIN, 12));
		deleteLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClick_DeleteLocation();
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(50)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(cancel, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(deleteLocation, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label1, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
									.addGap(36)
									.addComponent(locationCombo, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(157)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(50, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(107)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(deleteLocation, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(cancel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(40)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label1)
								.addComponent(locationCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(35))
		);
		locationCombo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.getContentPane().setLayout(groupLayout);
	}
}
