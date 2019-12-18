package se.jacobswenson.controller;

import se.jacobswenson.model.Model;

public class Controller {
    private Model model;

    public Controller() {
        this.model = new Model(this);
    }

    public void setModel(Model model) {
        this.model = model;
    }
    public String getNumberFromModel(int number) {
        return model.getNumber(number);
    }
}
