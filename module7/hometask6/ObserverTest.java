package Modules.module7.hometask6;

import java.util.ArrayList;
import java.util.List;

interface IObserver {
    void update(String currency, double rate);
}

interface ISubject {
    void register(IObserver observer);
    void remove(IObserver observer);
    void notifies();
}

class CurrencyExchange implements ISubject {
    private List<IObserver> observers;
    private double exchangeRate;
    private String currency;

    public CurrencyExchange() {
        observers = new ArrayList<>();
    }

    public void setExchangeRate(String currency, double rate) {
        this.currency = currency;
        this.exchangeRate = rate;
        notifies();
    }

    @Override
    public void register(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void remove(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifies() {
        for (IObserver observer : observers) {
            observer.update(currency, exchangeRate);
        }
    }
}

class Trader implements IObserver {
    @Override
    public void update(String currency, double rate) {
        System.out.printf("Trader - New rate for %s is %.2f%n", currency, rate);
    }
}

class InvestmentBot implements IObserver {
    @Override
    public void update(String currency, double rate) {
        if (rate > 100) {
            System.out.printf("InvestmentBot - Consider selling %s at %.2f%n", currency, rate);
        }
    }
}

class CurrencyAlert implements IObserver {
    @Override
    public void update(String currency, double rate) {
        System.out.printf("CurrencyAlert: Alert! %s has changed to %.2f%n", currency, rate);
    }
}

public class ObserverTest {
    public static void main(String[] args) {
        CurrencyExchange currencyExchange = new CurrencyExchange();

        Trader trader = new Trader();
        InvestmentBot investmentBot = new InvestmentBot();
        CurrencyAlert currencyAlert = new CurrencyAlert();

        currencyExchange.register(trader);
        currencyExchange.register(investmentBot);
        currencyExchange.register(currencyAlert);

        currencyExchange.setExchangeRate("USD", 102.50);
        currencyExchange.setExchangeRate("EUR", 120.30);

        currencyExchange.remove(investmentBot);
        currencyExchange.setExchangeRate("GBP", 135.00);
    }
}
