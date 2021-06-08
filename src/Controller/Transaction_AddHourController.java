package Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

import Model.Transaction;
import View.Transaction_AddHour;

public class Transaction_AddHourController extends Transaction_AddHour{
	Transaction trans;
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");  

	public Transaction_AddHourController(Transaction trans) {
		super();		
		this.trans = trans;
		oldEndDateLabel.setText(dateFormat.format(trans.getEndDate()));
		newEndDateLabel.setText(dateFormat.format(trans.getEndDate()));
		totalLabel.setText("RM" + trans.getPrice());
		paidLabel.setText("RM" + trans.getPrice());
		super.initialize();
	}
	
	@Override
	public void hoursChanged() {
		// TODO Auto-generated method stub
		int hour = (int)spinner.getValue();
		if (hour != 0) {
			double newPrice = hour * 2.0;
			newEndDateLabel.setText(dateFormat.format(addDateHours(trans.getEndDate(),hour)));
			totalLabel.setText("RM" + (trans.getPrice() + newPrice));
			unpaidLabel.setText("RM" + newPrice);
		}
	}

	@Override
	public void addHour() {
		// TODO Auto-generated method stub
		int hour = (int)spinner.getValue();
		if (hour != 0) {
			double newPrice = hour * 2.0;
			trans.setEndDate(addDateHours(trans.getEndDate(),hour));
			trans.setPrice(trans.getPrice() + newPrice);
			
			if (trans.update()) {
				JOptionPane.showMessageDialog(null, "Hours added", "Success",JOptionPane.INFORMATION_MESSAGE);
				frame.dispose();
			}
			else {
				JOptionPane.showMessageDialog(null, "System error! Please contact admin", "Alert",JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
	private Date addDateHours(Date date,int hour) {
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.HOUR_OF_DAY, hour);
	    return calendar.getTime();
	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		frame.dispose();
	}

}
