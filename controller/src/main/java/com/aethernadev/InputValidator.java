package com.aethernadev;

import javax.inject.Inject;

public class InputValidator {

    @Inject
    public InputValidator() {
    }

    public boolean validate(String label) {
        return label != null && !label.isEmpty();
    }
}
