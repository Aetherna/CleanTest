package aethernadev.com.cleanpvx.productslist;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.aethernadev.listproducts.ProductsListPresenter;
import com.aethernadev.product.Product;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import aethernadev.com.cleanpvx.R;
import aethernadev.com.cleanpvx.application.App;
import aethernadev.com.cleanpvx.base.BaseActivity;
import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class ProductsList extends BaseActivity<ProductsListPresenter.MainUI> implements ProductsListPresenter.MainUI {

    @Inject
    ProductsListPresenter presenter;
    @Bind(R.id.products_list)
    RecyclerView productsList;
    ProductsListAdapter productsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
