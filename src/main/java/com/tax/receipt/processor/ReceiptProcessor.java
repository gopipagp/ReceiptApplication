package com.tax.receipt.processor;

import java.io.File;
import java.util.List;

import com.tax.receipt.model.Item;
import com.tax.receipt.model.Purchase;
import com.tax.receipt.util.Constants;

public class ReceiptProcessor {
	public static void processFile(String cart) {
		try {
			if (new File(cart).exists()) {
				InputParser parser = new InputParser(cart);
				List<Purchase> purchaseList = parser.getPurchaseList();
				int count = 1;
				for (Purchase purchase : purchaseList) {
					TaxCalculator calculate = new TaxCalculator(purchase.getInventory());

					printReceipt(purchase, calculate, count);
					count++;
				}
				System.out.println("==========");
			}
		} catch (Exception e) {
			System.out.println("Error processing the file : " + cart);
		}
	}

	public static void printReceipt(Purchase purchase, TaxCalculator calculate, int count) {
		System.out.println("OUTPUT " + count + ":");
		for (Item item : purchase.getInventory()) {
			System.out.format(Constants.ITEM_FORMATTER, item.getQuantity() + " " + item.getName() + ": ",
					item.getPriceWithTax());
		}
		System.out.format(Constants.TAX_FORMATTER, "Sales Taxes:", calculate.getTaxTotal());
		System.out.format(Constants.TOTAL_FORMATTER, "Total:", calculate.getSaleTotal());
	}

	public static void lineBreak() {
		String dashes = new String(new char[48]).replace("\0", "-");
		System.out.format(dashes + "%n");
	}
}