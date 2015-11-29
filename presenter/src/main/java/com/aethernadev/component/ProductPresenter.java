package com.aethernadev.component;

import com.aethernadev.base.BasePresenter;
import com.aethernadev.base.UI;
import com.aethernadev.product.Product;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by Aetherna on 2015-11-26.
 */
public class ProductPresenter extends BasePresenter<ProductPresenter.ProductUI> {


    ProductComponentAddProductUseCase addProductUseCase;
    ProductViewModelMapper mapper;

    @Inject
    public ProductPresenter(ProductComponentAddProductUseCase addProductUseCase, ProductViewModelMapper mapper) {
        this.addProductUseCase = addProductUseCase;
        this.mapper = mapper;
    }

    public void searchProduct(String product) {

        ui.showValidationProgressBar();

        Observable.just(addProductUseCase.addProduct(product))
                .delay(1, TimeUnit.SECONDS)
                .subscribe(new Action1<Product>() {
                    @Override
                    public void call(Product product) {

                        displayProductLookup(product);
                        ui.hideValidationProgressBar();
                    }
                });
    }

    private void displayProductLookup(Product product) {
        if (product.isEmpty()) {
            ui.displayNoSuchProductWarning();
        } else {
            ui.displayProductLookup(mapper.map(product));
        }
    }


    public interface ProductUI extends UI {
        void showValidationProgressBar();

        void hideValidationProgressBar();

        void displayProductLookup(ProductViewModel productViewModel);

        void displayNoSuchProductWarning();
    }
}
