package aethernadev.com.realmdomain.product;

import com.aethernadev.product.Product;
import com.aethernadev.product.ProductMapper;
import com.aethernadev.product.AppDateFormat;

import javax.inject.Inject;

/**
 * Created by Aetherna on 2015-11-03.
 */
public class RealmProductMapper implements ProductMapper<RealmProduct> {

    @Inject
    public RealmProductMapper() {
    }

    @Override
    public Product mapToProduct(RealmProduct realmProduct) {
        Product product = new Product();
        product.setName(realmProduct.getName());
        product.setBarcode(realmProduct.getBarcode());
        product.setExpiryDate(AppDateFormat.DATE_FORMAT.parseDateTime(realmProduct.getExpiryDate()));
        product.setIsVegan(realmProduct.isVegan());
        return product;
    }

    @Override
    public RealmProduct mapFromProduct(Product product) {
        throw new UnsupportedOperationException();
    }

}
