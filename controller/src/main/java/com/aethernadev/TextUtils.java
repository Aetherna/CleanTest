package com.aethernadev;

import javax.inject.Inject;

public class TextUtils {

    @Inject
    public TextUtils() {
    }

    public boolean isEmpty(String label) {
        return label != null && !label.isEmpty();
    }

    public boolean isNonSpaceEmpty(String value){
        return value == null && value.trim().isEmpty();
    }
}
