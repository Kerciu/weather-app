package main.java.Backend;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class RetrieveAPIData {
    public static JSONObject getWeatherData(String locationName)
    {
        JSONArray jsonArray = getGeographicCoordinates(locationName);

        // get the first search result, in case there is for example
        // "berlin" village in remote russian siberia
        JSONObject location = (JSONObject) jsonArray.get(0);
        double latitude = (double) location.get("latitude");
        double longitude = (double) location.get("longitude");

        String urlString = buildStringURLwithCoordinates(latitude, longitude);
        JSONObject hourlyData = (JSONObject) callAPI(urlString).get("hourly");
        JSONArray timeData = (JSONArray) hourlyData.get("time");

        return null;
    }

    public static JSONArray getGeographicCoordinates(String locationName)
    {
        locationName = locationName.replaceAll(" ", "+");
        return (JSONArray) callAPI(buildLocationURL(locationName)).get("results");
    }

    private static int findIndexOfCurrentTime(JSONArray timeData)
    {
        String currentTime = getCurrentTime();
    }

    private static String getCurrentTime()
    {
        LocalDateTime localDateTime = LocalDateTime.now();

        // format date to be something like ""2024-08-10T05:00"
        return localDateTime.format(createDateTimeFormatter());
    }

    private static DateTimeFormatter createDateTimeFormatter()
    {
        String formatPattern = "yyyy-MM-dd'T'HH':00'";
        return DateTimeFormatter.ofPattern(formatPattern);
    }

    private static String buildStringURLwithCoordinates(double latitude, double longitude)
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://api.open-meteo.com/v1/forecast?latitude=");
        stringBuilder.append(Double.toString(latitude));
        stringBuilder.append("&" + Double.toString(longitude));
        stringBuilder.append("&hourly=temperature_2m,relative_humidity_2m,weather_code,wind_speed_10m");
        return stringBuilder.toString();
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
