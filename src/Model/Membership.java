package Model;

import Dependency.DataFlow;
import Dependency.Main;

public class Membership extends Main implements DataFlow {

	public int ID;
	public String name;
	public String email;
	public String hourSpend;

	public Membership() {
		ID = 0;
	}

	public Membership(int ID, String name, String email, String hourSpend) {
		this.ID = ID;
		this.name = name;
		this.email = email;
		this.hourSpend = hourSpend;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String gethourSpend() {
		return hourSpend;
	}

	public void sethourSpend(String hourSpend) {
		this.hourSpend = hourSpend;
	}

	@Override
	public boolean insert() {
		try {
			sql = "INSERT INTO membership (Name,Email,HourSpend) values (?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, hourSpend);

			if (ps.executeUpdate() > 0) {
				datamodel.refreshData();
				return true;
			}
		} catch (Exception e) {
		}
		return false;

	}

	@Override
	public boolean update() {
		try {
			sql = "UPDATE membership SET Name = ? , Email = ? , HourSpend = ? where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, hourSpend);
			ps.setString(4, String.valueOf(ID));

			if (ps.executeUpdate() > 0) {
				datamodel.refreshData();
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}

	@Override
	public boolean delete() {
		try {
			sql = "DELETE FROM membership where ID = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, String.valueOf(ID));

			if (ps.executeUpdate() > 0) {
				datamodel.refreshData();
				return true;
			}
		} catch (Exception e) {
		}
		return false;

	}

}
