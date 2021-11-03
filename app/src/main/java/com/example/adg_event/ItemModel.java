package com.example.adg_event;

public class ItemModel {
    String groceryName;
    int groceryPrice;

    public ItemModel(String groceryName, int groceryPrice) {
        this.groceryName = groceryName;
        this.groceryPrice = groceryPrice;
    }

    public String getGroceryName() {
        return groceryName;
    }

    public void setGroceryName(String groceryName) {
        this.groceryName = groceryName;
    }

    public int getGroceryPrice() {
        return groceryPrice;
    }

    public void setGroceryPrice(int groceryPrice) {
        this.groceryPrice = groceryPrice;
    }
}
