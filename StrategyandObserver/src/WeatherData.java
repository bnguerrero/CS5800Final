public class WeatherData {
    private String location;
    private double temperature;
    private double humidity;
    private String weatherCondition;

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    @Override
    public String toString() {
        return "Location: " + location +
                "\nTemperature: " + temperature + "°F" +
                "\nHumidity: " + humidity + "%" +
                "\nWeather Condition: " + weatherCondition;
    }
}
