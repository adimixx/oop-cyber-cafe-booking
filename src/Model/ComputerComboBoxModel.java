package Model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

@SuppressWarnings("rawtypes")
public class ComputerComboBoxModel implements ComboBoxModel{

	List<Computer> computer = new ArrayList<Computer>();
	Computer selected = null;
	
	public ComputerComboBoxModel(List<Computer> computer) {
		this.computer = computer;
	}
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return computer.size();
	}

	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return computer.get(index);
}

	@Override
	public void addListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSelectedItem(Object anItem) {
		// TODO Auto-generated method stub
		selected = (Computer)anItem;
	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		return selected;
	}
}
