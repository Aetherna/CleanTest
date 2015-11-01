package aethernadev.com.cleanpvx.base;

import android.support.v7.app.AppCompatActivity;

import com.aethernadev.base.Presenter;
import com.aethernadev.base.UI;


public abstract class BaseActivity<T extends UI> extends AppCompatActivity {

    private Presenter<T> presenter;
    private T ui;


    public void setupPresenter(Presenter<T> presenter, T ui) {
        this.presenter = presenter;
        this.ui = ui;
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachUI(ui);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachUI();
    }
}
