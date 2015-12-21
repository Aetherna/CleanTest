package com.aethernadev.ui.addproduct;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import org.joda.time.DateTime;

/**
 * Created by Aetherna on 2015-11-29.
 */
public class ExpiryDatePicker extends DialogFragment {

    public static ExpiryDatePicker instance() {
        return new ExpiryDatePicker();
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        DateTime now = DateTime.now();
        return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getActivity(), now.getYear(), now.getMonthOfYear(), now.getDayOfMonth());
    }
}
