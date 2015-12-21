package com.aethernadev.ormlitedomain.module;

import com.aethernadev.product.ProductDao;
import com.j256.ormlite.dao.Dao;

import com.aethernadev.ormlitedomain.product.OLProduct;
import com.aethernadev.ormlitedomain.product.OLProductDaoImpl;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Aetherna on 2015-11-17.
 */
@Module(includes = OrmLiteDaoModule.class)
public class DaoModule {

    @Provides
    ProductDao provideProductDao(Dao<OLProduct, Integer> olProductDao) {
        return new OLProductDaoImpl(olProductDao);
    }
}
