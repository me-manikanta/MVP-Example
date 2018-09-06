package mani.itachi.mvpexample.ui;

import android.content.Context;
import android.support.v4.content.Loader;

public class MainLoader extends Loader<MainPresenter> {

    MainPresenter mainPresenter;

    public MainLoader(Context context,MainPresenter mainPresenter) {
        super(context);
        this.mainPresenter=mainPresenter;
    }

    @Override
    protected void onStartLoading(){
        deliverResult(mainPresenter);
    }

}
