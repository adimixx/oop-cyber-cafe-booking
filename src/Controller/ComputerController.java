package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import View.Computer_Menu;
import Model.ActiveComputerTableModel;
import Model.Computer;

public class ComputerController extends Computer_Menu {
	

	@Override //Ini Exit Button
	public void onClick_Exit(ActionEvent e) {
		frame.dispose();
	}
	
	@Override //Ini Add Computer
	public void onClick_AddComputer(ActionEvent e) {
		// TODO Auto-generated method stub
				Computer_NewController ts = new Computer_NewController();
				frame.setVisible(false);
				ts.frame.setVisible(true);
				ts.frame.addWindowListener(new WindowAdapter() {
					public void windowClosed(WindowEvent e) {
						frame.setVisible(true);
						
					}
				});
	}
	
	public void onClick_UpdateComputer(ActionEvent e) {
		// TODO Auto-generated method stub
				Computer_UpdateController ts = new Computer_UpdateController();
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
		generateActiveComputer();
	}
	
	@Override
	public void generateActiveComputer() {
		//get transactions that is active
		List<Computer> dataArray = datamodel.computer.stream().collect(Collectors.toList());
		table = new JTable(new ActiveComputerTableModel(dataArray));
		JTableHeader header = table.getTableHeader();
		header.setBackground(Color.black);
		header.setForeground(Color.white);
		scrollPane.setViewportView(table);
		lblNewLabel.setText("Computer Management");
	}
}
