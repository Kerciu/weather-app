package main.java.Backend;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class RetrieveAPIData {
    public static JSONObject getWeatherData(String locationName)
    {
        JSONArray coordinatesArray = createCoordinatesArray(locationName);
        if (coordinatesArray == null || coordinatesArray.isEmpty()) return null;

        return getWeatherDataRelativeToLocation(coordinatesArray).toJSON();
    }

    private static JSONArray createCoordinatesArray(String locationName)
    {
        return GeocodingService.getGeographicCoordinates(locationName);
    }

    private static WeatherData getWeatherDataRelativeToLocation(JSONArray coordinatesArray)
    {
        JSONObject location = (JSONObject) coordinatesArray.get(0);
        double latitude = (double) location.get("latitude");
        double longitude = (double) location.get("longitude");

        return WeatherService.getWeatherData(latitude, longitude);
    }
}
