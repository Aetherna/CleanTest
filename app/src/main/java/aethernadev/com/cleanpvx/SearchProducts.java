package aethernadev.com.cleanpvx;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aethernadev.main.SearchProductsPresenter;
import com.aethernadev.product.Product;

import org.joda.time.DateTime;

import javax.inject.Inject;

import aethernadev.com.cleanpvx.application.App;
import aethernadev.com.cleanpvx.base.BaseActivity;
import aethernadev.com.cleanpvx.component.ProductComponent;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchProducts extends BaseActivity<SearchProductsPresenter.MainUI> implements SearchProductsPresenter.MainUI, ProductComponent.ActivityUI {

    @Inject
    protected SearchProductsPresenter presenter;
    @Inject
    protected ProductComponent productComponent;

    @Bind(R.id.main_barcodeEntry)
    protected EditText barcodeEntry;
    @Bind(R.id.main_searchResult)
    protected TextView searchResult;
    @Bind(R.id.main_searchBarcode)
    protected FloatingActionButton searchBarcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((App) getApplication()).inject(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupPresenter(presenter, this);
        productComponent.setup(this, this);
    }


    @OnClick(R.id.main_searchBarcode)
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

    @Override
    public void addComponentToView(View componentView) {
        ((LinearLayout) findViewById(R.id.main_content)).addView(componentView);
    }


}
