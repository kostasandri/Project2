package com.ergasia.rest.serverside;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ergasia.rest.data.Card;
import com.ergasia.rest.data.TempStore;
import com.ergasia.rest.exception.quantityException;

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

	public static boolean updateItemQuantity(int currentItemQuantity, int quantity, int itemID, String colour) {
		try {

			String req1 = "SELECT LQuantity FROM ItemInfo WHERE InfoID=? AND colour=? ;";
			System.out.println(req1);
			PreparedStatement st1 = con.prepareStatement(req1);
			st1.setInt(1, itemID);
			st1.setNString(2, colour);
			ResultSet result = st1.executeQuery();
			result.next();
			int current_quantity = Integer.parseInt(result.getString(1));

			if (current_quantity >= quantity && current_quantity >= quantity) {
				String req2 = "UPDATE ItemInfo SET LQuantity=? WHERE InfoID=? AND colour=?; ";
				System.out.println("req 2 " + req2);

				PreparedStatement statement = con.prepareStatement(req2);
				if (currentItemQuantity == 0) {
					statement.setInt(1, current_quantity - quantity);
				} else {
					if (currentItemQuantity > quantity) { // currentItemQuantity -> posotita antikeimenoi stin karta,
															// quantity -> ti posotita thelw na valw
						statement.setInt(1, current_quantity - (quantity - currentItemQuantity));
					} else if (currentItemQuantity < quantity) {
						statement.setInt(1, current_quantity + (quantity - currentItemQuantity));
					} else {
						statement.setInt(1, current_quantity);
					}
				}

				statement.setInt(2, itemID);
				statement.setString(3, colour);
				statement.executeUpdate();
				return true;
			} else {
				throw new quantityException("Quantity remaining is: " + current_quantity);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
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

	public static List<Card> getHistory() {
		

		String req = "SELECT Orders.OrderID, Clients.ClientID, Items.ItemID, ItemInfo.colour, SumOrder.Quantity FROM Orders, Clients, SumOrder, Items, ItemInfo  WHERE SumOrder.OrderID=Orders.OrderID AND Clients.ClientID=Orders.ClientID AND Items.ItemID=SumOrder.ItemID AND Items.ItemInfo=ItemInfo.InfoID;";
		Card c;
		List<Card> cards = null;
		try {
			cards = new ArrayList<Card>();
			PreparedStatement statement = con.prepareStatement(req);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				System.out.println(result.getInt("ItemID") + " #1");
				System.out.println(result.getInt("Quantity") + "#2");
				System.out.println(result.getString("colour") + "#3");
				System.out.println(result.getString("ClientID") + "#4");
				
				c = new Card();		
				c.setOrderID(result.getInt("OrderID"));
				c.setClientID(result.getInt("ClientID"));
				c.addProduct(result.getInt("ItemID"), result.getString("colour"), result.getInt("Quantity"));
				cards.add(c);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cards;
	}
}
