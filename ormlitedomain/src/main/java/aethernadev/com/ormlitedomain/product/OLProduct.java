package aethernadev.com.ormlitedomain.product;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import org.joda.time.DateTime;

/**
 * Created by IT on 2015-11-17.
 */
@DatabaseTable(tableName = "Products")
public class OLProduct {

    @DatabaseField(generatedId = true)
    private long id;
    @DatabaseField
    private String name;
    @DatabaseField
    private String barcode;
    @DatabaseField(dataType = DataType.DATE_TIME)
    private DateTime expiryDate;
    @DatabaseField
    private boolean isVegan;


    public OLProduct() {
    }
}
