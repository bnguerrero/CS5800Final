import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class User {
    private String name;
    private WeatherService weatherApp;
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public User(String name, WeatherService weatherApp) {
        this.name = name;
        setWeatherApp(weatherApp);
    }

    public void update(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public String getName() {
        return name;
    }

    public void setWeatherApp(WeatherService weatherApp) {
        support.firePropertyChange(this.name, this.weatherApp, weatherApp);
        this.weatherApp = weatherApp;
    }

    public WeatherService getWeatherApp() {
        return weatherApp;
    }

    public void notifyWeatherUpdate(WeatherData weatherData) {
        System.out.println("Weather data for " + name + ": " + weatherData);
    }
}