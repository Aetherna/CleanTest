package com.aethernadev.main;

import com.aethernadev.InputValidator;
import com.aethernadev.base.BasePresenter;
import com.aethernadev.base.UI;
import com.aethernadev.product.Product;
import com.aethernadev.product.ProductDao;

import javax.inject.Inject;

/**
 * Created by IT on 2015-11-01.
 */
public class MainPresenter extends BasePresenter<MainPresenter.MainUI> {


    @Inject
    ProductDao productDao;
    @Inject
    InputValidator inputValidator;

    @Inject
    public MainPresenter(InputValidator inputValidator, ProductDao productDao) {
        this.inputValidator = inputValidator;
        this.productDao = productDao;
    }

    public void addProduct(Product product) {
        if (inputValidator.validate(product.getName()) && inputValidator.validate(product.getBarcode())) {
            productDao.createProduct(product);
        } else {
            ui.showErrorMessage("Insert value");
        }
    }

    public void findProduct(String barcode) {
        if (!inputValidator.validate(barcode)) {
            ui.showErrorMessage("Insert value");
            return;
        }

        Product found = productDao.findProductByBarcode(barcode);
        if (found.isEmpty()) {
            ui.showErrorMessage("No such product");
        } else {
            ui.showMessage("Product found: " + found.getName());
        }
    }

    public interface MainUI extends UI {
        void showErrorMessage(String error);

        void showMessage(String message);
    }
}
