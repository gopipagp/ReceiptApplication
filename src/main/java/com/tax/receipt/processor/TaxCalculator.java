package com.tax.receipt.processor;

import java.util.List;

import com.tax.receipt.model.Item;

public class TaxCalculator {
	private Double totalTax = 0.00;
	private Double totalPrice = 0.00;
	private Double grandTotal = 0.00;

	public TaxCalculator(List<Item> items) {
		for (Item item : items) {
			this.totalPrice = this.totalPrice + (item.getPrice() * item.getQuantity());
			this.totalTax = this.totalTax + computeSalesTax(item);
		}
		this.grandTotal = this.totalPrice + this.totalTax;
	}

	private Double computeSalesTax(Item item) {
		Double tax = .10;
		if (item.isExempted()) {
			tax = .00;
		}

		if (item.isImported()) {
			tax = tax + .05;
		}
		Double rounded = roundAmount((item.getPrice() * tax) * item.getQuantity());
		item.setPriceWithTax(rounded + (item.getPrice() * item.getQuantity()));
		return rounded;
	}

	public Double getTaxTotal() {
		return this.totalTax;
	}

	public Double getSaleTotal() {
		return this.grandTotal;
	}

	private Double roundAmount(Double amount) {
		return Math.ceil((amount * 20.0)) / 20.0;
	}
}
