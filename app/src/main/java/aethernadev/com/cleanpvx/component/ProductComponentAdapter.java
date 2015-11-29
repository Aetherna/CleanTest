package aethernadev.com.cleanpvx.component;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aethernadev.component.ProductViewModel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import aethernadev.com.cleanpvx.R;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Aetherna on 2015-11-28.
 */
public class ProductComponentAdapter extends RecyclerView.Adapter {

    private Set<ProductViewModel> products = new LinkedHashSet<>();

    @Inject
    public ProductComponentAdapter() {
    }

    public void addLookup(ProductViewModel product) {
        boolean isNewAdded = products.add(product);
        if (isNewAdded) {
            notifyItemInserted(products.size() - 1);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_component_lookup_layout, null);

        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ProductViewModel viewModel = (ProductViewModel) products.toArray()[position];
        ((ProductViewHolder) holder).name.setText(viewModel.getName());
        ((ProductViewHolder) holder).barcode.setText(viewModel.getBarcode());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    protected static class ProductViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.prod_lookup_product_name)
        TextView name;
        @Bind(R.id.prod_lookup_product_barcode)
        TextView barcode;

        public ProductViewHolder(View lookupView) {
            super(lookupView);
            ButterKnife.bind(this, lookupView);
        }
    }

}
