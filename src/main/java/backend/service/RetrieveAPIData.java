package main.java.backend.service;

import main.java.backend.model.LocationData;
import main.java.backend.model.WeatherData;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.HashSet;
import java.util.Set;

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

        String country = (String) locationJsonArray.get("country");
        String location = constructLocationName(locationJsonArray, country);


        return new LocationData(location, country);
    }

    private static String constructLocationName(JSONObject locationJsonArray, String countryName)
    {
        StringBuilder locationBuilder = new StringBuilder();

        String location = (String) locationJsonArray.get("name");
        locationBuilder.append(location);

        Set<String> uniqueParts = new HashSet<>();
        uniqueParts.add(location);
        uniqueParts.add(countryName);

        String admin1 = (String) locationJsonArray.get("admin1");
        if (admin1 != null && !uniqueParts.contains(admin1))
        {
            locationBuilder.append(", ").append(admin1);
            uniqueParts.add(admin1);
        }

        String admin2 = (String) locationJsonArray.get("admin2");
        if (admin2 != null && !uniqueParts.contains(admin2))
        {
            locationBuilder.append(", ").append(admin2);
            uniqueParts.add(admin2);
        }

        String country = (String) locationJsonArray.get("country");
        if (country != null && !uniqueParts.contains(country))
        {
            locationBuilder.append(", ").append(country);
            uniqueParts.add(country);
        }

        return locationBuilder.toString();
    }

    private static WeatherData getWeatherDataRelativeToLocation(JSONArray coordinatesArray)
    {
        JSONObject location = (JSONObject) coordinatesArray.get(0);
        double latitude = (double) location.get("latitude");
        double longitude = (double) location.get("longitude");

        return WeatherService.getWeatherData(latitude, longitude);
    }
}
