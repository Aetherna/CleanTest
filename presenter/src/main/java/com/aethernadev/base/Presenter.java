package com.aethernadev.base;

public interface Presenter<T> {

    void attachUI(T UI);
    void detachUI();
}
