package com.aethernadev;

import javax.inject.Inject;

public class LabelsValidator {

    @Inject
    public LabelsValidator() {
    }

    public boolean validate(String label) {
        return label.contains("a");
    }
}
