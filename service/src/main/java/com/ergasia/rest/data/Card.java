package com.ergasia.rest.data;

import java.util.ArrayList;
import java.util.List;

import com.ergasia.rest.serverside.MyRepo;

public class Card {

	private int OrderID;
	private List<Product> products;

	public Card() {
		this.setOrderID(MyRepo.getOrdersTotalRows() + 1);
		products = new ArrayList<>();
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
