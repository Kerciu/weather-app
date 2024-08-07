package main.java.Backend;

import org.json.simple.JSONObject;

public class WeatherData {
    private WeatherConditions weatherCondition;
    private double temperature;
    private double humidity;
    private double windSpeed;

    public WeatherData(WeatherConditions weatherCondition, double temperature, double humidity, double windSpeed)
    {
        this.weatherCondition = weatherCondition;
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
    }

    public JSONObject toJSON()
    {
        JSONObject weatherData = new JSONObject();
        weatherData.put("weather_condition", weatherCondition);
        weatherData.put("temperature", temperature);
        weatherData.put("humidity", humidity);
        weatherData.put("wind_speed", windSpeed);

        return weatherData;
    }
}
