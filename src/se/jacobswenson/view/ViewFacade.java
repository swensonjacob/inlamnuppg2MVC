package se.jacobswenson.view;

import se.jacobswenson.controller.Controller;
import se.jacobswenson.subject.Subject;
import se.jacobswenson.observers.Observer;

import java.util.ArrayList;
import java.util.List;

public class ViewFacade implements Subject {

    Controller controller;
    View view;
    List<Observer> observerList;

    public ViewFacade() {
        this.view = new View(this);
        this.controller = new Controller();
        this.observerList = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
    observerList.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
    observerList.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer:observerList) {
            observer.callMe();
        }
    }

    public void UpdateText(int choice) {
        view.changeLabelText(controller.getNumberFromModel(choice));
        notifyObservers();
    }
}
