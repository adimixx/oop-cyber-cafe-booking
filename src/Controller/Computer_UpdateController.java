package Controller;



import java.util.stream.Stream;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import View.Computer_Update;
import Model.Computer;
import Model.Location;
import Model.Transaction;
import Model.LocationComboBoxModel;
import Model.ComputerComboBoxModel;


public class Computer_UpdateController extends Computer_Update {
	
	@SuppressWarnings({ "unchecked" , "rawtypes" })
	public Computer_UpdateController() {
		super();
		locationCombo = new JComboBox(new LocationComboBoxModel(datamodel.location));
		computerCombo = new JComboBox(new ComputerComboBoxModel(datamodel.computer));
		super.initialize();
	}
		
	@Override //Ini Exit Button
	public void onClick_Exit() {
		frame.dispose();
	}
	
	@Override
	public void onClick_UpdateComputer() {
		if (locationCombo.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(null, "Please select a Location!", "Alert", JOptionPane.WARNING_MESSAGE);
		}
		
		else if(computerCombo.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(null, "Please select a Computer!", "Alert", JOptionPane.WARNING_MESSAGE);
		}
		
		else {
			
			Computer newComp = new Computer();
			
			newComp.setComputer((Computer)computerCombo.getSelectedItem());
			
			newComp.setLocation((Location)locationCombo.getSelectedItem());
			
			Stream<Transaction> trans = datamodel.transaction.stream().filter(x->x.getComputer() == newComp.getComputer() && x.getIsActive() == true);
			if (trans.count() > 0) {
				JOptionPane.showMessageDialog(null, "Computer is Active!", "Alert", JOptionPane.WARNING_MESSAGE);
			}
			else {
				if (newComp.update()) {
					JOptionPane.showMessageDialog(null, "Computer Location Updated","Computer Updated", JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "System Error. Please Contact Admin", "Alert", JOptionPane.WARNING_MESSAGE);
				}	
			}			
		}
	}
	
	@Override
	public void onClick_DeleteComputer() {
		
		Computer newComp = new Computer();
		
		newComp.setComputer((Computer)computerCombo.getSelectedItem());
		
		if(computerCombo.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(null, "Please select a Computer!", "Alert", JOptionPane.WARNING_MESSAGE);
		}
		else {
			
			Stream<Transaction> trans = datamodel.transaction.stream().filter(x->x.getComputer() == newComp.getComputer() && x.getIsActive() == true);
			if (trans.count() > 0) {
				JOptionPane.showMessageDialog(null, "Computer is Active!", "Alert", JOptionPane.WARNING_MESSAGE);
			}
			else {
				if (newComp.delete()) {
					JOptionPane.showMessageDialog(null, "Computer Deleted","Computer Deleted", JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "System Error. Please Contact Admin", "Alert", JOptionPane.WARNING_MESSAGE);
				}
			}					
		}
	}

}
