import org.json.JSONArray;
import org.json.JSONObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherApiService implements WeatherService {
    private static final HttpClient httpClient = HttpClient.newHttpClient();
    private static final String API_KEY = "f5d2f8b306619877ff74299376f7325f";
    private String latitude;
    private String longitude;

    @Override
    public String toString() {
        return "Weather data from Weather API";
    }

    @Override
    public WeatherData getWeatherData(String area) {
        calculateLatitudeAndLongitude(area);
        String url = String.format("https://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&appid=%s"
                , latitude
                , longitude
                , API_KEY
        );

        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();

        HttpResponse<String> response;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        JSONObject jsonObject = new JSONObject(response.body());

        String city = jsonObject.getString("name");
        String county = jsonObject.getJSONObject("sys").getString("country");
        double temperature = jsonObject.getJSONObject("main").getDouble("temp");
        double temperatureInFahrenheit = (temperature - 273.15) * 9/5 + 32;    // kelvin to fahrenheit
        int roundedTemperature = (int) Math.round(temperatureInFahrenheit);
        double humidity = jsonObject.getJSONObject("main").getDouble("humidity");
        String weatherCondition = jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");

        WeatherData weatherData = new WeatherData();
        weatherData.setLocation(city + ", " + county);
        weatherData.setTemperature(roundedTemperature);
        weatherData.setHumidity(humidity);
        weatherData.setWeatherCondition(weatherCondition);

        return weatherData;
    }

    private void calculateLatitudeAndLongitude(String area) {
        String url = String.format("http://api.openweathermap.org/geo/1.0/direct?q=%s&limit=1&appid=%s"
                , area
                , API_KEY
        );

        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();

        HttpResponse<String> response = null;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JSONArray jsonArray = new JSONArray(response.body());
        JSONObject jsonObject = jsonArray.getJSONObject(0);

        latitude = Double.toString(jsonObject.getDouble("lat"));
        longitude = Double.toString(jsonObject.getDouble("lon"));
    }


}
