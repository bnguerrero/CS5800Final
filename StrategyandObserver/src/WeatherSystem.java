import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeatherSystem {
    private List<WeatherService> weatherServices;
    private final Map<User, String> users;
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public WeatherSystem() {
        this.weatherServices = new ArrayList<>();
        this.users = new HashMap<>();
    }

    public void addWeatherService(WeatherService weatherService) {
        this.weatherServices.add(weatherService);
    }

    public void registerUser(User user, String location) {
        this.users.put(user, location);
    }

    public void unregisterUser(User user) {
        this.users.remove(user);
    }

    public void PropertyChange(PropertyChangeEvent event) {
        weatherServices.add((WeatherService) event.getNewValue());
    }

    public void updateWeather() {
        for (User user : users.keySet()) {
            WeatherData data = user.getWeatherApp().getWeatherData(users.get(user));
            user.notifyWeatherUpdate(data);
            System.out.println();
        }
    }
}
