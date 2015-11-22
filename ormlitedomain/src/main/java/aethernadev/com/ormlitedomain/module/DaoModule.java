package aethernadev.com.ormlitedomain.module;

import com.aethernadev.product.ProductDao;
import com.j256.ormlite.dao.Dao;

import javax.inject.Inject;

import aethernadev.com.ormlitedomain.product.OLProduct;
import aethernadev.com.ormlitedomain.product.OLProductDaoImpl;
import dagger.Module;
import dagger.Provides;

/**
 * Created by IT on 2015-11-17.
 */
@Module(includes = OrmLiteDaoModule.class)
public class DaoModule {

    @Provides
    ProductDao provideProductDao(Dao<OLProduct, Integer> olProductDao) {
        return new OLProductDaoImpl(olProductDao);
    }
}
