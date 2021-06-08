package Model;


import Dependency.DataFlow;
import Dependency.Main;

public class Location extends Main implements DataFlow{

	public int ID;
	public String name;
	Location location;
	
	public Location() {
		ID = 0;
	}
	
	public Location(int ID, String name) {
		this.name = name;
		this.ID = ID;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setLocation(Location location)
	{
		this.location = location;
	}
	
	public String getName() {
		return name;
	}
	
	public int getID() {
		return ID;
	}
	
	public Location getLocation()
	{
		return location;
	}

	@Override
	public boolean insert() {
		// TODO Auto-generated method stub
		try {
			sql = "insert into Location (Name) values (?)";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, name);
			
			if (ps.executeUpdate() > 0) {
				datamodel.refreshData();
				return true;
			}
		}
		catch (Exception e){
		}
		return false;
	}

	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
				try {
					sql = "delete from Location where ID = ?";
					ps = conn.prepareStatement(sql);
					
					ps.setInt(1, location.ID);
					//ps.setString(2, name);
					
					if (ps.executeUpdate() > 0) {
						datamodel.refreshData();
						return true;
					}
				}
				catch (Exception e){
				}
				return false;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
