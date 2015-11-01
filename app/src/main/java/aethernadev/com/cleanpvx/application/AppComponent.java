package aethernadev.com.cleanpvx.application;

import com.aethernadev.main.MainPresenter;
import com.aethernadev.module.PresenterModule;

import dagger.Component;

/**
 * Created by IT on 2015-11-01.
 */
@Component(modules = {PresenterModule.class})
public interface AppComponent {

    MainPresenter mainPresenter();

}
