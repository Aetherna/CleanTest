package com.aethernadev.realmdomain.module;

import com.aethernadev.product.ProductDao;

import com.aethernadev.realmdomain.product.RealmProductDaoImpl;
import dagger.Module;
import dagger.Provides;
import io.realm.Realm;


/**
 * Created by Aetherna on 2015-11-04.
 */
@Module(includes = RealmModule.class)
public class DaoModule {

    @Provides
    ProductDao provideProductDao(Realm realm) {
        return new RealmProductDaoImpl(realm);
    }
}
