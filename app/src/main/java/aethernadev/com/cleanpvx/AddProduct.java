package aethernadev.com.cleanpvx;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
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

import aethernadev.com.cleanpvx.addproduct.ExpiryDatePicker;
import aethernadev.com.cleanpvx.application.App;
import aethernadev.com.cleanpvx.base.BaseActivity;
import aethernadev.com.cleanpvx.validation.FieldValidator;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddProduct extends BaseActivity<AddProductPresenter.MainUI> implements AddProductPresenter.MainUI, DatePickerDialog.OnDateSetListener {

    public static final String DIALOG = "dialog";
    @Bind(R.id.content_add_product)
    View container;

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
    FieldValidator inputValidator;

    @Inject
    AddProductPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this, this);
        ((App) getApplication()).inject(this);

        setupPresenter(presenter, this);
        setupExpiryDate();

    }

    private void setupExpiryDate() {

        expiryDate.setOnFocusChangeListener((View v, boolean focused) -> {
            if(focused){
                showDatePicker();
            }
        });
    }

    @OnClick(R.id.createProduct)
    public void createProduct() {
        if (!inputValidator.validateNotEmpty(productName)
                || !inputValidator.validateNotEmpty(productBarcode)
                || !inputValidator.validateNotEmpty(expiryDate)) {
            return;
        }

        Product product = new Product();
        product.setName(productName.getText().toString());
        product.setBarcode(productBarcode.getText().toString());
        product.setExpiryDate(getExpiryDate());
        product.setIsVegan(isVegan.isChecked());

        presenter.addProduct(product);
    }

    public void showDatePicker() {
        ExpiryDatePicker expiryDatePicker = ExpiryDatePicker.instance();
        expiryDatePicker.show(getSupportFragmentManager(), DIALOG);
    }

    private DateTime getExpiryDate() {
        DateTimeFormatter dateFormatter = DateTimeFormat.forPattern(getString(R.string.app_DateFormat));
        return dateFormatter.parseDateTime(expiryDate.getText().toString());
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
        DateTime pickedDate = new DateTime(year, month, day, 0, 0);
        DateTimeFormatter dateFormatter = DateTimeFormat.forPattern(getString(R.string.app_DateFormat));
        expiryDate.setText(pickedDate.toString(dateFormatter));
    }
}
