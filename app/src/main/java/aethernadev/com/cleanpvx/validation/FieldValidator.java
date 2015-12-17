package aethernadev.com.cleanpvx.validation;

import android.text.TextUtils;
import android.widget.EditText;

import javax.inject.Inject;

/**
 * Created by Aetherna on 2015-11-29.
 */
public class FieldValidator {

    @Inject
    public FieldValidator() {
    }

    public boolean validateNotEmpty(EditText editText) {
        if (TextUtils.isEmpty(editText.getText())) {
            editText.setError("Insert value");
            return false;
        }
        return true;
    }
}
