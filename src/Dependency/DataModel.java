package Dependency;

import Model.*;
import java.util.ArrayList;
import java.util.List;

import java.sql.*;

public class DataModel {
	public List<User> user = new ArrayList<User>();
	public List<Membership> membership = new ArrayList<Membership>();
	public List<Transaction> transaction = new ArrayList<Transaction>();
	public List<Computer> computer = new ArrayList<Computer>();
	public List<Location> location = new ArrayList<Location>();

	Connection conn;

	public DataModel(Connection conn) {
		this.conn = conn;
		try {
			loadData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void loadData() throws SQLException {
		user.clear();
		membership.clear();
		transaction.clear();
		computer.clear();
		location.clear();

		String query;

		query = "SELECT ID,Username,Password FROM user";
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery(query);
		while (rset.next()) {
			User us = new User(rset.getInt(1), rset.getString(2), rset.getString(3));
			user.add(us);
		}

		query = "SELECT ID,name,email,hourSpend FROM membership";
		stmt = conn.createStatement();
		rset = stmt.executeQuery(query);
		while (rset.next()) {
			Membership us = new Membership(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4));
			membership.add(us);
		}

		query = "SELECT ID,name FROM location";
		stmt = conn.createStatement();
		rset = stmt.executeQuery(query);
		while (rset.next()) {
			Location us = new Location(rset.getInt(1), rset.getString(2));
			location.add(us);
		}

		query = "SELECT ID,Name,LocationID FROM computer";
		stmt = conn.createStatement();
		rset = stmt.executeQuery(query);
		while (rset.next()) {
			final int me = rset.getInt(3);
			Location loc = location.stream().filter(x -> x.ID == me).findFirst().get();
			Computer us = new Computer(rset.getInt(1), rset.getString(2), loc);
			computer.add(us);
		}

		query = "select ID, ComputerID, StartDate, EndDate, IsActive, Price, MembershipID from transaction";
		stmt = conn.createStatement();
		rset = stmt.executeQuery(query);
		while (rset.next()) {
			Membership mem;
			final int me = rset.getInt(2);

			final int me2 = rset.getInt(7);
			if (me2 != 0)
				mem = membership.stream().filter(x -> x.getID() == me2).findFirst().get();
			else
				mem = null;

			Computer cs = computer.stream().filter(x -> x.getID() == me).findFirst().get();
			Transaction us = new Transaction(rset.getInt(1), rset.getTimestamp(3), rset.getTimestamp(4),
					rset.getBoolean(5), rset.getDouble(6), cs, mem);
			transaction.add(us);
		}

		rset.close();
		stmt.close();
	}

	public void refreshData() {
		try {
			loadData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
