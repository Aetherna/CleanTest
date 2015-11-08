package com.aethernadev.product.dagger;

import com.aethernadev.product.ProductDao;

import dagger.Component;

/**
 * Created by IT on 2015-11-08.
 */

public interface DBComponent {

    ProductDao productDao();
}
