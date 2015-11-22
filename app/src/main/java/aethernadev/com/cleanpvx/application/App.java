package aethernadev.com.cleanpvx.application;

import android.app.Application;

import com.aethernadev.module.PresenterModule;
import com.aethernadev.product.dagger.DBComponent;

import aethernadev.com.cleanpvx.MainActivity;
import aethernadev.com.cleanpvx.application.dagger.AppComponent;
import aethernadev.com.cleanpvx.application.dagger.DaggerAppComponent;
import aethernadev.com.cleanpvx.application.dagger.DaggerOrmLiteDBComponent;
import aethernadev.com.ormlitedomain.module.OrmLiteDbHelperModule;

/**
 * Created by IT on 2015-11-01.
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

    public void inject(MainActivity mainActivity) {
        appComponent.inject(mainActivity);
    }

}
