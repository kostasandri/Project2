package com.ergasia.rest.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {

	private int itemID;
	private String colour;

	public Product() {
	}

	public Product(int itemID, String colour) {
		this.itemID = itemID;
		this.colour = colour;
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

}
