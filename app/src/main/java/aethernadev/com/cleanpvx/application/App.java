package aethernadev.com.cleanpvx.application;

import android.app.Application;

import com.aethernadev.module.PresenterModule;
import com.aethernadev.product.dagger.DBComponent;

import aethernadev.com.cleanpvx.AddProduct;
import aethernadev.com.cleanpvx.SearchProducts;
import aethernadev.com.cleanpvx.Menu;
import aethernadev.com.cleanpvx.application.dagger.AppComponent;
import aethernadev.com.cleanpvx.application.dagger.DaggerAppComponent;
import aethernadev.com.cleanpvx.application.dagger.DaggerOrmLiteDBComponent;
import aethernadev.com.ormlitedomain.module.OrmLiteDbHelperModule;

/**
 * Created by Aetherna on 2015-11-01.
 */
public class App extends Application {

    private AppComponent appComponent;
    private DBComponent dbComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        dbComponent = DaggerOrmLiteDBComponent.builder()
                .ormLiteDbHelperModule(new OrmLiteDbHelperModule(this))
                .build();

//      dbComponent = DaggerRealmDBComponent.builder()
//              .realmModule(new RealmModule(this))
//              .build();


        appComponent = DaggerAppComponent.builder()
                .presenterModule(new PresenterModule())
                .dBComponent(dbComponent)
                .build();
    }

    public void inject(SearchProducts searchProducts) {
        appComponent.inject(searchProducts);
    }

    public void inject(Menu menuActivity) {
        appComponent.inject(menuActivity);
    }

    public void inject(AddProduct addProduct) {
        appComponent.inject(addProduct);
    }
}
