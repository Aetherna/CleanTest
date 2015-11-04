package aethernadev.com.cleanpvx.application;

import com.aethernadev.main.MainPresenter;
import com.aethernadev.module.PresenterModule;

import aethernadev.com.realmdomain.product.RealmProductDaoImpl;

import aethernadev.com.realmdomain.product.module.DaoModule;
import aethernadev.com.realmdomain.product.module.RealmModule;
import dagger.Component;

/**
 * Created by IT on 2015-11-01.
 */
@Component(modules = {PresenterModule.class, RealmModule.class, DaoModule.class})
public interface AppComponent {

    MainPresenter mainPresenter();

    RealmProductDaoImpl productDao();

}
