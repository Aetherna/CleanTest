package com.aethernadev.realmdomain.product;

import com.aethernadev.product.*;
import com.aethernadev.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by Aetherna on 2015-11-03.
 */
public class RealmProductDaoImpl implements ProductDao {

    @Inject
    Realm realm;
    @Inject
    RealmProductMapper realmProductMapper;

    @Inject
    public RealmProductDaoImpl(Realm realm) {

        this.realm = realm;
    }

    @Override
    public Product createProduct(final Product product) {

        realm.beginTransaction();

        RealmProduct realmProduct = realm.createObject(RealmProduct.class);
        realmProduct.setUid(UUID.randomUUID().toString());
        realmProduct.setName(product.getName());
        realmProduct.setBarcode(product.getBarcode());
        realmProduct.setExpiryDate(product.getExpiryDate().toString(AppDateFormat.DATE_FORMAT));
        realmProduct.setIsVegan(product.isVegan());

        realm.commitTransaction();

        return product;
    }

    @Override
    public Product findProductByBarcode(String barcode) {
        RealmQuery<RealmProduct> query = realm.where(RealmProduct.class);
        query.equalTo("barcode", barcode);
        RealmResults<RealmProduct> results = query.findAll();
        if (!results.isEmpty()) {
            RealmProduct realmProduct = results.first();
            return realmProductMapper.mapToProduct(realmProduct);
        } else {
            return new Product();
        }
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
