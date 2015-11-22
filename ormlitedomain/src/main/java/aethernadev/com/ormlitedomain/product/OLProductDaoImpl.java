package aethernadev.com.ormlitedomain.product;

import com.aethernadev.product.Product;
import com.aethernadev.product.ProductDao;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by IT on 2015-11-17.
 */
public class OLProductDaoImpl implements ProductDao {


    @Inject
    Dao<OLProduct, Integer> productDao;

    @Inject
    public OLProductDaoImpl(Dao<OLProduct, Integer> productDao) {
        this.productDao = productDao;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product findProductByBarcode(String barcode) {

        try {
            List<OLProduct> result = productDao.queryForEq("name", barcode);
            if (!result.isEmpty()) {
                result.get(0);
            }
        } catch (SQLException e) {


        }

        return new Product();
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
}
