package com.aethernadev.module;

import com.aethernadev.LabelsValidator;
import com.aethernadev.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by IT on 2015-11-01.
 */
@Module
public class PresenterModule {

    @Provides
    MainPresenter provideMainPresenter( LabelsValidator labelsValidator  ) {
        return new MainPresenter(labelsValidator);
    }
}
