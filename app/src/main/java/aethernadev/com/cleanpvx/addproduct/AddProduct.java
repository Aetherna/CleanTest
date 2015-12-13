package aethernadev.com.cleanpvx.addproduct;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;

import com.aethernadev.addproduct.AddProductPresenter;
import com.aethernadev.product.Product;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.inject.Inject;

import aethernadev.com.cleanpvx.R;
import aethernadev.com.cleanpvx.addproduct.ExpiryDatePicker;
import aethernadev.com.cleanpvx.application.App;
import aethernadev.com.cleanpvx.application.dagger.appsettings.AppDateFormat;
import aethernadev.com.cleanpvx.base.BaseActivity;
import aethernadev.com.cleanpvx.validation.FieldValidator;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTouch;

public class AddProduct extends BaseActivity<AddProductPresenter.MainUI> implements AddProductPresenter.MainUI, DatePickerDialog.OnDateSetListener {

    private static final String DIALOG = "dialog";
    @Bind(R.id.content_add_product)
    protected View container;

    @Bind(R.id.createProduct)
    protected Button insertIntoDB;
    @Bind(R.id.productName)
    protected EditText productName;
    @Bind(R.id.productBarcode)
    protected EditText productBarcode;
    @Bind(R.id.productExpiryDate)
    protected EditText expiryDate;
    @Bind(R.id.productIsVegan)
    protected Switch isVegan;

    @Inject
    AddProductForm addProductForm;

    @Inject
    AddProductPresenter presenter;
    @Inject
    AppDateFormat appDateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this, this);
        ((App) getApplication()).inject(this);

        setupPresenter(presenter, this);
    }

    @OnTouch(R.id.productExpiryDate)
    public boolean chooseExpiryDate(View view, MotionEvent motionEvent) {

        if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
            view.requestFocus();
            showDatePicker();
            return true;
        }
        return false;
    }

    private void showDatePicker() {
        ExpiryDatePicker expiryDatePicker = ExpiryDatePicker.instance();
        expiryDatePicker.setCancelable(false);
        expiryDatePicker.show(getSupportFragmentManager(), DIALOG);
    }

    @OnClick(R.id.createProduct)
    public void createProduct() {

        addProductForm.addProductName(productName);
        addProductForm.addProductBarcode(productBarcode);
        addProductForm.addExpiryDate(expiryDate);
        addProductForm.addIsVegan(isVegan);

        if (addProductForm.validate()) {
            presenter.addProduct(addProductForm.getProduct());
        } else {
            showErrorMessage("Invalid product data");
        }

    }

    @Override
    public void showErrorMessage(String error) {
        Snackbar.make(container, error, Snackbar.LENGTH_INDEFINITE).show();
    }

    @Override
    public void showProductCreated() {
        productName.setText("");
        productBarcode.setText("");
        expiryDate.setText("");
        isVegan.setChecked(false);

        Snackbar.make(container, "Product created", Snackbar.LENGTH_INDEFINITE).show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        DateTime pickedDate = new DateTime(year, month + 1, day, 0, 0);
        expiryDate.setText(pickedDate.toString(appDateFormat.getDateTimeFormat()));
    }
}
