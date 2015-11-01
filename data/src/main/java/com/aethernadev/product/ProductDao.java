package com.aethernadev.product;

import com.sun.javafx.beans.annotations.NonNull;

import java.util.List;

/**
 * Created by IT on 2015-11-02.
 */
public interface ProductDao {

    Product createProduct(Product product);

    Product findProductByBarcode(String barcode);

    List<Product> getAllProducts();
}
