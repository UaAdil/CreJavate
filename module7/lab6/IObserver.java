package Modules.module7.lab6;

import java.util.ArrayList;
import java.util.List;

public interface IObserver {
    void update(float temperature);
}

interface ISubject {
    void register(IObserver observer);
    void remove(IObserver observer);
    void notifies();
}

class WeatherStation implements ISubject {
    private List<IObserver> observers;
    private float temperature;

    public WeatherStation() {
        observers = new ArrayList<>();
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
            observer.update(temperature);
        }
    }

    public void setTemperature(float newTemperature) {
        System.out.println("Changing temperature: " + newTemperature + "°C");
        this.temperature = newTemperature;
        notifies();
    }
}


class WeatherDisplay implements IObserver {
    private String name;

    public WeatherDisplay(String name) {
        this.name = name;
    }

    @Override
    public void update(float temperature) {
        System.out.println(name + "has showed new temperature: " + temperature + "°C");
    }
}


class EmailAlert implements IObserver {
    private String email;

    public EmailAlert(String email) {
        this.email = email;
    }

    @Override
    public void update(float temperature) {
        System.out.println("Sent to " + email + ": The temperature has changed by " + temperature + "°C");
    }
}
