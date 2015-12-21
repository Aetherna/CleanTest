package com.aethernadev.application.dagger.ui;

import com.aethernadev.search.SearchProductsPresenter;
import com.aethernadev.module.PresenterModule;
import com.aethernadev.product.dagger.DBComponent;

import javax.inject.Singleton;

import com.aethernadev.ui.Menu;
import com.aethernadev.ui.addproduct.AddProduct;
import com.aethernadev.ui.component.ProductComponent;
import com.aethernadev.ui.productslist.ProductsList;
import com.aethernadev.ui.searchproducts.SearchProducts;
import dagger.Component;

/**
 * Created by Aetherna on 2015-11-01.
 */
@Singleton
@Component(dependencies = DBComponent.class,
        modules = {PresenterModule.class,
                AndroidModule.class})
public interface AppComponent {


    SearchProductsPresenter mainPresenter();

    ProductComponent productComponent();


    void inject(SearchProducts searchProducts);

    void inject(Menu menuActivity);

    void inject(AddProduct addProduct);

    void inject(ProductsList productsList);
}
