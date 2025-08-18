package org.lld.behavioralPattern.observerPattern.stockMarket;

import java.util.ArrayList;
import java.util.List;

//Step 1: Observer Interface
interface StockObserver {
    void update(String stockSymbol, double stockPrice);
}

//Step 2: Create the ConcreteObserver class

class Investor1 implements StockObserver {
    private String name;

    public Investor1(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockSymbol, double stockPrice) {
        System.out.println(name + " received an update for " + stockSymbol + ": $" + stockPrice);
    }
}



//step 3: Subject Interface

interface StockMarket {
    void registerObserver(StockObserver observer);
    void removeObserver(StockObserver observer);
    void notifyObservers(String stockSymbol, double stockPrice);
}

class StockMarketImpl implements StockMarket {
    private List<StockObserver> observers = new ArrayList<>();

    @Override
    public void registerObserver(StockObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String stockSymbol, double stockPrice) {
        for (StockObserver observer : observers) {
            observer.update(stockSymbol, stockPrice);
        }
    }

    // Simulate stock price changes
    public void setStockPrice(String stockSymbol, double stockPrice) {
        notifyObservers(stockSymbol, stockPrice);
    }
}
public class Client {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarketImpl();
        StockObserver investor1 = new Investor1("Alice");
        StockObserver investor2 = new Investor1("Bob");

        stockMarket.registerObserver(investor1);
        stockMarket.registerObserver(investor2);

        ((StockMarketImpl) stockMarket).setStockPrice("INFY", 1250.0); // Both investors receive updates
        ((StockMarketImpl) stockMarket).setStockPrice("TCS", 2500.0); // Both investors receive updates

        ((StockMarketImpl) stockMarket).removeObserver(investor1);

        ((StockMarketImpl) stockMarket).setStockPrice("WIPRO", 700.0); // Only investor2 receives the update
    }

}
