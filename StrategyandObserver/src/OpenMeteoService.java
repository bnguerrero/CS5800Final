import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;

public class OpenMeteoService implements WeatherService {
    private static final HttpClient httpClient = HttpClient.newHttpClient();
    private String location;
    private String latitude;
    private String longitude;

    @Override
    public String toString() {
        return "Weather data from Open-Meteo";
    }

    @Override
    public WeatherData getWeatherData(String area) {
        calculateLatitudeAndLongitude(area);
        String url = String.format(
                "https://api.open-meteo.com/v1/forecast?latitude=%s&longitude=%s&hourly=temperature_2m" +
                        ",relativehumidity_2m,rain,showers,snowfall,cloudcover&timezone=America%%2FLos_Angeles"
                , latitude
                , longitude
        );

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        JSONObject jsonObject = new JSONObject(response.body());
        JSONObject hourlyObject = jsonObject.getJSONObject("hourly");
        JSONArray temperatureArray = hourlyObject.getJSONArray("temperature_2m");
        JSONArray humidityArray = hourlyObject.getJSONArray("relativehumidity_2m");
        JSONArray rainArray = hourlyObject.getJSONArray("rain");
        JSONArray showersArray = hourlyObject.getJSONArray("showers");
        JSONArray snowfallArray = hourlyObject.getJSONArray("snowfall");
        JSONArray cloudCoverArray = hourlyObject.getJSONArray("cloudcover");

        double temperature = temperatureArray.getDouble(0);
        double temperatureInFahrenheit = temperature * 1.8 + 32;
        double humidity = humidityArray.getDouble(0);
        double rain = rainArray.getDouble(0);
        double showers = showersArray.getDouble(0);
        double snowfall = snowfallArray.getDouble(0);
        double cloudCover = cloudCoverArray.getDouble(0);
        String weatherCondition = getWeatherCondition(rain, showers, snowfall, cloudCover);

        WeatherData weatherData = new WeatherData();
        weatherData.setLocation(location);
        weatherData.setTemperature(temperatureInFahrenheit);
        weatherData.setHumidity(humidity);
        weatherData.setWeatherCondition(weatherCondition);

        return weatherData;
    }

    public void calculateLatitudeAndLongitude(String area) {
        String url = String.format(
                "https://geocoding-api.open-meteo.com/v1/search?name=%s&count=1&language=en&format=json"
                , area
        );

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        HttpResponse<String> response = null;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JSONObject rootObject = new JSONObject(response.body());
        JSONArray jsonArray = rootObject.getJSONArray("results");
        JSONObject jsonObject = jsonArray.getJSONObject(0);

        String city =jsonObject.getString("name");
        String country = jsonObject.getString("country_code");
        this.location = city + ", " + country;

        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        double lat = jsonObject.getDouble("latitude");
        this.latitude = decimalFormat.format(lat);
        double lon = jsonObject.getDouble("longitude");
        this.longitude = decimalFormat.format(lon);
    }

    private String getWeatherCondition(double rain, double showers, double snowfall, double cloudCover) {
        if (rain > 0 ) {
            return "Raining";
        } else if (showers > 0) {
            return "Shower";
        } else if (snowfall > 0) {
                return "Snowing";
        } else if (cloudCover > 50) {
            return "Cloudy";
        } else {
            return "Clear sky";
        }
    }
}
