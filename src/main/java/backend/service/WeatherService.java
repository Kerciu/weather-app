package main.java.backend.service;

import main.java.backend.utils.TimeUtils;
import main.java.backend.model.WeatherConditions;
import main.java.backend.model.WeatherData;
import main.java.backend.api.APIUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class WeatherService {

    public static WeatherData getWeatherData(double latitude, double longitude)
    {
        String urlString = buildWeatherURL(latitude, longitude);
        JSONObject response = APIUtils.callAPI(urlString);
        JSONObject hourlyData = (JSONObject) response.get("hourly");
        JSONArray timeData = (JSONArray) hourlyData.get("time");
        int indexOfCurrentTime = TimeUtils.findIndexOfCurrentTime(timeData);

        // get weather code
        WeatherConditions weatherCondition = getWeatherConditionState(hourlyData, indexOfCurrentTime);
        double temperature = getWeatherAttribute(hourlyData, indexOfCurrentTime, "temperature_2m");
        double humidity = getWeatherAttribute(hourlyData, indexOfCurrentTime, "relative_humidity_2m");
        double windSpeed = getWeatherAttribute(hourlyData, indexOfCurrentTime, "wind_speed_10m");

        return new WeatherData(weatherCondition, temperature, humidity, windSpeed);
    }

    private static WeatherConditions getWeatherConditionState(JSONObject hourlyData, int timeIdx)
    {
        JSONArray weatherCode = (JSONArray) hourlyData.get("weather_code");
        Long weatherCodeLong = (Long) weatherCode.get(timeIdx);
        return processWeatherCode(weatherCodeLong.intValue());
    }

    private static double getWeatherAttribute(JSONObject hourlyData, int timeIdx, String whatToFetch)
    {
        JSONArray data = (JSONArray) hourlyData.get(whatToFetch);
        Object value = data.get(timeIdx);
        if (value instanceof Long) {
            return ((Long) value).doubleValue();
        } else if (value instanceof Double) {
            return (Double) value;
        } else {
            throw new ClassCastException("Unexpected type: " + value.getClass().getName());
        }
    }

    private static String buildWeatherURL(double latitude, double longitude) {
        return "https://api.open-meteo.com/v1/forecast?latitude=" + latitude +
                "&longitude=" + longitude +
                "&hourly=temperature_2m,relative_humidity_2m,weather_code,wind_speed_10m";
    }

    private static WeatherConditions processWeatherCode(int weatherCode)
    {
        switch (weatherCode)
        {
            case 0 -> {
                return WeatherConditions.SUNNY;
            }
            case 1 -> {
                return WeatherConditions.SUNNY_CLOUDY;
            }
            case 2, 3 -> {
                return WeatherConditions.CLOUDY;
            }
            case 45, 48 -> {
                return WeatherConditions.FOG;
            }
            case 51, 53, 55 -> {
                return WeatherConditions.DRIZZLE;
            }
            case 56, 57, 66, 67 -> {
                return WeatherConditions.SLEET;
            }
            case 61, 63, 65 -> {
                return WeatherConditions.RAIN;
            }
            case 71, 73, 75, 77 -> {
                return WeatherConditions.SNOWY;
            }
            case 80, 81, 82 -> {
                return WeatherConditions.DOWNPOUR;
            }
            case 85, 86 -> {
                return WeatherConditions.SNOWSTORM;
            }
            case 95 -> {
                return WeatherConditions.THUNDERSTORM;
            }
            case 96, 99 -> {
                return WeatherConditions.HAIL_THUNDERSTORM;
            }
            default -> {
                return WeatherConditions.UNIDENTIFIED;
            }
        }
    }
}
