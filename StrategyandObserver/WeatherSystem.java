package CS5800Final.StrategyandObserver;

//import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

public class WeatherSystem 
{
    private ArrayList<User> users;
    private ArrayList<WeatherService> weatherService;

    public WeatherSystem()
    {
        users = new ArrayList<>();
        weatherService = new ArrayList<>();
    }
    public void registerUser(User user)
    {
        users.add(user);
    }
    public void unregisterUser(User user)
    {
        users.remove(user);
    }
    public void PropertyChange(PropertyChangeEvent event)
    {
        weatherService.add((WeatherService) event.getNewValue());
    }

    public void notifyUsers()
    {
        weatherService.forEach(System.out:: println);
    }

}
