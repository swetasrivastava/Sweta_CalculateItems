package com.test.calulation;

import java.util.ArrayList;
import java.util.HashMap;

public class CalculateItems {
	
	/**
	 * purchase with validations
	 * @param basketItems items to be purchased
	 * @param availableItems items available in store
	 * @return total amount of items in basket
	 * @throws Exception proper exception message in case of exception
	 */
	public int checkOutItems(ArrayList<String> basketItems, HashMap<String,Integer> availableItems) throws Exception{
	int totalAmount = 0;	
	try {
				if (null == availableItems || availableItems.isEmpty()) 
					throw new Exception("Store is empty. Please come later."); //checks if available item list is empty
				totalAmount = getTotalCost(basketItems, availableItems);
				System.out.println("Total amount of Basket items is: " 
						+ totalAmount); //displays final cost when no exception
				
			} catch (Exception e) {
				System.out.println(e.getLocalizedMessage());
				throw e;
			}
		return totalAmount;
	}
	
	/**
	 * sum of cost of items present in basket
	 * @param basketItems items to be purchased
	 * @param availableItems items available in store
	 * @return total amount of items in basket
	 * @throws Exception proper exception message in case of exception
	 */
	private Integer getTotalCost(ArrayList<String> basketItems, HashMap<String,Integer> availableItems) throws Exception {

		Integer totalPrice = 0;
		Integer itemPrice = 0;
		if (null == basketItems || basketItems.isEmpty())
			throw new Exception("Please add some items in basket"); //exception if basket is empty
		for (String basketItem : basketItems) {
			if (null == (itemPrice = availableItems.get(basketItem)))
				throw new Exception("Item "	+ basketItem + " in the basket is not from this market, cannot be billed."); // exception if basket item has items which are not from store
			if (totalPrice > (totalPrice += itemPrice))
				throw new Exception("Wrong price for " + basketItem + " in system"); //exception if any item in store have negative value
		}
		return totalPrice;
	}

}
