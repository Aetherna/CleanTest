package com.aethernadev.listproducts;

import com.aethernadev.base.BasePresenter;
import com.aethernadev.base.UI;
import com.aethernadev.product.FindAllProductsUseCase;
import com.aethernadev.product.Product;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Aetherna on 2015-12-13.
 */
public class ProductsListPresenter extends BasePresenter<ProductsListPresenter.MainUI> {

    FindAllProductsUseCase findAllProductsUseCase;

    @Inject
    public ProductsListPresenter(FindAllProductsUseCase findAllProductsUseCase) {
        this.findAllProductsUseCase = findAllProductsUseCase;
    }

    public void loadProducts() {
        Observable.from(findAllProductsUseCase.getResults())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Action1<Product>() {
                    @Override
                    public void call(Product product) {
                        ui.addProductToList(product);
                    }
                });
    }

    public interface MainUI extends UI {

        void addProductToList(Product product);

        void showError(String errorMessage);
    }
}
