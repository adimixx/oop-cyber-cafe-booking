package Model;

import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ActiveMembershipTableModel extends AbstractTableModel{
	List<Membership> trans = new ArrayList<Membership>();
	public String[] columnNames = { "ID", "Name",
             "Email", "Hour Spend"};
	
	public ActiveMembershipTableModel(List<Membership> trans) {
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
		
		Membership membership = trans.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return membership.getID();
            case 1:
                return membership.getName();
            case 2:
                return membership.getEmail();
            case 3:
              return membership.gethourSpend();
            case 4: 
                return membership;
           
           }
		return null;
          
   }

   @Override
   public Class<?> getColumnClass(int columnIndex){
       return getValueAt(0,columnIndex).getClass();
   }

}
