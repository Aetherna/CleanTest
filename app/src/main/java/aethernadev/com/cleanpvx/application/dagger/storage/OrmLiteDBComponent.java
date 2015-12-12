package aethernadev.com.cleanpvx.application.dagger.storage;

import android.content.Context;

import com.aethernadev.product.dagger.DBComponent;

import javax.inject.Singleton;

import aethernadev.com.ormlitedomain.module.DaoModule;
import aethernadev.com.ormlitedomain.module.OrmLiteDaoModule;
import aethernadev.com.ormlitedomain.module.OrmLiteDbHelperModule;
import aethernadev.com.ormlitedomain.product.OLProductDaoImpl;
import dagger.Component;

/**
 * Created by Aetherna on 2015-11-17.
 */
@Singleton
@Component(modules = {OrmLiteDbHelperModule.class, OrmLiteDaoModule.class, DaoModule.class})
public interface OrmLiteDBComponent extends DBComponent {
    OLProductDaoImpl productDao();

}
