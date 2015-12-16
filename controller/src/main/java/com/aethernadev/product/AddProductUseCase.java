package com.aethernadev.product;

import javax.inject.Inject;

public class AddProductUseCase {

    ProductDao productDao;

    @Inject
    public AddProductUseCase(ProductDao productDao) {
        this.productDao = productDao;
    }

    public void addProduct(Product product) {

        if (product == null || product.isEmpty()) {
            throw new IllegalStateException("Product not initialized properly");
        }

        productDao.createProduct(product);

    }
}
