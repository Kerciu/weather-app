package main.java.backend.service;

import main.java.backend.model.LocationData;
import main.java.backend.model.WeatherData;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class RetrieveAPIData {
    public static JSONObject getWeatherData(String locationName)
    {
        JSONArray coordinatesArray = createCoordinatesArray(locationName);
        if (coordinatesArray == null || coordinatesArray.isEmpty()) return null;

        return getWeatherDataRelativeToLocation(coordinatesArray).toJSON();
    }

    public static JSONObject getLocationAndCountry(String locationName)
    {
        JSONArray coordinatesArray = createCoordinatesArray(locationName);
        if (coordinatesArray == null || coordinatesArray.isEmpty()) return null;

        return getLocationDataRelativeToLocation(coordinatesArray).toJSON();
    }

    private static JSONArray createCoordinatesArray(String locationName)
    {
        return GeocodingService.getGeographicCoordinates(locationName);
    }

    private static LocationData getLocationDataRelativeToLocation(JSONArray coordinatesArray)
    {
        JSONObject locationJsonArray = (JSONObject) coordinatesArray.get(0);
        String location = (String) locationJsonArray.get("name");
        String country = (String) locationJsonArray.get("country");

        return new LocationData(location, country);
    }

    private static WeatherData getWeatherDataRelativeToLocation(JSONArray coordinatesArray)
    {
        JSONObject location = (JSONObject) coordinatesArray.get(0);
        double latitude = (double) location.get("latitude");
        double longitude = (double) location.get("longitude");

        return WeatherService.getWeatherData(latitude, longitude);
    }
}
