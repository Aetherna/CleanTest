package aethernadev.com.cleanpvx.application.dagger.ui;

import com.aethernadev.search.SearchProductsPresenter;
import com.aethernadev.module.PresenterModule;
import com.aethernadev.product.dagger.DBComponent;

import javax.inject.Singleton;

import aethernadev.com.cleanpvx.Menu;
import aethernadev.com.cleanpvx.addproduct.AddProduct;
import aethernadev.com.cleanpvx.component.ProductComponent;
import aethernadev.com.cleanpvx.productslist.ProductsList;
import aethernadev.com.cleanpvx.searchproducts.SearchProducts;
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
