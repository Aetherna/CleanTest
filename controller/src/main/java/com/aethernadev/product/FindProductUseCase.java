package com.aethernadev.product;

import com.aethernadev.TextUtils;
import com.aethernadev.product.Product;
import com.aethernadev.product.ProductDao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Aetherna on 2015-11-27.
 */
public class FindProductUseCase {

    ProductDao productDao;

    TextUtils textUtils;

    @Inject
    public FindProductUseCase(ProductDao productDao, TextUtils textUtils) {
        this.productDao = productDao;
        this.textUtils = textUtils;
    }

    public Product findProduct(String barcode) {

        if (textUtils.isNonSpaceEmpty(barcode)) {
            throw new IllegalStateException("Barcode must be supplied");
        }

        return productDao.findProductByBarcode(barcode);
    }
}
