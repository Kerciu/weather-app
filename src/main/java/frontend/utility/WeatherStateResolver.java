package main.java.frontend.utility;

import main.java.backend.model.WeatherConditions;

public class WeatherStateResolver {
    public static final String assetsPath = "assets/images/weather/";

    public static String getWeatherImagePath(WeatherConditions cond) {
        return switch (cond) {
            case SUNNY -> resolveSunnyState();
            case CLOUDY -> assetsPath + "cloudy.png";
            case FOG -> assetsPath + "foggy.png";
            case DRIZZLE -> assetsPath + "drizzle.png";
            case RAIN -> assetsPath + "rainy.png";
            case SLEET -> assetsPath + "sleet.png";
            case SNOWY -> assetsPath + "snowy.png";
            case DOWNPOUR -> assetsPath + "downpour.png";
            case SNOWSTORM -> assetsPath + "snowstorm.png";
            case THUNDERSTORM -> assetsPath + "dark-and-stormy.png";
            case HAIL_THUNDERSTORM -> assetsPath + "hail.png";
            default -> assetsPath + "cloudy-sunny.png";
        };
    }

    public static String getWeatherConditionName(WeatherConditions cond) {
        return switch (cond) {
            case SUNNY -> "Sunny";
            case SUNNY_CLOUDY -> "Sunny with Clouds";
            case CLOUDY -> "Cloudy";
            case FOG -> "Foggy";
            case DRIZZLE -> "Drizzle";
            case RAIN -> "Rainy";
            case SLEET -> "Sleet";
            case SNOWY -> "Snowy";
            case DOWNPOUR -> "Downpour";
            case SNOWSTORM -> "Snowstorm";
            case THUNDERSTORM -> "Thunderstorm";
            case HAIL_THUNDERSTORM -> "Hail with Thunderstorm";
            default -> "Unidentified Weather Condition";
        };
    }

    private static String resolveSunnyState()
    {
        return assetsPath + "sunny.png";
    }
}
