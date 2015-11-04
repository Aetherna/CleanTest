package com.aethernadev.product;

import org.joda.time.DateTime;

public class Product {

    private String name;
    private String barcode;
    private DateTime expiryDate;
    private boolean isVegan;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public DateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(DateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setIsVegan(boolean isVegan) {
        this.isVegan = isVegan;
    }

    public boolean isEmpty() {
        return name == null && barcode == null;
    }
}
