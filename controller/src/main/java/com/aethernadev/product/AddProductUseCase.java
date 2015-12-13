package com.aethernadev.product;

import com.aethernadev.InputValidator;
import com.aethernadev.product.Product;
import com.aethernadev.product.ProductDao;

import javax.inject.Inject;

public class AddProductUseCase {


    ProductDao productDao;

    @Inject
    public AddProductUseCase(ProductDao productDao) {
        this.productDao = productDao;
    }

    public void addProduct(Product product) throws Exception {

        productDao.createProduct(product);

    }
}
