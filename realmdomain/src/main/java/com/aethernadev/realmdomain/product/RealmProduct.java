package com.aethernadev.realmdomain.product;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Aetherna on 2015-11-03.
 */
public class RealmProduct extends RealmObject {

    @PrimaryKey
    private String uid;
    private String name;
    private String barcode;
    private String expiryDate;
    private boolean isVegan;


    public RealmProduct() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

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

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setIsVegan(boolean isVegan) {
        this.isVegan = isVegan;
    }
}
