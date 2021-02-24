package com.tax.receipt.model;

import com.tax.receipt.util.Constants;

public class Item {
    private int quantity;
    private String name;
    private Double price;
    private Boolean imported = false;
    private Boolean exempted = false;
    private Double priceWithTax;

    public Item(int quantity, String name, Double price){
        this.quantity = quantity;
        this.name = name;
        this.price = price;
        setExemptions(name);
    }

    public int getQuantity(){
        return this.quantity;
    }

    public String getName(){
        return this.name;
    }

    public Double getPrice(){
        return this.price;
    }

    public Boolean isExempted(){
        return this.exempted;
    }

    public Boolean isImported(){
        return this.imported;
    }

    public Double setPriceWithTax(Double amount){
        return this.priceWithTax = amount;
    }

    public Double getPriceWithTax(){
        return this.priceWithTax;
    }

    private void setExemptions(String details){
        if (Constants.EXEMPTED_PATTERN.matcher(details).find()) {
            this.exempted = true;
        }

        if (Constants.IMPORTED_PATTERN.matcher(details).find()) {
            this.imported = true;
        }
    }
}
