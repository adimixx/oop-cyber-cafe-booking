package Model;

import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ActiveLocationTableModel extends AbstractTableModel{
	List<Location> loca = new ArrayList<Location>();
	public String[] columnNames = { "Name"};
	
	public ActiveLocationTableModel(List<Location> loca) {
		this.loca = loca;
	}
	
	@Override
    public String getColumnName(int columnIndex){
         return columnNames[columnIndex];
    }
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return loca.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}
	
	@Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Location location = loca.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return location.getName();
            case 1:
                return location;
           }
           return null;
   }

   @Override
   public Class<?> getColumnClass(int columnIndex){
       return getValueAt(0,columnIndex).getClass();
   }

}
