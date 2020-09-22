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
	
	public Card() {
		
	}

	public Card(int ClientID) {
		this.ClientID=ClientID;
		this.setOrderID(MyRepo.getOrdersTotalRows() + 1);
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
	
}
