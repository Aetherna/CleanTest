package com.aethernadev.ui.productslist;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.aethernadev.listproducts.ProductsListPresenter;
import com.aethernadev.product.Product;

import javax.inject.Inject;

import com.aethernadev.ui.R;
import com.aethernadev.application.App;
import com.aethernadev.ui.base.BaseActivity;
import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

public class ProductsList extends BaseActivity<ProductsListPresenter.MainUI> implements ProductsListPresenter.MainUI {

    @Inject
    ProductsListPresenter presenter;
    @Bind(R.id.products_list)
    RecyclerView productsList;
    ProductsListAdapter productsListAdapter;

    @Override
    final protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);
        ButterKnife.bind(this, this);
        ((App) getApplication()).inject(this);

        productsListAdapter = new ProductsListAdapter(this);
        productsList.setAdapter(productsListAdapter);
        productsList.setLayoutManager(new LinearLayoutManager(this));

        setupPresenter(presenter, this);
        presenter.loadProducts();

    }

    @Override
    public void addProductToList(Product product) {
        Observable.just(product)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(product1 -> {
                    productsListAdapter.addProduct(product1);
                });
    }

    @Override
    public void showError(String errorMessage) {
        Toast.makeText(ProductsList.this, errorMessage, Toast.LENGTH_LONG).show();
    }
}
