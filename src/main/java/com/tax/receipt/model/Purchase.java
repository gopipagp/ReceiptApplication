package com.tax.receipt.model;

import java.util.ArrayList;
import java.util.List;

public class Purchase {
    private List<Item> itemList = new ArrayList<Item>();

    public Item addItem(int quantity, String name, Double price) {
        Item item = new Item(quantity, name, price);
        this.itemList.add(item);
        return item;
    }

    public List<Item> getInventory(){
        return this.itemList;
    }
}