package aethernadev.com.ormlitedomain.module;

import com.j256.ormlite.dao.Dao;

import javax.inject.Inject;

import aethernadev.com.ormlitedomain.databasehelper.OrmLiteDatabaseHelper;
import aethernadev.com.ormlitedomain.product.OLProduct;
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
