package Dependency;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	String dbName, connectionURL, username, password, timezone;
	public static DataModel globDataModel;
	public static Connection Connection;

	public DatabaseConnection() {

		connectionURL = "jdbc:mysql://localhost:3306/";
		dbName = "oop_miniproject";
		username = "root";
		password = "";
		timezone = "?serverTimezone=Asia/Kuala_Lumpur";
		

	}

	public Connection getConnection() throws Exception {
		Connection conn = DriverManager.getConnection(connectionURL + dbName + timezone, username, password);
		return conn;
	}

	protected static void initDBConnection() {
		DatabaseConnection db = new DatabaseConnection();
		try {
			Connection = db.getConnection();
			if (Connection != null) {
				System.out.println("Database Connected");
				globDataModel = new DataModel(Connection);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
}
