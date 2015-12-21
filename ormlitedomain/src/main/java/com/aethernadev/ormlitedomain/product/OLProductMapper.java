package com.aethernadev.ormlitedomain.product;

import com.aethernadev.product.Product;
import com.aethernadev.product.ProductMapper;

import javax.inject.Inject;

/**
 * Created by Aetherna on 2015-11-19.
 */
public class OLProductMapper implements ProductMapper<OLProduct> {

    @Inject
    public OLProductMapper() {
    }

    @Override
    public Product mapToProduct(OLProduct dbProduct) {
        Product product = new Product();
        product.setName(dbProduct.getName());
        product.setBarcode(dbProduct.getBarcode());
        product.setExpiryDate(dbProduct.getExpiryDate());
        product.setIsVegan(dbProduct.isVegan());

        return product;
    }

    @Override
    public OLProduct mapFromProduct(Product product) {
        OLProduct olProduct = new OLProduct();
        olProduct.setName(product.getName());
        olProduct.setBarcode(product.getBarcode());
        olProduct.setExpiryDate(product.getExpiryDate());
        olProduct.setIsVegan(product.isVegan());

        return olProduct;
    }
}
