public class Main {
    public static void main(String[] args) {
        WeatherSystem weatherSystem = new WeatherSystem();

        WeatherApiService weatherApi = new WeatherApiService();
        WeatherGovService weatherGov = new WeatherGovService();
        OpenMeteoService openMeteo = new OpenMeteoService();

        weatherSystem.addWeatherService(weatherApi);
        weatherSystem.addWeatherService(weatherGov);
        weatherSystem.addWeatherService(openMeteo);

        User john = new User("John", weatherApi);
        User bryan = new User("Bryan", weatherGov);
        User bob = new User("Bob", openMeteo);

        weatherSystem.registerUser(john, "Pomona");
        weatherSystem.registerUser(bryan, "New+York");
        weatherSystem.registerUser(bob, "San+Francisco");

        weatherSystem.updateWeather();
    }
}
