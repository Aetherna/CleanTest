package aethernadev.com.realmdomain.module;

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

    @Provides
    ProductDao provideProductDao(Realm realm) {
        return new RealmProductDaoImpl(realm);
    }
}
