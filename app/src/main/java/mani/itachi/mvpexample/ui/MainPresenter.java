package mani.itachi.mvpexample.ui;

import mani.itachi.mvpexample.managers.DataManager;

public class MainPresenter {
    private MainViewInterface mainViewInterface;
    private DataManager dataManager;
    private MainState mainState;

    MainPresenter(DataManager dataManager){
        this.dataManager=dataManager;
        mainState=new MainState("Default Text");
    }

    void attachView(MainViewInterface mainViewInterface){
        this.mainViewInterface=mainViewInterface;
        mainViewInterface.updateUI(mainState);
    }

    void detachView() {
        this.mainViewInterface= null;
    }

    void submitName(String name) {
        if (name.trim().equals("")) {
            mainState.setCommand(MainState.ViewCommand.SHOW_ERROR_TOAST);
            mainViewInterface.updateUI(mainState);
            return;
        }
        dataManager.saveName(name);
        mainState.setCommand(MainState.ViewCommand.SHOW_NAME);
        mainState.setName(name);
        mainViewInterface.updateUI(mainState);
    }

    void clearName(){
        dataManager.saveName(null);
        mainState.setCommand(MainState.ViewCommand.CLEAR_NAME);
        mainViewInterface.updateUI(mainState);
    }

}
