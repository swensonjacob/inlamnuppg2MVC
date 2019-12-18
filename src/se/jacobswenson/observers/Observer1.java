package se.jacobswenson.observers;

public class Observer1 implements Observer {

    @Override
    public void callMe() {
        System.out.println("Observer1 has observed the button press");
    }
}
