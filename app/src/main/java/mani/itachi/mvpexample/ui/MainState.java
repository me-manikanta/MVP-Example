package mani.itachi.mvpexample.ui;

class MainState {

    private int command =-1;
    private String name;

    MainState(String name){
        this.name=name;
    }

    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        this.command = command;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    class ViewCommand {
        static final int CLEAR_NAME = 0;
        static final int SHOW_NAME = 1;
        static final int SHOW_ERROR_TOAST = 2;
    }

}
