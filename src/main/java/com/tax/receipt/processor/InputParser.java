package com.tax.receipt.processor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

import com.tax.receipt.model.Purchase;
import com.tax.receipt.util.Constants;

public class InputParser {
	private List<Purchase> purchaseList = new ArrayList<>();

	public InputParser(String cart) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(cart));
			String line;
			Purchase purchase = null;
			while ((line = reader.readLine()) != null) {
				if ("".equals(line.trim()))
					continue;
				if (line.startsWith("Input")) {
					purchase = new Purchase();
					purchaseList.add(purchase);
					continue;
				}
				int quantity = getQuantity(line);
				String name = getName(line);
				Double price = getPrice(line);
				purchase.addItem(quantity, name, price);
			}
			reader.close();
		} catch (Exception e) {
			System.err.println("Error processing the file : " + cart + " " + e.getMessage());
		}
	}

	public List<Purchase> getPurchaseList() {
		return this.purchaseList;
	}

	private int getQuantity(String quantity) {
		Matcher matcher = Constants.QUANTITY_PATTERN.matcher(quantity);
		matcher.find();
		return Integer.parseInt(matcher.group(0));
	}

	private String getName(String name) {
		Matcher matcher = Constants.NAME_PATTERN.matcher(name);
		matcher.find();
		return matcher.group(0);
	}

	private Double getPrice(String price) {
		Matcher matcher = Constants.PRICE_PATTERN.matcher(price);
		matcher.find();
		return Double.parseDouble(matcher.group(0));
	}
}
