package com.aethernadev.product;


/**
 * Created by IT on 2015-11-03.
 */
public interface ProductMapper<T> {

    Product mapToProduct(T dbProduct);

}
