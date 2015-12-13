package aethernadev.com.cleanpvx.searchproducts;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aethernadev.search.SearchProductsPresenter;

import javax.inject.Inject;

import aethernadev.com.cleanpvx.R;
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

    @Bind(R.id.search_searchResult)
    protected TextView searchResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        ((App) getApplication()).inject(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupPresenter(presenter, this);
        productComponent.setup(this, this);
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
