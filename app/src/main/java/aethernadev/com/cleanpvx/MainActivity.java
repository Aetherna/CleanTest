package aethernadev.com.cleanpvx;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.aethernadev.main.MainPresenter;
import com.aethernadev.product.Product;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.joda.time.DateTime;

import javax.inject.Inject;

import aethernadev.com.cleanpvx.application.App;
import aethernadev.com.cleanpvx.base.BaseActivity;

@EActivity
public class MainActivity extends BaseActivity<MainPresenter.MainUI> implements MainPresenter.MainUI {

    @Inject
    protected MainPresenter presenter;

    @ViewById(R.id.main_barcodeEntry)
    protected EditText barcodeEntry;
    @ViewById(R.id.main_searchResult)
    protected TextView searchResult;
    @ViewById(R.id.main_insertDB)
    protected Button insertIntoDB;
    @ViewById(R.id.main_productName)
    protected EditText productName;
    @ViewById(R.id.main_productBarcode)
    protected EditText productBarcode;
    @ViewById(R.id.main_searchBarcode)
    protected FloatingActionButton searchBarcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App) getApplication()).inject(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupPresenter(presenter, this);
    }

    @Click
    public void main_insertDB() {
        Product product = new Product();
        product.setName(productName.getText().toString());
        product.setBarcode(productBarcode.getText().toString());
        product.setExpiryDate(new DateTime());
        product.setIsVegan(true);

        presenter.addProduct(product);
    }

    @Click
    public void main_searchBarcode() {
        presenter.findProduct(barcodeEntry.getText().toString());
    }

    @Override
    public void showErrorMessage(String error) {
        searchResult.setText(error);
    }

    @Override
    public void showMessage(String message) {
        searchResult.setText(message);
    }
}
