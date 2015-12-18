package com.aethernadev.addproduct;

import com.aethernadev.base.BasePresenter;
import com.aethernadev.base.UI;
import com.aethernadev.product.AddProductUseCase;
import com.aethernadev.product.Product;

import javax.inject.Inject;

/**
 * Created by Aetherna on 2015-11-29.
 */
public class AddProductPresenter extends BasePresenter<AddProductPresenter.MainUI> {

    AddProductUseCase addProductUseCase;

    @Inject
    public AddProductPresenter(AddProductUseCase addProductUseCase) {
        this.addProductUseCase = addProductUseCase;
    }

    public void addProduct(Product product) {

        try {
            addProductUseCase.addProduct(product);
            ui.showProductCreated();
        } catch (Exception e) {
            ui.showErrorMessage("Lol exception :O");
        }
    }

    public interface MainUI extends UI {
        void showErrorMessage(String error);

        void showProductCreated();
    }
}
