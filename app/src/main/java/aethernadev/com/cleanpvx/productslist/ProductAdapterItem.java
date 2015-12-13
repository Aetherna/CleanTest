package aethernadev.com.cleanpvx.productslist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Aetherna on 2015-12-13.
 */
public class ProductAdapterItem extends RecyclerView.ViewHolder {

    private TextView name;

    public ProductAdapterItem(View itemView) {
        super(itemView);
        name = (TextView) itemView;
    }

    public void setName(String name) {
        this.name.setText(name);
    }
}
