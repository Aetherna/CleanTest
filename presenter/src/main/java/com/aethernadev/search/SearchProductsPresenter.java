package com.aethernadev.search;

import com.aethernadev.base.BasePresenter;
import com.aethernadev.base.UI;
import com.aethernadev.product.Product;
import com.aethernadev.product.ProductDao;

import javax.inject.Inject;

/**
 * Created by Aetherna on 2015-11-01.
 */
public class SearchProductsPresenter extends BasePresenter<SearchProductsPresenter.MainUI> {


    @Inject
    ProductDao productDao;


    @Inject
    public SearchProductsPresenter(ProductDao productDao) {

        this.productDao = productDao;
    }


    public void findProduct(String barcode) {

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
