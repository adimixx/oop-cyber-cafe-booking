package Controller;


import javax.swing.JOptionPane;
import View.Location_New;
import Model.Location;



public class Location_NewController extends Location_New {
		
	@Override //Ini Exit Button
	public void onClick_Cancel() {
		frame.dispose();
	}

	@Override
	public void onClick_InsertLocation() {
		
		 if(nameField.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Please insert a Location Name!", "Alert", JOptionPane.WARNING_MESSAGE);
		}
		
		else {
			Location newLoc = new Location();
			
			String name = nameField.getText().toUpperCase();
			
			newLoc.setName(name);
			
			if (newLoc.insert()) {
				JOptionPane.showMessageDialog(null, "Location Added","Location Added", JOptionPane.INFORMATION_MESSAGE);
				frame.dispose();
			}
			else {
				JOptionPane.showMessageDialog(null, "System Error. Please Contact Admin", "Alert", JOptionPane.WARNING_MESSAGE);
			}				
		}
	}
	
	
}
