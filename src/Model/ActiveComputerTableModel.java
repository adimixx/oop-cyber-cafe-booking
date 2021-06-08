package Model;

import java.util.List;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ActiveComputerTableModel extends AbstractTableModel{
	List<Computer> trans = new ArrayList<Computer>();
	public String[] columnNames = { "Computer Name", "Location"};
	
	public ActiveComputerTableModel(List<Computer> trans) {
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
        Computer computer = trans.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return computer.getName();
            case 1:
            	return computer.getLocation().name;
            case 2:
                return computer;
           }
           return null;
   }

   @Override
   public Class<?> getColumnClass(int columnIndex){
       return getValueAt(0,columnIndex).getClass();
   }

}
