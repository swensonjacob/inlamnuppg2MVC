package se.jacobswenson.app;

import se.jacobswenson.observers.Observer1;
import se.jacobswenson.observers.Observer2;
import se.jacobswenson.view.ViewFacade;

public class Main {

    public static void main(String[] args) {
	ViewFacade facade = new ViewFacade();
	facade.registerObserver(new Observer1());
	facade.registerObserver(new Observer2());
    }
}
