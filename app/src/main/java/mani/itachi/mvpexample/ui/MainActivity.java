package mani.itachi.mvpexample.ui;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import mani.itachi.mvpexample.R;
import mani.itachi.mvpexample.managers.DataManager;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<MainPresenter>,View.OnClickListener,MainViewInterface{

    @BindView(R.id.edit_name) EditText editText;
    @BindView(R.id.btnSubmit) Button btnSubmit;
    @BindView(R.id.btnClear) Button btnClear;
    @BindView(R.id.text_name) TextView textView;
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportLoaderManager().initLoader(1001,null,this);
        ButterKnife.bind(this);
        btnClear.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.attachView(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mainPresenter.detachView();
    }

    @NonNull
    @Override
    public Loader<MainPresenter> onCreateLoader(int id, @Nullable Bundle args) {
        return new MainLoader(this,new MainPresenter(new DataManager((this))));
    }

    @Override
    public void onLoadFinished(@NonNull Loader<MainPresenter> loader, MainPresenter mainPresenter) {
        this.mainPresenter=mainPresenter;
    }

    @Override
    public void onLoaderReset(@NonNull Loader<MainPresenter> loader) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSubmit:
                mainPresenter.submitName(editText.getText().toString());
                break;
            case R.id.btnClear:
                mainPresenter.clearName();
                break;
        }
    }

    @Override
    public void updateUI(MainState mainState) {
        switch (mainState.getCommand()){
            case MainState.ViewCommand.CLEAR_NAME:
                editText.setText("");
                textView.setText("Default Text");
                break;
            case MainState.ViewCommand.SHOW_ERROR_TOAST:
                Toast.makeText(this, "Please enter at least one character", Toast.LENGTH_SHORT).show();
                break;
            case MainState.ViewCommand.SHOW_NAME:
                editText.setText("");
                textView.setText(mainState.getName());
                break;
        }
    }
}
