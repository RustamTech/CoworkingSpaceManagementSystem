package com.coworking.app.coworking_app.ObserverPattern;

import com.coworking.app.coworking_app.Model.Coworking;
import com.coworking.app.coworking_app.Model.User;

public interface BookingObserver {
    void update(User user, Coworking coworking);
}
