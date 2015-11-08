package aethernadev.com.cleanpvx;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.aethernadev.main.MainPresenter;
import com.aethernadev.module.PresenterModule;
import com.aethernadev.product.Product;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.joda.time.DateTime;

import aethernadev.com.cleanpvx.application.AppComponent;

import com.aethernadev.product.dagger.DBComponent;

import aethernadev.com.cleanpvx.application.DaggerAppComponent;
import aethernadev.com.cleanpvx.application.DaggerRealmDBComponent;
import aethernadev.com.cleanpvx.base.BaseActivity;
import aethernadev.com.realmdomain.product.module.DaoModule;
import aethernadev.com.realmdomain.product.module.RealmModule;

@EActivity
public class MainActivity extends BaseActivity<MainPresenter.MainUI> implements MainPresenter.MainUI {

    private MainPresenter presenter;

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

    protected AppComponent appComponent;
    protected DBComponent dbComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setup();
    }

    private void setup() {
        dbComponent = DaggerRealmDBComponent.builder().
                realmModule(new RealmModule(this))
                .daoModule(new DaoModule()).build();

        appComponent = DaggerAppComponent.builder()
                .presenterModule(new PresenterModule())
                .dBComponent(dbComponent)
                .build();
        presenter = appComponent.mainPresenter();

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
    public void main_searchBarcode(){
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
