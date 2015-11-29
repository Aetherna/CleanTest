package aethernadev.com.cleanpvx.application.dagger;

import com.aethernadev.product.dagger.DBComponent;

import aethernadev.com.realmdomain.product.RealmProductDaoImpl;
import aethernadev.com.realmdomain.module.DaoModule;
import aethernadev.com.realmdomain.module.RealmModule;
import dagger.Component;

/**
 * Created by Aetherna on 2015-11-08.
 */
@Component(modules = {RealmModule.class, DaoModule.class})
public interface RealmDBComponent extends DBComponent {

    RealmProductDaoImpl productDao();

}
