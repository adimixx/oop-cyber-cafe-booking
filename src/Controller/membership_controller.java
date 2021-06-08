package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import Model.ActiveMembershipTableModel;

import Model.Membership;
import View.MemberShip;

public class membership_controller extends MemberShip {
	@Override
	public void MemberShipActiveTable() {
		List<Membership> dataArray = datamodel.membership;
		table = new JTable(new ActiveMembershipTableModel(dataArray));
		JTableHeader header = table.getTableHeader();
		header.setBackground(Color.black);
		header.setForeground(Color.white);
		scrollPane.setViewportView(table);

	}

	@Override
	public void generateHistoryTable() {
		List<Membership> dataArray = datamodel.membership;
		table = new JTable(new ActiveMembershipTableModel(dataArray));
		JTableHeader header = table.getTableHeader();
		header.setBackground(Color.black);
		header.setForeground(Color.white);
		scrollPane.setViewportView(table);

	}

	@Override
	public void onClick_btnAdd(ActionEvent e) {
		Membership newMem = new Membership();
		String name = Name.getText().toUpperCase();
		String email = Email.getText().toUpperCase();
		String hourSpend = hour.getText().toUpperCase();

		newMem.setName(name);
		newMem.setEmail(email);
		newMem.sethourSpend(hourSpend);

		if (newMem.insert()) {
			JOptionPane.showMessageDialog(null, "Member successfully Added", "Member Added",
					JOptionPane.INFORMATION_MESSAGE);
			
			frame.setVisible(false);
			membership_controller window = new membership_controller();
			window.frame.setVisible(true);
			window.generateHistoryTable();
			window.frame.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent e) {
					frame.setVisible(true);
				}
			});
			
		} else {
			JOptionPane.showMessageDialog(null, "System Error. Please Contact Admin", "Alert",
					JOptionPane.WARNING_MESSAGE);
		}
	}
	
	@Override
	public void BackClicked(ActionEvent e) {
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
		} catch (Exception er) {
			er.printStackTrace();
			frame.setVisible(true);
		}
		
	}

	@Override
	public void onClick_btnDel(ActionEvent e) {
		try {

			int selectedRow = table.getSelectedRow();
			int ID = (int) table.getModel().getValueAt(selectedRow, 0);

			Model.Membership del = new Membership();

			del.setID(ID);

			if (del.delete()) {
				JOptionPane.showMessageDialog(null, "Member successfully deleted", "Success",
						JOptionPane.INFORMATION_MESSAGE);
				generateHistoryTable();
			} else {
				JOptionPane.showMessageDialog(null, "System Error. Please Contact Admin", "Alert",
						JOptionPane.WARNING_MESSAGE);
			}
		} catch (Exception en) {
			JOptionPane.showMessageDialog(null, "Please select Member to delete");
		}
	}

	public void onClick_btnUpdate(ActionEvent e) {

		try {

			int selectedRow = table.getSelectedRow();
			int ID = (int) table.getModel().getValueAt(selectedRow, 0);

			frame.setVisible(false);
			try {
				MemberUpdateController window = new MemberUpdateController(ID);
				window.frame.setVisible(true);
				window.frame.addWindowListener(new WindowAdapter() {
					public void windowClosed(WindowEvent e) {
						frame.setVisible(true);
					}
				});
			} catch (Exception en) {
				en.printStackTrace();
				frame.setVisible(true);
				generateHistoryTable();
			}

		} catch (Exception en) {
			JOptionPane.showMessageDialog(null, "Please select Member to edit");
		}
	}

	public void onClick_btnreset(ActionEvent e) {
		Name.setText("");
		Email.setText("");
		hour.setText("");

	}

	@Override
	public void onClick_mouseClicked(MouseEvent e) {
		Name.setEnabled(true);
		Email.setEnabled(true);
		hour.setEnabled(true);
		try {

			int selectedRow = table.getSelectedRow();
			int id = (int) table.getModel().getValueAt(selectedRow, 0);
			List<Membership> dataArray = datamodel.membership;
			table = new JTable(new ActiveMembershipTableModel(dataArray));
			JTableHeader header = table.getTableHeader();

			String add2 = rs.getString("Name");
			Name.setText(add2);
			String add3 = rs.getString("Email");
			Email.setText(add3);
			String add4 = rs.getString("HourSpend");
			hour.setText(add4);

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}

}
