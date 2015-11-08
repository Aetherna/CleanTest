package aethernadev.com.cleanpvx.application;

import com.aethernadev.main.MainPresenter;
import com.aethernadev.module.PresenterModule;
import com.aethernadev.product.dagger.DBComponent;

import dagger.Component;

/**
 * Created by IT on 2015-11-01.
 */
@Component(dependencies = DBComponent.class,
        modules = PresenterModule.class)
public interface AppComponent {

    MainPresenter mainPresenter();

}
