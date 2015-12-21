package com.aethernadev.ui.productslist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.aethernadev.product.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aetherna on 2015-12-13.
 */
public class ProductsListAdapter extends RecyclerView.Adapter<ProductAdapterItem> {

    private Context context;
    private List<Product> data = new ArrayList<>();

    public ProductsListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ProductAdapterItem onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ProductAdapterItem(LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false));
    }

    @Override
    public void onBindViewHolder(ProductAdapterItem holder, int position) {
        Product product = data.get(position);
        holder.setName(product.getName() + ": " + product.getBarcode());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void addProduct(Product product) {
        data.add(product);
        notifyDataSetChanged();
    }

}
