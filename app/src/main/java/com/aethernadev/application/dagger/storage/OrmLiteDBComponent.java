package com.aethernadev.application.dagger.storage;

import com.aethernadev.product.dagger.DBComponent;

import javax.inject.Singleton;

import com.aethernadev.ormlitedomain.module.DaoModule;
import com.aethernadev.ormlitedomain.module.OrmLiteDaoModule;
import com.aethernadev.ormlitedomain.module.OrmLiteDbHelperModule;
import com.aethernadev.ormlitedomain.product.OLProductDaoImpl;
import dagger.Component;

/**
 * Created by Aetherna on 2015-11-17.
 */
@Singleton
@Component(modules = {OrmLiteDbHelperModule.class, OrmLiteDaoModule.class, DaoModule.class})
public interface OrmLiteDBComponent extends DBComponent {
    OLProductDaoImpl productDao();

}
