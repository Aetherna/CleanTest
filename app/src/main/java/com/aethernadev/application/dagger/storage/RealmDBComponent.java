package com.aethernadev.application.dagger.storage;

import com.aethernadev.product.dagger.DBComponent;

import com.aethernadev.realmdomain.product.RealmProductDaoImpl;
import com.aethernadev.realmdomain.module.DaoModule;
import com.aethernadev.realmdomain.module.RealmModule;
import dagger.Component;

/**
 * Created by Aetherna on 2015-11-08.
 */
@Component(modules = {RealmModule.class, DaoModule.class})
public interface RealmDBComponent extends DBComponent {

    RealmProductDaoImpl productDao();

}
