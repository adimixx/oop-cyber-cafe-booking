package Dependency;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Controller.LoginController;

public class Main {

	/**
	 * Launch the application.
	 */
	public String sql;
	public PreparedStatement ps;
	public DataModel datamodel;
	public Connection conn;
	public ResultSet rs ;

	public Main() {
		datamodel = DatabaseConnection.globDataModel;
		conn = DatabaseConnection.Connection;
	}
	
	public static void main(String args[]) {
		DatabaseConnection.initDBConnection();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginController window = new LoginController();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
