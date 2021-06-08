package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Dependency.Main;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Color;

public abstract class Computer_Update extends Main {

	public JFrame frame;
	public JButton updateComputer;
	public JButton cancelUpdate;
	public JButton deleteComputer;
	@SuppressWarnings("rawtypes")
	public JComboBox computerCombo = new JComboBox();
	@SuppressWarnings("rawtypes")
	public JComboBox locationCombo = new JComboBox();
	public JLabel computerLabel;
	public JLabel locationLabel;
	private JLabel update;
	
	public abstract void onClick_Exit();
	public abstract void onClick_UpdateComputer();
	public abstract void onClick_DeleteComputer();
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 531, 332);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		computerLabel = new JLabel("Computer :");
		computerLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		locationLabel = new JLabel("Location :");
		locationLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		updateComputer = new JButton("Update Computer");
		updateComputer.setForeground(Color.WHITE);
		updateComputer.setBackground(new Color(153,130,188));
		updateComputer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		updateComputer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClick_UpdateComputer();
			}
		});
		
		cancelUpdate = new JButton("Back");
		cancelUpdate.setForeground(Color.WHITE);
		cancelUpdate.setBackground(new Color(222,62,68));
		cancelUpdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cancelUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClick_Exit();
			}
		});
		
		update = new JLabel("Update Computer");
		update.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		deleteComputer = new JButton("Delete Computer");
		deleteComputer.setForeground(Color.WHITE);
		deleteComputer.setBackground(new Color(153,130,188));
		deleteComputer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		deleteComputer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClick_DeleteComputer();
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(172)
					.addComponent(update, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(176, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(65, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(cancelUpdate, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(deleteComputer)
							.addGap(18)
							.addComponent(updateComputer, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(locationLabel, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
								.addComponent(computerLabel, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
							.addGap(61)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(locationCombo, 0, 208, Short.MAX_VALUE)
								.addComponent(computerCombo, 0, 208, Short.MAX_VALUE))
							.addGap(68))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(update)
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(computerCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(computerLabel))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(locationCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(locationLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(updateComputer, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(cancelUpdate, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(deleteComputer, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(54))
		);
		locationCombo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		computerCombo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.getContentPane().setLayout(groupLayout);
	}
}
