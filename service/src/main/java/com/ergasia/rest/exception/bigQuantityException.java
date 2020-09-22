package com.ergasia.rest.exception;

public class bigQuantityException extends Exception{
	
	public bigQuantityException(String message) {
		super("Too big number for quantity.");
	}
}
