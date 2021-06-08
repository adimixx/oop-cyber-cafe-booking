package Controller;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import Model.UserTableModel;
import View.User;

public class UserController extends User {
	
	
	@Override
	public void generateTable() {
		// TODO Auto-generated method stub
		var dataArray = datamodel.user;
		table = new JTable(new UserTableModel(dataArray));
		JTableHeader header = table.getTableHeader();
		header.setBackground(Color.black);
		header.setForeground(Color.white);
		table.removeColumn(table.getColumnModel().getColumn(0));
		scrollPane.setViewportView(table);
	}
	
	@Override
	public void AddUserClicked() {
		// TODO Auto-generated method stub
		frame.setVisible(false);
		try {
			User_AddController window = new User_AddController(0);
			window.frame.setVisible(true);
			window.frame.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent e) {
					frame.setVisible(true);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			frame.setVisible(true);
			generateTable();
		}
		
	}

	@Override
	public void EditUserClicked() {
		// TODO Auto-generated method stub
		
		try {
			
			int selectedRow = table.getSelectedRow();
			int ID = (int) table.getModel().getValueAt(selectedRow,0);
					
			frame.setVisible(false);
			try {
				User_AddController window = new User_AddController(ID);
				window.frame.setVisible(true);
				window.frame.addWindowListener(new WindowAdapter() {
					public void windowClosed(WindowEvent e) {
						frame.setVisible(true);
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
				frame.setVisible(true);
				generateTable();
			}
		
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Please select user to edit");
		}

	}

	@Override
	public void DeleteUserClicked() {
		// TODO Auto-generated method stub
		
		try {
			
			int selectedRow = table.getSelectedRow();
			int ID = (int) table.getModel().getValueAt(selectedRow,0);
			
			Model.User usr = new Model.User();
			
			usr.setID(ID);
			
			if(usr.delete())
			{
				JOptionPane.showMessageDialog(null, "User successfully deleted","Success", JOptionPane.INFORMATION_MESSAGE);
				generateTable();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "System Error. Please Contact Admin", "Alert", JOptionPane.WARNING_MESSAGE);
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Please select user to delete");
		}
		
		
	}

	@Override
	public void BackClicked() {
		// TODO Auto-generated method stub
		frame.setVisible(false);
		try {
			MainMenuController window = new MainMenuController();
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



}
