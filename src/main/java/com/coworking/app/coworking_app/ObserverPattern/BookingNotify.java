package com.coworking.app.coworking_app.ObserverPattern;

import com.coworking.app.coworking_app.Model.Coworking;
import com.coworking.app.coworking_app.Model.User;

import java.util.ArrayList;
import java.util.List;

public class BookingNotify {
    private final List<BookingObserver> observers = new ArrayList<>();

    public void addObserver(BookingObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(User user, Coworking coworking) {
        observers.forEach(observer -> observer.update(user, coworking));
    }
}
