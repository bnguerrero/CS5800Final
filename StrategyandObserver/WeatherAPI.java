package CS5800Final.StrategyandObserver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.tools.JavaFileObject;

public class WeatherAPI 
{
    private String URL = "https://api.weatherapi.com";
    private String API_KEY = "14b115ece73347d4a0871208231805";
    
    public WeatherData getWeatherData(String location)
    {
        String endpoint = URL + "/v1/current.json?key=" + API_KEY + "&q=" + location;
        
        try 
        {
            URL url = new URL(endpoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

           
        } 
        catch(IOException e) 
        {
            
        }
    }
}
