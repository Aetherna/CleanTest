package aethernadev.com.realmdomain.product.module;

import com.aethernadev.product.ProductDao;

import javax.inject.Inject;

import aethernadev.com.realmdomain.product.RealmProductDaoImpl;
import dagger.Module;
import dagger.Provides;
import io.realm.Realm;


/**
 * Created by IT on 2015-11-04.
 */
@Module(includes = RealmModule.class)
public class DaoModule {
    @Inject
    Realm realm;

    @Provides
    ProductDao provideProductDao() {
        return new RealmProductDaoImpl(realm);
    }
}
