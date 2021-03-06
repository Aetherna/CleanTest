package com.aethernadev.module;

import com.aethernadev.product.FindProductUseCase;
import com.aethernadev.component.ProductPresenter;
import com.aethernadev.component.ProductViewModelMapper;
import com.aethernadev.search.SearchProductsPresenter;
import com.aethernadev.product.ProductDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aetherna on 2015-11-01.
 */
@Module
public class PresenterModule {

    @Singleton
    @Provides
    SearchProductsPresenter provideMainPresenter(ProductDao productDao) {
        return new SearchProductsPresenter(productDao);
    }

    @Singleton
    @Provides
    ProductPresenter provideProductPresenter(FindProductUseCase findProductUseCase, ProductViewModelMapper mapper) {
        return new ProductPresenter(findProductUseCase, mapper);
    }
}
