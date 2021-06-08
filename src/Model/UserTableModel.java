package Model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class UserTableModel extends AbstractTableModel {

	List<User> users = new ArrayList<User>();
	public String[] columnNames = {"ID","Username","Password"};
	
	public UserTableModel(List<User> users) {
		this.users = users;
	}
	
	@Override
    public String getColumnName(int columnIndex){
         return columnNames[columnIndex];
    }
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return users.size();

	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		User user = users.get(rowIndex);
        switch (columnIndex) {
        	case 0:
        		return user.getID();
            case 1:
                return user.getUsername();
            case 2:
                return user.getPassword();
            case 3:
                return user;

           }
           return null;
	}
	
	   @Override
	   public Class<?> getColumnClass(int columnIndex){
	       return getValueAt(0,columnIndex).getClass();
	   }

}
