package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Dependency.Main;
import java.awt.Color;
import java.awt.Font;

public abstract class MemberShip extends Main {
	public JFrame frame;
	public JTable table;
	public JScrollPane scrollPane;
	public JButton btnHistoryActive;
	protected JTextField hour;
	protected JTextField Email;
	protected JTextField Name;

	/**
	 * Create the application.
	 */
	public MemberShip() {
		initialize();
		MemberShipActiveTable();
	}

	public abstract void MemberShipActiveTable();

	public abstract void generateHistoryTable();
	
	public abstract void BackClicked(ActionEvent e);

	public abstract void onClick_btnAdd(ActionEvent e);

	public abstract void onClick_btnDel(ActionEvent e);

	public abstract void onClick_btnUpdate(ActionEvent e);

	public abstract void onClick_btnreset(ActionEvent e);

	public abstract void onClick_mouseClicked(MouseEvent e);

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1082, 439);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			
		});
		scrollPane.setBounds(337, 11, 707, 367);
		scrollPane.setViewportBorder(null);

		JButton btnHistoryActive = new JButton("Update");
		btnHistoryActive.setForeground(Color.WHITE);
		btnHistoryActive.setBackground(new Color(153,130,188));
		btnHistoryActive.setBounds(32, 293, 125, 30);
		btnHistoryActive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClick_btnUpdate(e);
			}
		});

		JButton btnNewButton_1 = new JButton("Add Member");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(153,130,188));
		btnNewButton_1.setBounds(32, 228, 125, 30);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClick_btnAdd(e);

			}
		});

		JButton btnNewButton_2 = new JButton("Reset");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(new Color(153,130,188));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClick_btnreset(e);
			}
		});
		btnNewButton_2.setBounds(179, 293, 125, 30);

		JButton btnNewButton_3 = new JButton("Delete Member");
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(new Color(153,130,188));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClick_btnDel(e);
			}
		});
		btnNewButton_3.setBounds(179, 228, 125, 30);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(scrollPane);
		frame.getContentPane().add(btnHistoryActive);
		frame.getContentPane().add(btnNewButton_1);
		frame.getContentPane().add(btnNewButton_2);
		frame.getContentPane().add(btnNewButton_3);

		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(23, 92, 68, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Email");
		lblNewLabel_1_1.setBounds(23, 133, 68, 14);
		frame.getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Hour Spend");
		lblNewLabel_1_1_1.setBounds(23, 171, 68, 14);
		frame.getContentPane().add(lblNewLabel_1_1_1);

		hour = new JTextField();
		hour.setBounds(120, 167, 184, 23);
		frame.getContentPane().add(hour);
		hour.setColumns(10);

		Email = new JTextField();
		Email.setColumns(10);
		Email.setBounds(120, 129, 184, 23);
		frame.getContentPane().add(Email);

		Name = new JTextField();
		Name.setColumns(10);
		Name.setBounds(120, 88, 184, 23);
		frame.getContentPane().add(Name);
		
		JLabel lblNewLabel = new JLabel("Membership");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(113, 23, 110, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_2_1 = new JButton("Back");
		btnNewButton_2_1.setForeground(Color.WHITE);
		btnNewButton_2_1.setBackground(new Color(222,62,68));
		btnNewButton_2_1.setBounds(109, 345, 125, 30);
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BackClicked(e);
			}
		});
		
		frame.getContentPane().add(btnNewButton_2_1);
		
	}
}
