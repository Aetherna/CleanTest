package aethernadev.com.ormlitedomain.product;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import org.joda.time.DateTime;

/**
 * Created by Aetherna on 2015-11-17.
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public DateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(DateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setIsVegan(boolean isVegan) {
        this.isVegan = isVegan;
    }
}
