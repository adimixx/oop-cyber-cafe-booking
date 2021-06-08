package Model;

import Dependency.DataFlow;
import Dependency.Main;

public class Computer extends Main implements DataFlow {
	public int ID;
	public String name;
	Location location;
	Computer computer;
	
	public Computer() {
		ID = 0;
	}
	
	public Computer(int ID, String name, Location location) {
		this.ID = ID;
		this.name = name;
		this.location = location;
	}
	
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public void setComputer(Computer computer)
	{
		this.computer = computer;
	}
	
	public int getID() {
		return ID;
	}
	
	public String getName() {
		return name;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public Computer getComputer() {
		return computer;
	}
	
	@Override
	public boolean insert() {
		// TODO Auto-generated method stub
		try {
			sql = "insert into Computer (Name,LocationID) values (?,?)";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, name);
			ps.setInt(2, location.ID);
			
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
		try {
			sql = "update Computer SET LocationID = ? where ID = ?";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, location.ID);
			ps.setInt(2, computer.ID);
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
	public boolean delete() {
		// TODO Auto-generated method stub
		try {
			sql = "delete from Computer where ID = ?";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, computer.ID);
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
