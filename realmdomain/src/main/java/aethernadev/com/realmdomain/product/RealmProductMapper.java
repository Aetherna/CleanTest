package aethernadev.com.realmdomain.product;

import com.aethernadev.product.Product;
import com.aethernadev.product.ProductMapper;
import com.aethernadev.product.PvxDateFormat;

import org.joda.time.DateTime;

/**
 * Created by IT on 2015-11-03.
 */
public class RealmProductMapper implements ProductMapper<RealmProduct> {

    @Override
    public Product mapToProduct(RealmProduct realmProduct) {
        Product product = new Product();
        product.setName(realmProduct.getName());
        product.setBarcode(realmProduct.getBarcode());
        product.setExpiryDate(PvxDateFormat.DATE_FORMAT.parseDateTime(realmProduct.getExpiryDate()));
        product.setIsVegan(realmProduct.isVegan());
        return product;
    }

}
