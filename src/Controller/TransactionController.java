package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import Model.ActiveTransactionTableModel;
import View.Transaction;

public class TransactionController extends Transaction {
	private boolean isHistory;

	@Override
	public void generateActiveTable() {
		var dataArray = datamodel.transaction.stream().filter(x -> x.getIsActive()).collect(Collectors.toList());
		table = new JTable(new ActiveTransactionTableModel(dataArray));
		JTableHeader header = table.getTableHeader();
		header.setBackground(Color.black);
		header.setForeground(Color.white);
		scrollPane.setViewportView(table);
		lblActiveComputers.setText("Active Computer Sessions: ");
		btnHistoryActive.setText("View History");
		isHistory = false;
	}

	@Override
	public void generateHistoryTable() {
		var dataArray = datamodel.transaction.stream().filter(x -> !x.getIsActive()).collect(Collectors.toList());
		table = new JTable(new ActiveTransactionTableModel(dataArray));
		JTableHeader header = table.getTableHeader();
		header.setBackground(Color.black);
		header.setForeground(Color.white);
		scrollPane.setViewportView(table);
		lblActiveComputers.setText("Session History: ");
		btnHistoryActive.setText("View Active");
		isHistory = true;
	}

	@Override
	public void onClick_btnHistoryActive(ActionEvent e) {
		if (!isHistory)
			generateHistoryTable();
		else
			generateActiveTable();
	}

	@Override
	public void onClick_btnNewCustomer(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			Transaction_NewController ts = new Transaction_NewController();
			frame.setVisible(false);
			ts.frame.setVisible(true);
			ts.frame.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent e) {
					frame.setVisible(true);
					generateActiveTable();
				}
			});
		} catch (Exception e1) {
			frame.setVisible(true);
		}

	}

	@Override
	public void onClick_btnAddHour(ActionEvent e) {
		// TODO Auto-generated method stub
		int selectedRow = table.getSelectedRow();
		if (selectedRow < 0) {
			JOptionPane.showMessageDialog(null, "Please select an active transaction!", "Alert", JOptionPane.WARNING_MESSAGE);
		} else {
			var selectedTransaction = (Model.Transaction) table.getModel().getValueAt(selectedRow, 5);
			if (!selectedTransaction.getIsActive()) {
				JOptionPane.showMessageDialog(null,
						"Selected transaction is not active. Please select active transaction", "Alert",
						JOptionPane.WARNING_MESSAGE);
			} else if (selectedTransaction.getEndDate() == null) {
				JOptionPane.showMessageDialog(null, "Selected transaction is open hour!", "Alert",
						JOptionPane.WARNING_MESSAGE);
			} else {
				Transaction_AddHourController trs = new Transaction_AddHourController(selectedTransaction);
				trs.frame.setVisible(true);
				frame.setVisible(false);
				trs.frame.addWindowListener(new WindowAdapter() {
					public void windowClosed(WindowEvent e) {
						generateActiveTable();
						frame.setVisible(true);
					}
				});
			}
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
	public void onClick_btnEndHour(ActionEvent e) {
		// TODO Auto-generated method stub
		int selectedRow = table.getSelectedRow();
		if (selectedRow < 0) {
			JOptionPane.showMessageDialog(null, "Please select an active transaction!", "Alert", JOptionPane.WARNING_MESSAGE);
		} else {
			var selectedTransaction = (Model.Transaction) table.getModel().getValueAt(selectedRow, 5);
			if (!selectedTransaction.getIsActive()) {
				JOptionPane.showMessageDialog(null,
						"Selected transaction is not active. Please select active transaction", "Alert",
						JOptionPane.WARNING_MESSAGE);
			}  else {
				Transaction_EndSessionController trs = new Transaction_EndSessionController(selectedTransaction);
				trs.frame.setVisible(true);
				frame.setVisible(false);
				trs.frame.addWindowListener(new WindowAdapter() {
					public void windowClosed(WindowEvent e) {
						generateActiveTable();
						frame.setVisible(true);
					}
				});
			}
		}
	}
}
