package com.coworking.app.coworking_app.ObserverPattern;

import com.coworking.app.coworking_app.Model.Coworking;
import com.coworking.app.coworking_app.Model.User;
import org.springframework.stereotype.Component;

@Component
public class BookingClass implements BookingObserver{
@Override
    public void update(User user, Coworking coworking){
    System.out.println("Send notify to user" + user.getName() + "about boking coworking place" + coworking.getWorkSpaceName());
}
}
