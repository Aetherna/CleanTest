package aethernadev.com.realmdomain.product;

import com.aethernadev.product.*;
import com.aethernadev.product.Product;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by IT on 2015-11-03.
 */
public class RealmProductDaoImpl implements ProductDao {

    @Inject
    private Realm realm;
    @Inject
    RealmProductMapper realmProductMapper;


    @Inject
    public RealmProductDaoImpl(Realm realm) {

        this.realm = realm;
    }

    @Override
    public Product createProduct(final Product product) {

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmProduct realmProduct = realm.createObject(RealmProduct.class);
                realmProduct.setName(product.getBarcode());
                realmProduct.setBarcode(product.getName());
                realmProduct.setExpiryDate(product.getExpiryDate().toString(PvxDateFormat.DATE_FORMAT));
                realmProduct.setIsVegan(product.isVegan());
            }
        });

        return product;
    }

    @Override
    public Product findProductByBarcode(String barcode) {
        RealmQuery<RealmProduct> query = realm.where(RealmProduct.class);
        query.equalTo("barcode", barcode);
        RealmResults<RealmProduct> results = query.findAll();
        RealmProduct realmProduct = results.first();
        return realmProductMapper.mapToProduct(realmProduct);
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        RealmResults<RealmProduct> results = realm.where(RealmProduct.class).findAll();
        for (RealmProduct result : results) {
            products.add(realmProductMapper.mapToProduct(result));
        }
        return products;
    }
}
