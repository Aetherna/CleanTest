package com.aethernadev.application;

import android.app.Application;

import com.aethernadev.module.PresenterModule;
import com.aethernadev.product.dagger.DBComponent;

import com.aethernadev.ui.addproduct.AddProduct;
import com.aethernadev.ui.productslist.ProductsList;
import com.aethernadev.ui.searchproducts.SearchProducts;
import com.aethernadev.ui.Menu;
import com.aethernadev.application.dagger.storage.DaggerOrmLiteDBComponent;
import com.aethernadev.application.dagger.ui.AppComponent;
import com.aethernadev.application.dagger.ui.DaggerAppComponent;
import com.aethernadev.ormlitedomain.module.OrmLiteDbHelperModule;

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

    public void inject(ProductsList productsList) {
        appComponent.inject(productsList);
    }
}
