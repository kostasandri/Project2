package com.ergasia.rest.data;

public class Product {

	private int itemID;
	private String colour;
	
	public Product(int itemID, String colour) {
		this.itemID=itemID;
		this.colour=colour;
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
