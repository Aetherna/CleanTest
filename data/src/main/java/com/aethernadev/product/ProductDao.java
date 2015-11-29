package com.aethernadev.product;

import java.util.List;

/**
 * Created by Aetherna on 2015-11-02.
 */
public interface ProductDao {

    Product createProduct(Product product);

    Product findProductByBarcode(String barcode);

    List<Product> getAllProducts();
}
