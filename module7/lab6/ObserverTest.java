package Modules.module7.lab6;

public class ObserverTest {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        // create some observers
        WeatherDisplay mobileApp = new WeatherDisplay("Mobile App");
        WeatherDisplay digitalBillboard = new WeatherDisplay("Electric panel");
        EmailAlert emailAlert = new EmailAlert("adilkhan@gmail.com");

        // register
        weatherStation.register(mobileApp);
        weatherStation.register(digitalBillboard);
        weatherStation.register(emailAlert);

        // set temp
        weatherStation.setTemperature(25.0f);
        weatherStation.setTemperature(30.0f);

        // remove
        weatherStation.remove(digitalBillboard);
        weatherStation.setTemperature(28.0f);
    }
}
