package se.jacobswenson.subject;

import se.jacobswenson.observers.Observer;

public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
