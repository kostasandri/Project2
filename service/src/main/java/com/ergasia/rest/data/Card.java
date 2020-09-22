package com.ergasia.rest.data;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.ergasia.rest.serverside.MyRepo;

@XmlRootElement
public class Card {

	private int OrderID;
	private int ClientID;
	private List<Product> products;
	private static int totalCards = 0;

	public Card() {

	}

	public Card(int ClientID) {
		if (totalCards == 0)
			setTotalCards(MyRepo.getOrdersTotalRows() + 1);
		else
			setTotalCards(totalCards++);

		this.ClientID = ClientID;
		this.setOrderID(getTotalCards());
		products = new ArrayList<Product>();
	}

	public void addProduct(int itemID, String colour, int quantity) {
		products.add(new Product(itemID, colour, quantity));
	}

	public int getOrderID() {
		return OrderID;
	}

	public void setOrderID(int orderID) {
		OrderID = orderID;
	}

	public int getClientID() {
		return ClientID;
	}

	public void setClientID(int clientID) {
		ClientID = clientID;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public static int getTotalCards() {
		return totalCards;
	}

	public static void setTotalCards(int totalCards) {
		Card.totalCards = totalCards;
	}

}
