package test.java.BackendTests;

import main.java.backend.api.APIUtils;
import main.java.backend.service.GeocodingService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GeocodingServiceTest {
    @Test
    void testGetGeographicCoordinates_Success() {
        String locationName = "Berlin";
        String url = "https://geocoding-api.open-meteo.com/v1/search?name=Berlin&count=10&language=en&format=json";
    }

    @Test
    void testGetGeographicCoordinates_NoResults() {
        String locationName = "UnknownPlace";
        String url = "https://geocoding-api.open-meteo.com/v1/search?name=UnknownPlace&count=10&language=en&format=json";
    }
}
