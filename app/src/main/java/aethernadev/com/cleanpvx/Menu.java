package aethernadev.com.cleanpvx;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import javax.inject.Inject;

import aethernadev.com.cleanpvx.application.App;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Menu extends AppCompatActivity {

    @Bind(R.id.menu_searchProducts)
    Button searchProducts;
    @Bind(R.id.menu_addProduct)
    Button addProduct;
    @Bind(R.id.menu_productComponent)
    Button productComponent;

    @Inject
    Navigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ((App) getApplication()).inject(this);
        ButterKnife.bind(this, this);

    }

    @OnClick(R.id.menu_searchProducts)
    public void goToSearchProducts() {
        navigator.goToSearchProducts(this);
    }

    @OnClick(R.id.menu_addProduct)
    public void goToAddProduct() {
        navigator.goToAddProduct(this);
    }


}
