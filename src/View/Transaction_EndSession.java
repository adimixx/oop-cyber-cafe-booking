package View;

import javax.swing.JFrame;
import Dependency.Main;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public abstract class Transaction_EndSession extends Main{

	public JFrame frame;

	protected JLabel PCNameLabel = new JLabel("PC 01");
	protected JLabel startDateLabel = new JLabel("dd/MM/yyyy hh:mm");
	protected JLabel endDateLabel = new JLabel("dd/MM/yyyy hh:mm");
	protected JLabel unpaidLabel = new JLabel("RM 0.00");

	public abstract void endSession();
	public abstract void cancel();

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	protected void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 410, 290);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Confirm to end this session");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(66, 23, 300, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPc = new JLabel("PC Name :");
		lblPc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPc.setBounds(66, 61, 138, 16);
		frame.getContentPane().add(lblPc);
		
		JLabel lblStartDate = new JLabel("Start Date : ");
		lblStartDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStartDate.setBounds(66, 88, 138, 16);
		frame.getContentPane().add(lblStartDate);
		
		JLabel lblEndDate = new JLabel("End Date : ");
		lblEndDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEndDate.setBounds(66, 115, 138, 16);
		frame.getContentPane().add(lblEndDate);
		
		JLabel lblUnpaidAmount = new JLabel("Unpaid Amount : ");
		lblUnpaidAmount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUnpaidAmount.setBounds(66, 142, 138, 16);
		frame.getContentPane().add(lblUnpaidAmount);
		PCNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		PCNameLabel.setBounds(214, 61, 131, 16);
		frame.getContentPane().add(PCNameLabel);
		startDateLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		startDateLabel.setBounds(212, 88, 154, 16);
		frame.getContentPane().add(startDateLabel);
		endDateLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		endDateLabel.setBounds(214, 115, 163, 16);
		frame.getContentPane().add(endDateLabel);
		unpaidLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		unpaidLabel.setBounds(214, 142, 131, 16);
		frame.getContentPane().add(unpaidLabel);
		
		JButton btnNewButton = new JButton("End Session");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(153,130,188));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				endSession();
			}
		});
		btnNewButton.setBounds(50, 194, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBackground(new Color(222,62,68));
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel();
			}
		});
		btnCancel.setBounds(217, 194, 117, 29);
		frame.getContentPane().add(btnCancel);
	}

}
