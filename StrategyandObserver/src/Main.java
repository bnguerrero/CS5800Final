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

        weatherSystem.registerUser(john);
        weatherSystem.registerUser(bryan);
        weatherSystem.registerUser(bob);

        WeatherData johnsWeatherData = john.getWeatherApp().getWeatherData("Pomona");
        WeatherData bryansWeatherData = bryan.getWeatherApp().getWeatherData("New+York");
        WeatherData bobsWeatherData = bob.getWeatherApp().getWeatherData("San+Francisco");

        System.out.println("Weather for " + john.getName() + ":\n" + johnsWeatherData);
        System.out.println("\nWeather for " + bryan.getName() + ":\n" + bryansWeatherData);
        System.out.println("\nWeather for " + bob.getName() + ":\n" + bobsWeatherData);
    }
}
