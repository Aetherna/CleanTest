package aethernadev.com.cleanpvx.application;

import com.aethernadev.product.dagger.DBComponent;

import aethernadev.com.realmdomain.product.RealmProductDaoImpl;
import aethernadev.com.realmdomain.product.module.DaoModule;
import aethernadev.com.realmdomain.product.module.RealmModule;
import dagger.Component;

/**
 * Created by IT on 2015-11-08.
 */
@Component(modules = {RealmModule.class, DaoModule.class})
public interface RealmDBComponent extends DBComponent {

    RealmProductDaoImpl productDao();

}
