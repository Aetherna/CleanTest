package com.aethernadev.component;

import com.aethernadev.product.Product;
import com.aethernadev.product.ProductDao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Aetherna on 2015-11-27.
 */
public class ProductComponentAddProductUseCase {

    ProductDao productDao;

    @Inject
    public ProductComponentAddProductUseCase(ProductDao productDao) {
        this.productDao = productDao;
    }

    public Product addProduct(String barcode) {

        return productDao.findProductByBarcode(barcode);
    }
}
