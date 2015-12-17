package com.aethernadev.product;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Aetherna on 2015-12-13.
 */
public class FindAllProductsUseCase {

    ProductDao productDao;

    @Inject
    public FindAllProductsUseCase(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> getResults() {
        return productDao.getAllProducts();
    }
}
