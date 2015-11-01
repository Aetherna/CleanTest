package com.aethernadev.main;

import com.aethernadev.LabelsValidator;
import com.aethernadev.base.BasePresenter;
import com.aethernadev.base.UI;

import javax.inject.Inject;

/**
 * Created by IT on 2015-11-01.
 */
public class MainPresenter extends BasePresenter<MainPresenter.MainUI> {

    @Inject
    LabelsValidator labelsValidator;

    @Inject
    public MainPresenter(LabelsValidator labelsValidator   ) {
        this.labelsValidator = labelsValidator;
    }


    public void validateLabelEntry(String text) {
        if (labelsValidator.validate(text)) {
            ui.showMessage("Good Job!");
        } else {
            ui.showErrorMessage("How dare you!");
        }
    }

    public interface MainUI extends UI {
        void showErrorMessage(String error);

        void showMessage(String message);
    }
}
