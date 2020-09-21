package com.ergasia.rest.data;

import java.util.ArrayList;
import java.util.List;

import com.ergasia.rest.serverside.MyRepo;

public class Card {

	private int OrderID;
	private int ClientID;
	private List<Product> products;

	public Card(int ClientID) {
		this.ClientID=ClientID;
		this.setOrderID(MyRepo.getOrdersTotalRows() + 1);
		products = new ArrayList<>();
		MyRepo.createEmptyCard(OrderID, ClientID);
	}

	public void addProduct(int itemID, String colour) {
		products.add(new Product(itemID, colour));
	}

	public int getOrderID() {
		return OrderID;
	}

	public void setOrderID(int orderID) {
		OrderID = orderID;
	}
}
