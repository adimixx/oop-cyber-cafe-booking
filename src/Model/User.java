package Model;

import Dependency.DataFlow;
import Dependency.Main;

public class User extends Main implements DataFlow{
	public int ID;
	public String username, password;
	
	public User() {
		ID = 0;
	}
	
	public User(int ID, String username, String password) {
		this.ID = ID;
		this.username = username;
		this.password = password;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getID() {
		return ID;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	@Override
	public boolean insert() {
		try {
			sql = "INSERT INTO User (username,password) values (?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			if (ps.executeUpdate() > 0)
			{
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
		try {
			sql = "UPDATE User SET username = ? , password = ? where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, String.valueOf(ID));

			if (ps.executeUpdate() > 0)
			{
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
		try {
			sql = "DELETE FROM User where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, String.valueOf(ID));

			if (ps.executeUpdate() > 0)
			{
				datamodel.refreshData();
				return true;
			}
		}
		catch (Exception e){
		}
		return false;	
	}
	
}
