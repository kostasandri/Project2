package com.ergasia.rest.serverside;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MyRepo {

	Connection con;

	public MyRepo() {
		String url = "jdbc:mysql://192.168.1.111:3306/testdb";
		String username = "myuser";
		String password = "toor";
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

	public ArrayList<String> fetchData() throws Exception {
		try {
			System.out.println("fetch 1");
			String req = "SELECT firstname, lastname FROM MyGuests";
			PreparedStatement statement = con.prepareStatement(req);
			System.out.println("fetch 2");
			ResultSet result = statement.executeQuery();
			System.out.println("fetch 3");
			ArrayList<String> array = new ArrayList<String>();
			while (result.next()) {
				System.out.println(result.getString("firstname"));
				array.add(result.getString("firstname"));
				array.add(result.getString("lastname"));
			}
			return array;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
