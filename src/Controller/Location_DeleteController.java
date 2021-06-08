package Controller;

import java.util.stream.Stream;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import View.Location_Delete;
import Model.Computer;
import Model.Location;
import Model.LocationComboBoxModel;


public class Location_DeleteController extends Location_Delete {
	
	@SuppressWarnings({ "unchecked" , "rawtypes" })
	public Location_DeleteController() {
		super();
		locationCombo = new JComboBox(new LocationComboBoxModel(datamodel.location));
		super.initialize();
	}
		
	@Override //Ini Exit Button
	public void onClick_Exit() {
		frame.dispose();
	}
	
	
	
	@Override
	public void onClick_DeleteLocation() {
		
		Location newLoca = new Location();
		
		newLoca.setLocation((Location)locationCombo.getSelectedItem());
		
		if(locationCombo.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(null, "Please select a Location!", "Alert", JOptionPane.WARNING_MESSAGE);
		}
		else {
			
			Stream<Computer> trans = datamodel.computer.stream().filter(x->x.getLocation() == newLoca.getLocation());
			if (trans.count() > 0) {
				JOptionPane.showMessageDialog(null, "Location is being Used!", "Alert", JOptionPane.WARNING_MESSAGE);
			}
			else {
				if (newLoca.delete()) {
					JOptionPane.showMessageDialog(null, "Location Deleted","Location Deleted", JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "System Error. Please Contact Admin", "Alert", JOptionPane.WARNING_MESSAGE);
				}
			}					
		}
	}

}
