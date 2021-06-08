package Controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;

import Model.Computer;
import Model.ComputerComboBoxModel;
import Model.Membership;
import Model.Transaction;
import View.Transaction_New;

public class Transaction_NewController extends Transaction_New {

	private double totalPayment = 0;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Transaction_NewController() {
		super();
		List<Computer> unactiveComputer = datamodel.computer;
		var active = datamodel.transaction.stream().filter(x -> x.getIsActive()).collect(Collectors.toList());
		for (int i = 0; i < active.size(); i++) {
			int activeID = active.get(i).getComputer().getID();
			unactiveComputer.removeIf(x -> x.getID() == activeID);
		}
		if (unactiveComputer.size() == 0) {
			JOptionPane.showMessageDialog(null, "No computers available!", "Alert", JOptionPane.WARNING_MESSAGE);
		} else {
			comboBoxComputer = new JComboBox(new ComputerComboBoxModel(unactiveComputer));
			super.initialize();
			textFieldEmail.setEnabled(false);
			btnCheckMembership.setEnabled(false);
			membershipDetailLabel.setVisible(false);
		}
	}

	private Membership findMembershipDetail() {
		if (textFieldEmail.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Please enter membership email!", "Alert", JOptionPane.WARNING_MESSAGE);
		} else {
			var memb = datamodel.membership.stream()
					.filter(x -> x.getEmail().toLowerCase().equals(textFieldEmail.getText().strip().toLowerCase()))
					.findFirst();
			if (memb.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Invalid Membership Email!", "Alert", JOptionPane.WARNING_MESSAGE);
			} else {
				return memb.get();
			}
		}
		return null;
	}

	@Override
	public void checkMembership() {
		// TODO Auto-generated method stub
		var memb = findMembershipDetail();
		if (memb != null) {
			membershipDetailLabel.setText("Membership Name : " + memb.getName());
			membershipDetailLabel.setVisible(true);
		}
	}

	@Override
	public void startSession() {
		// TODO Auto-generated method stub
		try {
			spinnerHours.commitEdit();

			if (!chckbxOpenHour.isSelected() && (Integer) spinnerHours.getValue() <= 0) {
				JOptionPane.showMessageDialog(null, "Hours cannot be less than 0!", "Alert",
						JOptionPane.WARNING_MESSAGE);
			}

			else if (comboBoxComputer.getSelectedIndex() == -1) {
				JOptionPane.showMessageDialog(null, "Please select a computer!", "Alert", JOptionPane.WARNING_MESSAGE);
			}

			else {
				Transaction newTrans = new Transaction();

				if (chckbxMembership.isSelected()) {
					var memb = findMembershipDetail();
					if (memb == null) {
						return;
					} else {
						newTrans.setMembership(memb);
					}
				}

				newTrans.setStartDate(new Date());

				if (chckbxOpenHour.isSelected()) {
					newTrans.setPrice(0);
				} else {
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(newTrans.getStartDate());
					calendar.add(Calendar.HOUR_OF_DAY, (Integer) spinnerHours.getValue());
					newTrans.setEndDate(calendar.getTime());
					newTrans.setPrice(totalPayment);
				}

				newTrans.setIsActive(true);
				newTrans.setComputer((Computer) comboBoxComputer.getSelectedItem());

				if (newTrans.insert()) {
					JOptionPane.showMessageDialog(null, "Session is activated", "Session Activated",
							JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "System Error. Please Contact Admin", "Alert",
							JOptionPane.WARNING_MESSAGE);
				}
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "System Error. Please Contact Admin", "Alert",
					JOptionPane.WARNING_MESSAGE);
		}

	}
	
	@Override
	public void BackClicked() {
		// TODO Auto-generated method stub
		frame.setVisible(false);
		try {
			TransactionController window = new TransactionController();
			window.frame.setVisible(true);
			window.frame.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent e) {
					frame.setVisible(true);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			frame.setVisible(true);
		}
		
	}

	@Override
	public void chckbxMembership_CheckChanged() {
		// TODO Auto-generated method stub
		if (chckbxMembership.isSelected()) {
			textFieldEmail.setEnabled(true);
			btnCheckMembership.setEnabled(true);
			totalPaymentlabel.setVisible(false);
		} else {
			textFieldEmail.setEnabled(false);
			btnCheckMembership.setEnabled(false);
			membershipDetailLabel.setVisible(false);
			textFieldEmail.setText("");
			totalPaymentlabel.setText("Total Payment : RM 0.00");
			totalPaymentlabel.setVisible(true);
		}
	}

	@Override
	public void chckbxOpenHour_CheckChanged() {
		if (chckbxOpenHour.isSelected()) {
			spinnerHours.setEnabled(false);
			spinnerHours.setValue(1);
		} else {
			spinnerHours.setEnabled(true);
		}
	}

	@Override
	public void spinnerHours_Changed(ChangeEvent e) {
		// TODO Auto-generated method stub
		if (!chckbxOpenHour.isSelected()) {
			int hour = (int) spinnerHours.getValue();
			totalPayment = hour * 2;
			totalPaymentlabel.setText("Total Payment : RM " + totalPayment);
		}
	}

}
