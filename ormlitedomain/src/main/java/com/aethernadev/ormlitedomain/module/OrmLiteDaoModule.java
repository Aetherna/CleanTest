package com.aethernadev.ormlitedomain.module;

import com.j256.ormlite.dao.Dao;

import com.aethernadev.ormlitedomain.databasehelper.OrmLiteDatabaseHelper;
import com.aethernadev.ormlitedomain.product.OLProduct;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Aetherna on 2015-11-17.
 */
@Module(includes = OrmLiteDbHelperModule.class)
public class OrmLiteDaoModule {

    @Provides
    Dao<OLProduct, Integer> provideOLProductDao(OrmLiteDatabaseHelper ormLiteDatabaseHelper) {
        return ormLiteDatabaseHelper.getProductDao();
    }
}
