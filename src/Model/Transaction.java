package Model;

import java.sql.Types;
import java.util.Date;
import Dependency.DataFlow;
import Dependency.Main;

public class Transaction extends Main implements DataFlow {

	int ID;
	Date startDate, endDate;
	boolean isActive;
	double price;
	Computer computer;
	Membership member;

	public Transaction() {
		ID = 0;
	}

	public Transaction(int ID, Date startDate, Date endDate, boolean isActive, double price, Computer computer,
			Membership member) {
		this.ID = ID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.isActive = isActive;
		this.price = price;
		this.computer = computer;
		this.member = member;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	public void setMembership(Membership member) {
		this.member = member;
	}

	public int getID() {
		return ID;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public double getPrice() {
		return price;
	}

	public Computer getComputer() {
		return computer;
	}

	public Membership getMembership() {
		return member;
	}

	@Override
	public boolean insert() {
		try {
			sql = "insert into Transaction (ComputerID, StartDate, EndDate, IsActive, Price, MembershipID) values (?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, computer.getID());
			ps.setTimestamp(2, new java.sql.Timestamp(startDate.getTime()));

			if (endDate == null)
				ps.setNull(3, Types.DATE);
			else
				ps.setTimestamp(3, new java.sql.Timestamp(endDate.getTime()));

			ps.setBoolean(4, isActive);

			if (price == 0)
				ps.setNull(5, Types.DOUBLE);
			else
				ps.setDouble(5, price);

			if (member == null)
				ps.setNull(6, Types.INTEGER);
			else
				ps.setDouble(6, member.ID);

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
			sql = "update Transaction set EndDate = ?, IsActive = ?, Price = ? where ID = ?";
			ps = conn.prepareStatement(sql);
			ps.setTimestamp(1, new java.sql.Timestamp(endDate.getTime()));
			ps.setBoolean(2, isActive);
			ps.setDouble(3, price);
			ps.setInt(4, ID);

			if (ps.executeUpdate() > 0) {
				if (member != null && !isActive) {
					sql = "update Membership set HourSpend = HourSpend + ? where ID = ?";
					ps = conn.prepareStatement(sql);
					ps.setInt(1, (int) price / 2);
					ps.setInt(2, member.ID);
				}
				ps.executeUpdate();
				datamodel.refreshData();
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}

}
