package com.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

interface StocksObservable {
    public void add(NotificationAlertObserver notificationAlertObserver);
    public void remove(NotificationAlertObserver notificationAlertObserver);
    public void notifySubscribers();
    public void setStocks(int newStockAdded);
    public int getStocks();

}

class IphoneObservable implements StocksObservable {
    List<NotificationAlertObserver> notificationAlertObservers = new ArrayList<>();
    int StockCount = 0;

    @Override
    public void add(NotificationAlertObserver notificationAlertObserver) {
        notificationAlertObservers.add(notificationAlertObserver);
    }

    @Override
    public void remove(NotificationAlertObserver notificationAlertObserver) {
        notificationAlertObservers.remove(notificationAlertObserver);
    }

    @Override
    public void notifySubscribers() {
        for(NotificationAlertObserver notificationAlertObserver : notificationAlertObservers) {
            notificationAlertObserver.update();
        }
    }

    @Override
    public void setStocks(int newStockAdded) {
        if(StockCount==0) {
            notifySubscribers();
        }
        StockCount+=newStockAdded;
    }

    @Override
    public int getStocks() {
        return StockCount;
    }
}

interface NotificationAlertObserver {
    void update();
}

class MobileObserver implements NotificationAlertObserver {
    String mobileNo;
    StocksObservable stocksObservable;

    public MobileObserver(String mobileNo, StocksObservable stocksObservable) {
        this.mobileNo = mobileNo;
        this.stocksObservable = stocksObservable;
    }

    @Override
    public void update() {
        System.out.println("Send Notification on Mobile");
    }
}

class EmailObserver implements NotificationAlertObserver {
    String email;
    StocksObservable stocksObservable;

    public EmailObserver(String email, StocksObservable stocksObservable) {
        this.email = email;
        this.stocksObservable = stocksObservable;
    }

    @Override
    public void update() {
        System.out.println("Send Notification on Mail");
    }
}




public class ObserverPattern {
    public static void main(String []args) {
        StocksObservable iphoneObservable = new IphoneObservable();
        NotificationAlertObserver mobileNot = new MobileObserver("123",iphoneObservable);
        NotificationAlertObserver emailNot = new EmailObserver("@gmail.com",iphoneObservable);
        iphoneObservable.add(mobileNot);
        iphoneObservable.setStocks(10);
    }
}
