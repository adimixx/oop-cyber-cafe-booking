package Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import Model.Transaction;
import View.Transaction_EndSession;

public class Transaction_EndSessionController extends Transaction_EndSession {
	Transaction trans;
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	Date endDate;
	double hourSpend;
	double Unpaid;

	public Transaction_EndSessionController(Transaction trans) {
		super();
		this.trans = trans;
		PCNameLabel.setText(trans.getComputer().getName());
		endDate = trans.getEndDate();
		startDateLabel.setText(dateFormat.format(trans.getStartDate()));
		if (endDate == null) {
			endDate = new Date();
			double datediff = endDate.getTime() - trans.getStartDate().getTime();
			hourSpend = datediff / (60 * 60 * 1000);

			if ((hourSpend - (int) hourSpend) > 0) {
				hourSpend++;
			}
			hourSpend = (int) hourSpend;
			Unpaid = hourSpend * 2;
			unpaidLabel.setText("RM " + Unpaid);
		}
		endDateLabel.setText(dateFormat.format(endDate));
		super.initialize();
	}

	@Override
	public void endSession() {
		trans.setPrice(Unpaid);
		trans.setIsActive(false);
		if (trans.getEndDate() == null)
			trans.setEndDate(endDate);
		if (trans.update()) {
			JOptionPane.showMessageDialog(null, "Session Ended", "Success", JOptionPane.INFORMATION_MESSAGE);
			frame.dispose();
		} else {
			JOptionPane.showMessageDialog(null, "System error! Please contact admin", "Alert",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		frame.dispose();
	}

}
