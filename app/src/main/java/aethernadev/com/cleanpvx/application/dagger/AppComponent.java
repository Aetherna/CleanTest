package aethernadev.com.cleanpvx.application.dagger;

import android.app.Application;
import android.content.Context;

import com.aethernadev.main.MainPresenter;
import com.aethernadev.module.PresenterModule;
import com.aethernadev.product.dagger.DBComponent;

import aethernadev.com.cleanpvx.MainActivity;
import dagger.Component;

/**
 * Created by IT on 2015-11-01.
 */
@Component(dependencies = DBComponent.class,
        modules = PresenterModule.class)
public interface AppComponent {

    MainPresenter mainPresenter();

    void inject(MainActivity mainActivity);


}
