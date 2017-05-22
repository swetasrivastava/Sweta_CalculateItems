package com.test.calulation;

import java.util.ArrayList;
import java.util.HashMap;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class CalculateItemsTest extends TestCase {
	private HashMap<String, Integer> availableItems;
	private ArrayList<String> basketItems;
	CalculateItems calculateItems;

	@Before
	public void setUp() {

		calculateItems = new CalculateItems();
		availableItems = new HashMap<String, Integer>();
		basketItems = new ArrayList<String>();
		setAvailableItems();
		setBasketItems();

	}

	@Test
	public void testGetTotalCost() throws Exception {

		int totalAmount = calculateItems.checkOutItems(basketItems,
				availableItems);
		int sample = 90;
		assertEquals(sample, totalAmount);

	}

	@Test
	public void testGetTotalCostEmptyBasketException() throws Exception {
		Throwable e = null;

		basketItems = new ArrayList<String>();

		try {
			calculateItems.checkOutItems(basketItems, availableItems);
		} catch (Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof Exception);
		String errorMessage = "Please add some items in basket";
		assertEquals(errorMessage, e.getLocalizedMessage());

	}

	@Test
	public void testGetTotalCostNullBasketException() throws Exception {
		Throwable e = null;
		basketItems = null;

		try {
			calculateItems.checkOutItems(basketItems, availableItems);
		} catch (Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof Exception);
		String errorMessage = "Please add some items in basket";
		assertEquals(errorMessage, e.getLocalizedMessage());

	}

	@Test
	public void testGetTotalCostEmptyStoreException() throws Exception {
		Throwable e = null;
		availableItems = new HashMap<String, Integer>();
		try {
			calculateItems.checkOutItems(basketItems, availableItems);
		} catch (Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof Exception);
		String errorMessage = "Store is empty. Please come later.";
		assertEquals(errorMessage, e.getLocalizedMessage());

	}

	@Test
	public void testGetTotalCostNullStoreException() throws Exception {
		Throwable e = null;
		availableItems = null;

		try {
			calculateItems.checkOutItems(basketItems, availableItems);
		} catch (Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof Exception);
		String errorMessage = "Store is empty. Please come later.";
		assertEquals(errorMessage, e.getLocalizedMessage());

	}

	@Test
	public void testGetTotalCostNegativePriceException() throws Exception {

		Throwable e = null;
		availableItems.put("Apples", -30);

		try {
			calculateItems.checkOutItems(basketItems, availableItems);
		} catch (Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof Exception);
		String errorMessage = "Wrong price for Apples in system";
		assertEquals(errorMessage, e.getLocalizedMessage());

	}

	@Test
	public void testGetTotalCostWrongItemException() throws Exception {

		Throwable e = null;
		basketItems.add("Guava");

		try {
			calculateItems.checkOutItems(basketItems, availableItems);
		} catch (Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof Exception);
		String errorMessage = "Item Guava in the basket is not from this market, cannot be billed.";
		assertEquals(errorMessage, e.getLocalizedMessage());

	}

	private void setAvailableItems() {
		availableItems = new HashMap<String, Integer>();

		availableItems.put("Bananas", 10);
		availableItems.put("Oranges", 20);
		availableItems.put("Apples", 30);
		availableItems.put("Lemons", 20);
		availableItems.put("Peaches", 10);

	}

	private void setBasketItems() {
		basketItems = new ArrayList<String>();

		basketItems.add("Lemons");
		basketItems.add("Bananas");
		basketItems.add("Apples");
		basketItems.add("Bananas");
		basketItems.add("Lemons");
	}

}
