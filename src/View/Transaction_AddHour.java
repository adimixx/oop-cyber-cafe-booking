package View;

import javax.swing.JFrame;
import Dependency.Main;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public abstract class Transaction_AddHour extends Main {

	public JFrame frame;
	protected JLabel newEndDateLabel = new JLabel("dd/MM/yyyy HH:mm");
	protected JLabel oldEndDateLabel = new JLabel("dd/MM/yyyy HH:mm");
	protected JLabel totalLabel = new JLabel("RM 0.00");
	protected JLabel paidLabel = new JLabel("RM 0.00");
	protected JLabel unpaidLabel = new JLabel("RM 0.00");
	protected JSpinner spinner = new JSpinner(new SpinnerNumberModel(1,1,1000,1));

	public abstract void hoursChanged();
	public abstract void addHour();
	public abstract void cancel();
	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	protected void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 459, 459);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JLabel lblCurrentEndDate = new JLabel("Current End Date :");
		lblCurrentEndDate.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblAddHours = new JLabel("Hours to add :");
		lblAddHours.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JButton btnAddHour = new JButton("Add Hour");
		btnAddHour.setBackground(new Color(153,130,188));
		btnAddHour.setForeground(Color.WHITE);
		btnAddHour.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddHour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addHour();
			}
		});
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 12));

		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				hoursChanged();
			}
		});

		JLabel lblAddCustomer = new JLabel("Add Hour");
		lblAddCustomer.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddCustomer.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNewEndDate = new JLabel("New End Date :");
		lblNewEndDate.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblNewPrice = new JLabel("Total Price :");
		lblNewPrice.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblPaidPrice = new JLabel("Paid Price :");
		lblPaidPrice.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblUnpaidPrice = new JLabel("Unpaid Price :");
		lblUnpaidPrice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(222,62,68));
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel();
			}
		});

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(178, Short.MAX_VALUE)
					.addComponent(lblAddCustomer, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addGap(173))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(53)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCurrentEndDate, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewEndDate, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(52)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUnpaidPrice, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPaidPrice, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewPrice, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAddHours, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))))
					.addGap(59)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(newEndDateLabel, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
						.addComponent(oldEndDateLabel, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
						.addComponent(totalLabel, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
						.addComponent(unpaidLabel, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
						.addComponent(paidLabel, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAddHour, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(23, Short.MAX_VALUE)
					.addComponent(lblAddCustomer)
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(oldEndDateLabel)
						.addComponent(lblCurrentEndDate))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(newEndDateLabel)
						.addComponent(lblNewEndDate))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(totalLabel)
						.addComponent(lblNewPrice))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(paidLabel)
						.addComponent(lblPaidPrice))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUnpaidPrice)
						.addComponent(unpaidLabel))
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAddHours))
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddHour, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(57))
		);
		oldEndDateLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		newEndDateLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		totalLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		paidLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		unpaidLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.getContentPane().setLayout(groupLayout);
	}
}
