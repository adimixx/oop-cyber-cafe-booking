package Controller;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import View.Computer_New;
import Model.Computer;
import Model.Location;
import Model.LocationComboBoxModel;


public class Computer_NewController extends Computer_New {
	
	@SuppressWarnings({ "unchecked" , "rawtypes" })
	public Computer_NewController() {
		super();
		locationCombo = new JComboBox(new LocationComboBoxModel(datamodel.location));
		super.initialize();
	}
		
	@Override //Ini Exit Button
	public void onClick_Cancel() {
		frame.dispose();
	}

	@Override
	public void onClick_InsertComputer() {
		if (locationCombo.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(null, "Please select a Location!", "Alert", JOptionPane.WARNING_MESSAGE);
		}
		
		else if(textField.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Please insert a Computer Name!", "Alert", JOptionPane.WARNING_MESSAGE);
		}
		
		else {
			Computer newComp = new Computer();
			String name = textField.getText().toUpperCase();
			newComp.setName(name);
			
			newComp.setLocation((Location)locationCombo.getSelectedItem());
			
			if (newComp.insert()) {
				JOptionPane.showMessageDialog(null, "Computer Added","Computer Added", JOptionPane.INFORMATION_MESSAGE);
				frame.dispose();
			}
			else {
				JOptionPane.showMessageDialog(null, "System Error. Please Contact Admin", "Alert", JOptionPane.WARNING_MESSAGE);
			}				
		}
	}
	
	
}
