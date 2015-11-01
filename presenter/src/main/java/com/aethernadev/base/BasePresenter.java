package com.aethernadev.base;

/**
 * Created by IT on 2015-11-01.
 */
public abstract class BasePresenter<T> implements Presenter<T> {

    protected T ui;

    @Override
    public void attachUI(T ui) {
        this.ui = ui;
    }

    @Override
    public void detachUI() {
        this.ui = null;
    }
}
