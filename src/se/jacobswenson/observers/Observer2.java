package se.jacobswenson.observers;

public class Observer2 implements Observer {

    @Override
    public void callMe() {
        System.out.println("Observer2 has observed the button press");
    }
}