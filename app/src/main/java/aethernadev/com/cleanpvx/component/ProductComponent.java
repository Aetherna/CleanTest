package aethernadev.com.cleanpvx.component;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.aethernadev.base.UI;
import com.aethernadev.component.ProductPresenter;
import com.aethernadev.component.ProductViewModel;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

import aethernadev.com.cleanpvx.R;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Aetherna on 2015-11-26.
 */
public class ProductComponent implements ProductPresenter.ProductUI {


    ProductPresenter productPresenter;
    @Inject
    ProductComponentAdapter lookupsAdapter;

    @Bind(R.id.product_search)
    Button productSearch;
    @Bind(R.id.product_entry)
    EditText productEntry;
    @Bind(R.id.product_validation_progress)
    ProgressBar progressBar;
    @Bind(R.id.product_lookups)
    RecyclerView productLookups;

    private WeakReference<Activity> context;

    @Inject
    public ProductComponent(ProductPresenter productPresenter, ProductComponentAdapter lookupsAdapter) {
        this.productPresenter = productPresenter;
        this.lookupsAdapter = lookupsAdapter;
    }

    public void setup(Activity context, ActivityUI ui) {
        this.context = new WeakReference<>(context);

        View view = LayoutInflater.from(context).inflate(R.layout.product_component_layout, null, false);
        ButterKnife.bind(this, view);
        ui.addComponentToView(view);
        productPresenter.attachUI(this);

        productLookups.setLayoutManager(new LinearLayoutManager(context));
        productLookups.setAdapter(lookupsAdapter);
    }

    @OnClick(R.id.product_search)
    public void searchProduct() {
        final String productBarcode = productEntry.getText().toString();
        productPresenter.searchProduct(productBarcode);
    }

    @Override
    public void showValidationProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideValidationProgressBar() {
        if (context.get() == null) {
            return;
        }
        context.get().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void displayProductLookup(final ProductViewModel productViewModel) {
        context.get().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                lookupsAdapter.addLookup(productViewModel);
            }
        });
    }

    @Override
    public void displayNoSuchProductWarning() {

    }

    public interface ActivityUI extends UI {
        void addComponentToView(View componentView);
    }
}
