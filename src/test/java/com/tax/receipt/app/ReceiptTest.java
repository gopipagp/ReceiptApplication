package com.tax.receipt.app;

import org.junit.Before;
import org.junit.Test;

import com.tax.receipt.model.Purchase;
import com.tax.receipt.processor.TaxCalculator;

import static org.junit.Assert.*;

public class ReceiptTest {
    private Purchase purchase;
    private TaxCalculator calculator;
    private Double taxTotalExpected;
    private Double saleTotalExpected;
    private Double taxTotalActual;
    private Double saleTotalActual;


    @Before
    public void setUp(){
        purchase = new Purchase();
    }

    @Test
    public void passingOutput1()throws Exception {
        purchase.addItem(1, "book", 12.49);
        purchase.addItem(1, "music CD", 14.99);
        purchase.addItem(1, "chocolate bar", 0.85);
        calculator = new TaxCalculator(purchase.getInventory());
        saleTotalExpected = 29.83;
        taxTotalExpected = 1.50;

        taxTotalActual  = (double) Math.round(calculator.getTaxTotal() * 100) / 100;
        saleTotalActual = (double) Math.round(calculator.getSaleTotal() * 100) / 100;

        assertEquals(taxTotalExpected, taxTotalActual);
        assertEquals(saleTotalExpected, saleTotalActual);
    }


    @Test
    public void passingOutput2()throws Exception {
        purchase.addItem(1, "imported box of chocolates", 10.00);
        purchase.addItem(1, "imported bottle of perfume", 47.50);
        calculator = new TaxCalculator(purchase.getInventory());
        saleTotalExpected = 65.15;
        taxTotalExpected = 7.65;

        taxTotalActual  = (double) Math.round(calculator.getTaxTotal() * 100) / 100;
        saleTotalActual = (double) Math.round(calculator.getSaleTotal() * 100) / 100;

        assertEquals(taxTotalExpected, taxTotalActual);
        assertEquals(saleTotalExpected, saleTotalActual);
    }

    @Test
    public void passingOutput3()throws Exception {
        purchase.addItem(1, "imported bottle of perfume", 27.99);
        purchase.addItem(1, "bottle of perfume", 18.99);
        purchase.addItem(1, "packet of headache pills", 9.75);
        purchase.addItem(1, "box of imported chocolates", 11.25);
        calculator = new TaxCalculator(purchase.getInventory());
        saleTotalExpected = 74.68;
        taxTotalExpected = 6.70;

        taxTotalActual  = (double) Math.round(calculator.getTaxTotal() * 100) / 100;
        saleTotalActual = (double) Math.round(calculator.getSaleTotal() * 100) / 100;

        assertEquals(taxTotalExpected, taxTotalActual);
        assertEquals(saleTotalExpected, saleTotalActual);
    }

}