package main.java.Backend;

import main.java.Backend.WeatherConditions;
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
        return processWeatherCode((int) weatherCode.get(timeIdx));
    }

    private static double getWeatherAttribute(JSONObject hourlyData, int timeIdx, String whatToFetch)
    {
        JSONArray data = (JSONArray) hourlyData.get(whatToFetch);
        return  (double) data.get(timeIdx);
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
                return WeatherConditions.CLEAR_SKY;
            }
            case 1, 2, 3 -> {
                return WeatherConditions.CLOUDY;
            }
            case 45, 48 -> {
                return WeatherConditions.FOG;
            }
            case 51, 53, 55 -> {
                return WeatherConditions.DRIZZLE;
            }
            case 56, 57 -> {
                return WeatherConditions.FREEZING_DRIZZLE;
            }
            case 61, 63, 65 -> {
                return WeatherConditions.RAIN;
            }
            case 66, 67 -> {
                return WeatherConditions.FREEZING_RAIN;
            }
            case 71, 73, 75 -> {
                return WeatherConditions.SNOW_FALL;
            }
            case 77 -> {
                return WeatherConditions.SNOW_GRAINS;
            }
            case 80, 81, 82 -> {
                return WeatherConditions.RAIN_SHOWERS;
            }
            case 85, 86 -> {
                return WeatherConditions.SNOW_SHOWERS;
            }
            case 95 -> {
                return WeatherConditions.THUNDERSTORM;
            }
            case 96, 99 -> {
                return WeatherConditions.HAIL_THUNDERSTORM;
            }
        }

        return  WeatherConditions.UNIDENTIFIED;
    }
}
