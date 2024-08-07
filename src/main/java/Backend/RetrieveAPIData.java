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
        int indexOfCurrentTime = findIndexOfCurrentTime(timeData);

        // get temperature
        JSONArray temperatureData = (JSONArray) hourlyData.get("temperature_2m");
        double temperature = (double) temperatureData.get(indexOfCurrentTime);

        // get weather code
        JSONArray weatherCode = (JSONArray) hourlyData.get("weather_code");
        WeatherCondition weatherCondition = processWeatherCode((int) weatherCode.get(indexOfCurrentTime));

        // get humidity
        JSONArray humidityData = (JSONArray) hourlyData.get("relative_humidity_2m");
        double humidity = (double) humidityData.get(indexOfCurrentTime);

        // get wind speed
        JSONArray windSpeedData = (JSONArray) hourlyData.get("wind_speed_10m");
        double windSpeed = (double) windSpeedData.get(indexOfCurrentTime);

        return buildWeatherDataObject(weatherCondition, temperature, humidity, windSpeed);
    }

    public static JSONArray getGeographicCoordinates(String locationName)
    {
        locationName = locationName.replaceAll(" ", "+");
        return (JSONArray) callAPI(buildLocationURL(locationName)).get("results");
    }

    private static JSONObject buildWeatherDataObject(WeatherCondition weatherCondition, double temperature, double humidity, double windSpeed)
    {
        JSONObject weatherData = new JSONObject();
        weatherData.put("weather_condition", weatherCondition);
        weatherData.put("temperature", temperature);
        weatherData.put("humidity", humidity);
        weatherData.put("wind_speed", windSpeed);

        return weatherData;
    }

    private static WeatherCondition processWeatherCode(int weatherCode)
    {
        switch (weatherCode)
        {
            case 0 -> {
                return WeatherCondition.CLEAR_SKY;
            }
            case 1, 2, 3 -> {
                return WeatherCondition.CLOUDY;
            }
            case 45, 48 -> {
                return WeatherCondition.FOG;
            }
            case 51, 53, 55 -> {
                return WeatherCondition.DRIZZLE;
            }
            case 56, 57 -> {
                return WeatherCondition.FREEZING_DRIZZLE;
            }
            case 61, 63, 65 -> {
                return WeatherCondition.RAIN;
            }
            case 66, 67 -> {
                return WeatherCondition.FREEZING_RAIN;
            }
            case 71, 73, 75 -> {
                return WeatherCondition.SNOW_FALL;
            }
            case 77 -> {
                return WeatherCondition.SNOW_GRAINS;
            }
            case 80, 81, 82 -> {
                return WeatherCondition.RAIN_SHOWERS;
            }
            case 85, 86 -> {
                return WeatherCondition.SNOW_SHOWERS;
            }
            case 95 -> {
                return WeatherCondition.THUNDERSTORM;
            }
            case 96, 99 -> {
                return WeatherCondition.HAIL_THUNDERSTORM;
            }
        }

        return  WeatherCondition.UNIDENTIFIED;
    }

    private static int findIndexOfCurrentTime(JSONArray timeData)
    {
        String currentTime = getCurrentTime();

        for (int i = 0; i < timeData.size(); ++i)
        {
            String time = (String) timeData.get(i);

            if (time.equalsIgnoreCase(currentTime)) return i;
        }

        return 0;
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
