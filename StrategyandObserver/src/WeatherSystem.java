import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class WeatherSystem {
    private List<WeatherService> weatherServices;
    private List<User> users;
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public WeatherSystem() {
        this.weatherServices = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addWeatherService(WeatherService weatherService) {
        this.weatherServices.add(weatherService);
    }

    public void registerUser(User user) {
        this.users.add(user);
    }

    public void unregisterUser(User user) {
        this.users.remove(user);
    }

    public void PropertyChange(PropertyChangeEvent event) {
        weatherServices.add((WeatherService) event.getNewValue());
    }

    public void notifyUsers() {
        weatherServices.forEach(System.out:: println);
    }
}
