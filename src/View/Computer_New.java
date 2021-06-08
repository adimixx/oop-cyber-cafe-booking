package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Dependency.Main;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;

public abstract class Computer_New extends  Main{

	public JFrame frame;
	public JButton cancel;
	public JButton Insert;
	public JTextField textField;
	@SuppressWarnings("rawtypes")
	public JComboBox locationCombo = new JComboBox();
	
	public abstract void onClick_Cancel();
	public abstract void onClick_InsertComputer();
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 460, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Add New Computer");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		cancel = new JButton("Cancel");
		cancel.setForeground(Color.WHITE);
		cancel.setBackground(new Color(222,62,68));
		cancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClick_Cancel();
			}
		});
		
		Insert = new JButton("Add Computer");
		Insert.setForeground(Color.WHITE);
		Insert.setBackground(new Color(153,130,188));
		Insert.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClick_InsertComputer();
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Computer Name"); //tambah nama komputer
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textField = new JTextField(); //tempat isi
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Location");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(128, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
					.addGap(124))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(cancel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(Insert, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(locationCombo, 0, 238, Short.MAX_VALUE)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))))
					.addGap(36))
		);
		locationCombo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addComponent(lblNewLabel)
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(locationCombo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(Insert, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(cancel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(61))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
