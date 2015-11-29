package com.aethernadev.component;

/**
 * Created by Aetherna on 2015-11-28.
 */
public class ProductViewModel {

    private String name;
    private String barcode;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductViewModel viewModel = (ProductViewModel) o;

        if (!name.equals(viewModel.name)) return false;
        return barcode.equals(viewModel.barcode);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + barcode.hashCode();
        return result;
    }
}
