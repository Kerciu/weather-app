package main.java.backend.model;

import org.json.simple.JSONObject;

public class LocationData {
    private String location;
    private String country;

    public LocationData(String location, String country)
    {
        this.location = location;
        this.country = country;
    }

    public JSONObject toJSON()
    {
        JSONObject locationData = new JSONObject();
        locationData.put("location", location);
        locationData.put("country", country);

        return locationData;
    }
}
