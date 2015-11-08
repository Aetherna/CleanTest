package com.aethernadev.module;

import com.aethernadev.InputValidator;
import com.aethernadev.main.MainPresenter;
import com.aethernadev.product.ProductDao;

import dagger.Module;
import dagger.Provides;

/**
 * Created by IT on 2015-11-01.
 */
@Module
public class PresenterModule {

    @Provides
    MainPresenter provideMainPresenter(InputValidator inputValidator, ProductDao productDao) {
        return new MainPresenter(inputValidator, productDao);
    }
}
