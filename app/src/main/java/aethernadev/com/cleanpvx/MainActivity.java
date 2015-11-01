package aethernadev.com.cleanpvx;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.aethernadev.main.MainPresenter;
import com.aethernadev.module.PresenterModule;

import aethernadev.com.cleanpvx.application.AppComponent;
import aethernadev.com.cleanpvx.application.DaggerAppComponent;
import aethernadev.com.cleanpvx.base.BaseActivity;

public class MainActivity extends BaseActivity<MainPresenter.MainUI> implements MainPresenter.MainUI {

    private MainPresenter presenter;

    private EditText labelEntry;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.validateLabelEntry(labelEntry.getText().toString());
            }
        });

        AppComponent appComponent = DaggerAppComponent.builder()
                .presenterModule(new PresenterModule())
                .build();
        presenter = appComponent.mainPresenter();

        setupPresenter(presenter, this);

        labelEntry = (EditText) findViewById(R.id.mainContent_label_entry);
        result = (TextView) findViewById(R.id.mainContent_result);
    }

    @Override
    public void showErrorMessage(String error) {
        result.setText(error);
    }

    @Override
    public void showMessage(String message) {
        result.setText(message);
    }
}
