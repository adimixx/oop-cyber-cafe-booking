package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import View.Location_Menu;
import Model.ActiveLocationTableModel;
import Model.Location;

public class LocationController extends Location_Menu {
	

	@Override //Ini Exit Button
	public void onClick_Exit(ActionEvent e) {
		frame.dispose();
	}
	
	@Override //Ini Add Computer
	public void onClick_AddLocation(ActionEvent e) {
		// TODO Auto-generated method stub
				Location_NewController ts = new Location_NewController();
				frame.setVisible(false);
				ts.frame.setVisible(true);
				ts.frame.addWindowListener(new WindowAdapter() {
					public void windowClosed(WindowEvent e) {
						frame.setVisible(true);
						
					}
				});
	}
	
	public void onClick_DeleteLocation(ActionEvent e) {
		// TODO Auto-generated method stub
				Location_DeleteController ts = new Location_DeleteController();
				frame.setVisible(false);
				ts.frame.setVisible(true);
				ts.frame.addWindowListener(new WindowAdapter() {
					public void windowClosed(WindowEvent e) {
						frame.setVisible(true);
						
					}
				});
	}
	
	@Override //Ini refresh page
	public void onClick_RefreshPage(ActionEvent e) {
		// TODO Auto-generated method stub
		generateLocation();
	}
	
	@Override
	public void generateLocation() {
		//get transactions that is active
		List<Location> dataArray = datamodel.location.stream().collect(Collectors.toList());
		table = new JTable(new ActiveLocationTableModel(dataArray));
		JTableHeader header = table.getTableHeader();
		header.setBackground(Color.black);
		header.setForeground(Color.white);
		scrollPane.setViewportView(table);
	}
}
