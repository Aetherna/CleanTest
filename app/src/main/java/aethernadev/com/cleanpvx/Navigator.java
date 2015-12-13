package aethernadev.com.cleanpvx;

import android.content.Context;
import android.content.Intent;

import javax.inject.Inject;

import aethernadev.com.cleanpvx.addproduct.AddProduct;
import aethernadev.com.cleanpvx.productslist.ProductsList;
import aethernadev.com.cleanpvx.searchproducts.SearchProducts;

/**
 * Created by Aetherna on 2015-11-28.
 */
public class Navigator {

    @Inject
    public Navigator() {
    }

    public void goToSearchProducts(Context context) {
        Intent intent = new Intent(context, SearchProducts.class);
        context.startActivity(intent);
    }

    public void goToAddProduct(Context context) {
        Intent intent = new Intent(context, AddProduct.class);
        context.startActivity(intent);
    }

    public void goToProductsList(Context context) {
        Intent intent = new Intent(context, ProductsList.class);
        context.startActivity(intent);
    }
}
