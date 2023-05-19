import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;

public class WeatherGovService implements WeatherService {
    private static final HttpClient httpClient = HttpClient.newHttpClient();
    private String latitude;
    private String longitude;

    @Override
    public String toString() {
        return "Weather data from Weather Gov";
    }

    @Override
    public WeatherData getWeatherData(String area) {
        calculateLatitudeAndLongitude(area);
        String url = String.format("https://api.weather.gov/points/%s,%s", latitude, longitude);

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url))
                .header("CPP", "Weather system application")
                .build();

        HttpResponse<String> response;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        JSONObject jsonObject = new JSONObject(response.body());

        JSONObject relativeLocation = jsonObject.getJSONObject("properties").getJSONObject("relativeLocation")
                .getJSONObject("properties");
        String city = relativeLocation.getString("city");
        String state = relativeLocation.getString("state");
        String location = city + ", " + state;

        String forecastUrl = jsonObject.getJSONObject("properties").getString("forecast");

        HttpRequest weatherGovForecastRequest = HttpRequest.newBuilder().uri(URI.create(forecastUrl))
                .header("CPP", "Weather system application")
                .build();
        HttpResponse<String> weatherGovForecastResponse;
        try {
            weatherGovForecastResponse = httpClient.send(weatherGovForecastRequest
                    , HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        JSONObject forecastObject = new JSONObject(weatherGovForecastResponse.body());
        JSONArray periodsForecastArray = forecastObject.getJSONObject("properties").getJSONArray("periods");
        JSONObject firstPeriodForecastObject = periodsForecastArray.getJSONObject(0);

        double temperature = firstPeriodForecastObject.getDouble("temperature");
        double humidity = firstPeriodForecastObject.getJSONObject("relativeHumidity").getDouble("value");
        String weatherCondition = firstPeriodForecastObject.getString("detailedForecast");

        WeatherData weatherData = new WeatherData();
        weatherData.setLocation(location);
        weatherData.setTemperature(temperature);
        weatherData.setHumidity(humidity);
        weatherData.setWeatherCondition(weatherCondition);
        return weatherData;
    }

    public void calculateLatitudeAndLongitude(String area) {
        String api_key = "f5d2f8b306619877ff74299376f7325f";
        String url = String.format(
                "http://api.openweathermap.org/geo/1.0/direct?q=%s&limit=1&appid=%s"
                , area
                , api_key
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

        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        double lat = jsonObject.getDouble("lat");
        this.latitude = decimalFormat.format(lat);
        double lon = jsonObject.getDouble("lon");
        this.longitude = decimalFormat.format(lon);
    }
}
