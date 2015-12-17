package aethernadev.com.cleanpvx.addproduct;

import android.widget.EditText;
import android.widget.Switch;

import com.aethernadev.TextUtils;
import com.aethernadev.product.Product;

import org.joda.time.DateTime;

import javax.inject.Inject;

import aethernadev.com.cleanpvx.application.dagger.appsettings.AppDateFormat;

/**
 * Created by Aetherna on 2015-12-10.
 */
public class AddProductForm {

    @Inject
    TextUtils textUtils;
    @Inject
    AppDateFormat appDateFormat;

    private String productName;
    private String productBarcode;
    private DateTime expiryDate;
    private boolean isVegan;

    @Inject
    public AddProductForm() {
    }

    public void addProductName(EditText nameField) {
        productName = nameField.getText().toString();
    }

    public void addProductBarcode(EditText barcodeField) {
        productBarcode = barcodeField.getText().toString();
    }

    public void addExpiryDate(EditText expiryDateField) {

        String dateAsString = expiryDateField.getText().toString();

        if (android.text.TextUtils.isEmpty(dateAsString)) {
            expiryDate = null;
            return;
        }

        expiryDate = appDateFormat.getDateTimeFormat().parseDateTime(dateAsString);
    }

    public boolean validate() {
        return !textUtils.isEmpty(productName)
                && !textUtils.isEmpty(productBarcode)
                && expiryDate != null;
    }

    public void addIsVegan(Switch isVeganField) {
        isVegan = isVeganField.isChecked();
    }

    public Product getProduct() {
        Product product = new Product();
        product.setName(productName);
        product.setBarcode(productBarcode);
        product.setExpiryDate(expiryDate);
        product.setIsVegan(isVegan);
        return product;
    }

}
