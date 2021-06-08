package View;

import javax.swing.JFrame;
import Dependency.Main;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public abstract class Transaction_New extends Main {

	public JFrame frame;
	public JTextField textFieldEmail;
	public JCheckBox chckbxMembership = new JCheckBox("Membership Availibility");
	public JCheckBox chckbxOpenHour = new JCheckBox("Open Hour");
	public JSpinner spinnerHours = new JSpinner(new SpinnerNumberModel(1,1,1000,1));
	@SuppressWarnings("rawtypes")
	public JComboBox comboBoxComputer = new JComboBox();
	public JButton btnCheckMembership = new JButton("Check Membership");
	public JLabel membershipDetailLabel = new JLabel("Membership Name : ");
	public JLabel totalPaymentlabel = new JLabel("Total Payment : RM 0.00");



	public abstract void checkMembership();

	public abstract void startSession();
	
	public abstract void BackClicked();

	public abstract void chckbxMembership_CheckChanged();

	public abstract void chckbxOpenHour_CheckChanged();
	
	public abstract void spinnerHours_Changed(ChangeEvent e);

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 480, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JLabel lblNewLabel = new JLabel("New Customer");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		JLabel lblMembershipEmail = new JLabel("Membership Email : ");
		lblMembershipEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));

		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldEmail.setColumns(10);
		chckbxMembership.setBackground(Color.WHITE);
		chckbxMembership.setFont(new Font("Tahoma", Font.PLAIN, 12));

		chckbxMembership.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxMembership_CheckChanged();			
			}
		});
		chckbxOpenHour.setBackground(Color.WHITE);
		chckbxOpenHour.setFont(new Font("Tahoma", Font.PLAIN, 12));

		chckbxOpenHour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxOpenHour_CheckChanged();			
			}
		});
		btnCheckMembership.setForeground(Color.WHITE);
		btnCheckMembership.setBackground(new Color(153,130,188));
		btnCheckMembership.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		btnCheckMembership.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkMembership();
			}
		});
		JLabel lblNewLabel_1 = new JLabel("Total hours :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		JButton btnStartSession = new JButton("Start Session");
		btnStartSession.setForeground(Color.WHITE);
		btnStartSession.setBackground(new Color(153,130,188));
		btnStartSession.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnStartSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startSession();
			}
		});

		JLabel lblComputerName = new JLabel("Computer Name");
		lblComputerName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		spinnerHours.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				spinnerHours_Changed(e);
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancel.setBackground(new Color(222,62,68));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BackClicked();
			}
		});

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnCheckMembership))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(chckbxMembership)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblComputerName)
										.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
										.addComponent(totalPaymentlabel))
									.addGap(21)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(comboBoxComputer, 0, 242, Short.MAX_VALUE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(spinnerHours, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
											.addGap(35)
											.addComponent(chckbxOpenHour, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(membershipDetailLabel)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblMembershipEmail, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textFieldEmail, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)))))
					.addGap(36))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(168)
					.addComponent(lblNewLabel)
					.addContainerGap(177, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(51, Short.MAX_VALUE)
					.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(btnStartSession, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
					.addGap(55))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addComponent(lblNewLabel)
					.addGap(31)
					.addComponent(chckbxMembership)
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMembershipEmail)
						.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCheckMembership, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(membershipDetailLabel)
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(spinnerHours, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(chckbxOpenHour))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblComputerName)
						.addComponent(comboBoxComputer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(totalPaymentlabel)
					.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnStartSession, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(34))
		);
		comboBoxComputer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		membershipDetailLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		totalPaymentlabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.getContentPane().setLayout(groupLayout);
	}
}
