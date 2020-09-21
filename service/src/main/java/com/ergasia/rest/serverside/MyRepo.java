package com.ergasia.rest.serverside;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MyRepo {

	static Connection con;

	static {
		String url = "jdbc:mysql://mysql:3306/Project2";
		String username = "Lazaros";
		String password = "lazaros";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Connected!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

	public static int getOrdersTotalRows() {
		String req = "SELECT COUNT(*) FROM Orders;";
		try {
			PreparedStatement statement = con.prepareStatement(req);
			ResultSet result = statement.executeQuery();
			//System.out.println(result.getString("count(*)"));
			//System.out.println(result.getHoldability());
			System.out.println(result.getFetchSize());
			return 7;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public ArrayList<String> fetchData() throws Exception {
		try {
			String req = "SELECT Firstname, Lastname FROM Clients";
			PreparedStatement statement = con.prepareStatement(req);
			ResultSet result = statement.executeQuery();
			ArrayList<String> array = new ArrayList<String>();
			while (result.next()) {
				System.out.println(result.getString("Firstname"));
				array.add(result.getString("Firstname"));
				array.add(result.getString("Lastname"));
			}
			return array;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
