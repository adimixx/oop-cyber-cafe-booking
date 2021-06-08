package Model;

import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ActiveTransactionTableModel extends AbstractTableModel{
	List<Transaction> trans = new ArrayList<Transaction>();
	public String[] columnNames = { "Computer Name", "Start Date",
             "End Date", "Price", "Membership email"};
	
	public ActiveTransactionTableModel(List<Transaction> trans) {
		this.trans = trans;
	}
	
	@Override
    public String getColumnName(int columnIndex){
         return columnNames[columnIndex];
    }
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return trans.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}
	
	@Override
    public Object getValueAt(int rowIndex, int columnIndex) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");  
        Transaction transaction = trans.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return transaction.getComputer().getName();
            case 1:
                return dateFormat.format(transaction.getStartDate());
            case 2:
                return (transaction.getEndDate() != null) ? dateFormat.format(transaction.getEndDate()) : "-";
            case 3:
                return (transaction.getPrice() != 0) ? String.valueOf(transaction.getPrice()) : "Open";
            case 4:
                return (transaction.getMembership() != null) ? transaction.getMembership().email : "-";
            case 5: 
                return transaction;
           }
           return null;
   }

   @Override
   public Class<?> getColumnClass(int columnIndex){
       return getValueAt(0,columnIndex).getClass();
   }

}
