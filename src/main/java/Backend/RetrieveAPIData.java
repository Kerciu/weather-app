package main.java.Backend;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class RetrieveAPIData {
    public static JSONObject getWeatherData(String locationName)
    {
        JSONArray jsonArray = getGeographicCoordinates(locationName);

        return null;
    }

    public static JSONArray getGeographicCoordinates(String locationName)
    {
        locationName = locationName.replaceAll(" ", "+");
        return (JSONArray) callAPI(buildLocationURL(locationName)).get("results");
    }

    private static String buildLocationURL(String locationName)
    {
        String urlString =
        "https://geocoding-api.open-meteo.com/v1/search?name="
                + locationName +
        "&count=10&language=en&format=json";

        return urlString;
    }

    private static JSONObject callAPI(String urlAddress)
    {
        try {
            HttpURLConnection httpURLConnection = fetchAPIresponse(urlAddress);
            if (httpURLConnection.getResponseCode() != 200 || httpURLConnection == null)
            {
                System.out.println("Error: could not fetch the API");
                return null;
            }

            StringBuilder jsonResult = buildJsonResultStringBuilder(httpURLConnection);
            httpURLConnection.disconnect();

            return parseJsonStringIntoObject(jsonResult);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    private static JSONObject parseJsonStringIntoObject(StringBuilder jsonStringBuilder) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(String.valueOf(jsonStringBuilder));
        return jsonObject;
    }

    private static StringBuilder buildJsonResultStringBuilder(HttpURLConnection connection) throws  IOException
    {
        StringBuilder jsonResult = new StringBuilder();
        Scanner scanner = new Scanner(connection.getInputStream());

        while (scanner.hasNext())
        {
            jsonResult.append(scanner.nextLine());
        }

        scanner.close();

        return jsonResult;
    }

    private static HttpURLConnection fetchAPIresponse(String urlAddress) {
        try {
            URL url = new URL(urlAddress);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();

            return httpURLConnection;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }
}
