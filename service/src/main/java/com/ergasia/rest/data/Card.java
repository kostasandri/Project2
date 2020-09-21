package com.ergasia.rest.data;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.ergasia.rest.serverside.MyRepo;

@XmlRootElement
public class Card {

	private int OrderID;
	private int ClientID;
	//private List<Product> products;

	public Card(int ClientID) {
		this.ClientID=ClientID;
		this.setOrderID(MyRepo.getOrdersTotalRows() + 1);
		//products = new ArrayList<Product>();
		MyRepo.createEmptyCard(OrderID, ClientID);
	}

	/*
	 * public void addProduct(int itemID, String colour) { products.add(new
	 * Product(itemID, colour)); }
	 */

	public int getOrderID() {
		return OrderID;
	}

	public void setOrderID(int orderID) {
		OrderID = orderID;
	}

	@Override
	public String toString() {
		return "Card [OrderID=" + OrderID + ", ClientID=" + ClientID + /* ", products=" + products + */ "]";
	}
	
}
