package com.aethernadev.product;

import com.sun.istack.internal.NotNull;

/**
 * Created by IT on 2015-11-03.
 */
public interface ProductMapper<T> {

    Product mapToProduct(@NotNull T dbProduct);

}
