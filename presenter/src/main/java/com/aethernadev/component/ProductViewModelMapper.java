package com.aethernadev.component;

import com.aethernadev.product.Product;

import javax.inject.Inject;

/**
 * Created by Aetherna on 2015-11-28.
 */
public class ProductViewModelMapper {

    @Inject
    public ProductViewModelMapper() {
    }

    public ProductViewModel map(Product product) {
        ProductViewModel viewModel = new ProductViewModel();
        viewModel.setName(product.getName());
        viewModel.setBarcode(product.getBarcode());
        return viewModel;
    }
}
