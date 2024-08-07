package main.java.backend.api;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class APIUtils {
    public static JSONObject callAPI(String urlAddress)
    {
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = fetchAPIresponse(urlAddress);
            if (httpURLConnection.getResponseCode() != 200 || httpURLConnection == null)
            {
                System.out.println("Error: could not fetch the API");
                return null;
            }

            StringBuilder jsonResult = buildJsonResultStringBuilder(httpURLConnection);
            return parseJsonStringIntoObject(jsonResult);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }

        return null;
    }

    private static JSONObject parseJsonStringIntoObject(StringBuilder jsonStringBuilder) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        return (JSONObject) jsonParser.parse(String.valueOf(jsonStringBuilder));
    }

    private static StringBuilder buildJsonResultStringBuilder(HttpURLConnection connection) throws IOException
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

    private static HttpURLConnection fetchAPIresponse(String urlAddress) throws IOException{
        URL url = new URL(urlAddress);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();

        return httpURLConnection;
    }
}
