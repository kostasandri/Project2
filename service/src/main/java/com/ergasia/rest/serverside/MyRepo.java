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
		
		try {
			String req = "SELECT count(*) FROM Orders;";
			PreparedStatement statement = con.prepareStatement(req);
			ResultSet result = statement.executeQuery();
			result.next();
			return Integer.parseInt(result.getString(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public ArrayList<String> fetchClient() throws Exception {
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
	
	public ArrayList<String> fetchItem() throws Exception {
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
	
	public static void updateItemQuantity(int quantity, int infoID, String colour) throws Exception {
		try {
			String req = "UPDATE ItemInfo SET quantity=? WHERE InfoID=? AND colour=?; ";
			
			PreparedStatement statement = con.prepareStatement(req);
			statement.setInt(1, quantity);
			statement.setInt(2, infoID);
			statement.setString(3, colour);
			System.out.println(statement);
			statement.execute();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void createEmptyCard(int oID, int cID) { // order ID, client ID
		try {
			String sql = "INSERT INTO Orders values (?,?)";
			
				PreparedStatement st = con.prepareStatement(sql);
				st.setInt(1, oID);
				st.setInt(2, cID);
				st.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
