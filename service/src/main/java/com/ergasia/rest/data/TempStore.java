package com.ergasia.rest.data;

import java.util.ArrayList;
import java.util.List;

public class TempStore {
	
	private static List<Card> cards;
	
	static {
		cards = new ArrayList<>();
	}

	public static List<Card> getCards() {
		return cards;
	}
	
	public static void addCard(Card c) {
		cards.add(c);
	}

	public static Card getCard(int oID) {
		for(Card c : cards) {
			if(c.getOrderID() == oID) 
			{
				System.out.println("in getCard");
				return c;			
			}
		}
		return null;
	}
}
