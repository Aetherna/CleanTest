package com.aethernadev.ormlitedomain.product;

import android.util.Log;

import com.aethernadev.product.Product;
import com.aethernadev.product.ProductDao;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Aetherna on 2015-11-17.
 */
public class OLProductDaoImpl implements ProductDao {


    @Inject
    Dao<OLProduct, Integer> productDao;
    @Inject
    OLProductMapper productMapper;

    @Inject
    public OLProductDaoImpl(Dao<OLProduct, Integer> productDao) {
        this.productDao = productDao;
    }

    @Override
    public Product createProduct(Product product) {
        OLProduct olProduct = productMapper.mapFromProduct(product);
        try {
            productDao.create(olProduct);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public Product findProductByBarcode(String barcode) {

        try {
            List<OLProduct> result = productDao.queryForEq("name", barcode);
            if (!result.isEmpty()) {
                return productMapper.mapToProduct(result.get(0));
            }
        } catch (SQLException e) {
            Log.e("TODO :>", e.getMessage());
            e.printStackTrace();
        }

        return new Product();
    }

    @Override
    public List<Product> getAllProducts() {

        List<Product> products = new ArrayList<>();

        try {
            List<OLProduct> results = productDao.queryForAll();
            if (results == null) {
                return products;
            }

            for (OLProduct olProduct : results) {
                products.add(productMapper.mapToProduct(olProduct));
            }

        } catch (SQLException e) {
            Log.e("TODO :>", e.getMessage());
            e.printStackTrace();
        }
        return products;
    }
}
