package com.ergasia.rest.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {

	private int itemID;
	private String colour;
	private int quantity;

	public Product() {
	}

	public Product(int itemID, String colour, int quantity) {
		this.itemID = itemID;
		this.colour = colour;
		this.quantity = quantity;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
