package org.lld.behavioralPattern.observerPattern.newsAgency;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String news);
}

//Step 2: Implement Concrete Observers

class NewsSubscriber implements Observer {
    private String name;

    public NewsSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println(name + " received news: " + news);
    }
}

//Step 3: Define the Subject (Observable) interface
interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String news);
}

//Step 4: Implement Concrete Subject

class NewsAgency implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String latestNews;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String news) {
        for (Observer observer : observers) {
            observer.update(news);
        }
    }

    public void publishNews(String news) {
        this.latestNews = news;
        notifyObservers(news);
    }
}



public class client {
    public static void main(String[] args) {
            NewsAgency newsAgency = new NewsAgency();

            // Subscribers
            Observer subscriber1 = new NewsSubscriber("Subscriber 1");
            Observer subscriber2 = new NewsSubscriber("Subscriber 2");

            // Register subscribers
            newsAgency.registerObserver(subscriber1);
            newsAgency.registerObserver(subscriber2);

            // Publish news
            newsAgency.publishNews("Breaking News: Observer Pattern Explained!");

            // Unregister a subscriber
            newsAgency.removeObserver(subscriber1);

            // Publish another news
            newsAgency.publishNews("Java 17 Released!");
    }
}
