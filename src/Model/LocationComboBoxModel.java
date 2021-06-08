package Model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

@SuppressWarnings("rawtypes")
public class LocationComboBoxModel implements ComboBoxModel{

	List<Location> location = new ArrayList<Location>();
	Location selected = null;
	
	public LocationComboBoxModel(List<Location> location) {
		this.location = location;
	}
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return location.size();
	}

	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return location.get(index);
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
		selected = (Location)anItem;
	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		return selected;
	}
}
