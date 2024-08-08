package test.java.BackendTests;

import main.java.backend.model.LocationData;
import main.java.backend.service.RetrieveAPIData;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RetrieveAPIDataTest {
    @Test
    void testGetWeatherData_Success() {
        String locationName = "Berlin";
    }

    @Test
    void testGetLocationAndCountry_Success() {
        String locationName = "Berlin";
    }
}
