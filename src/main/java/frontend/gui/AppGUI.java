package main.java.frontend.gui;

import main.java.backend.model.WeatherConditions;
import main.java.backend.service.RetrieveAPIData;
import main.java.frontend.components.*;
import main.java.frontend.text.*;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppGUI extends JFrame {
    private JSONObject weatherData;
    private JTextField searchField;
    private JButton searchButton;

    public AppGUI()
    {
        super("Weather App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(450, 620));
        setLocationRelativeTo(null);

        setResizable(false);

        generateGradientBackground();
        setLayout(null);

        generateGuiComponents();
    }

    public JSONObject getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(JSONObject weatherData) {
        this.weatherData = weatherData;
    }

    private void generateGuiComponents()
    {
        generateSearchFieldComponent();
        generateWeatherCondition(null);
        generateHumidityInformation();
        generateWindSpeedInformation();
        generateSearchButtonComponent();
    }

    private void generateSearchFieldComponent()
    {
        searchField = SearchField.createSearchField();
        add(searchField);
    }

    private void generateSearchButtonComponent()
    {
        searchButton = SearchField.createSearchButton("assets/images/loupe.png");
        searchButton.addActionListener(createButtonActionListener());
        add(searchButton);
    }

    private ActionListener createButtonActionListener()
    {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weatherData = RetrieveAPIData.getWeatherData(processUserInput());
                if (weatherData != null)
                {
                    WeatherConditions cond = parseWeatherCondition();
                    updateWeatherInformation(cond);
                }
            }
        };
    }

    private WeatherConditions parseWeatherCondition()
    {
        return (WeatherConditions) weatherData.get("weather_condition");
    }

    private void updateWeatherInformation(WeatherConditions cond)
    {
        getContentPane().removeAll();

        generateWeatherCondition(cond);
        generateHumidityInformation();
        generateWindSpeedInformation();

        add(searchField);
        add(searchButton);

        revalidate();
        repaint();
    }

    private String createWeatherImagePath(WeatherConditions cond) {
        String assetsPath = "assets/images/";
        switch (cond) {
            case SUNNY:
                return assetsPath + "sunny.png";
            case CLOUDY:
                return assetsPath + "cloudy.png";
            case FOG:
                return assetsPath + "foggy.png";
            case DRIZZLE:
                return assetsPath + "drizzle.png";
            case RAIN:
                return assetsPath + "rainy.png";
            case SLEET:
                return assetsPath + "sleet.png";
            case SNOWY:
                return assetsPath + "snowy.png";
            case DOWNPOUR:
                return assetsPath + "downpour.png";
            case SNOWSTORM:
                return assetsPath + "snowstorm.png";
            case THUNDERSTORM:
                return assetsPath + "dark-and-stormy.png";
            case HAIL_THUNDERSTORM:
                return assetsPath + "hail.png";
            default:
                return assetsPath + "cloudy-sunny.png";
        }
    }

    private String getWeatherConditionName(WeatherConditions cond) {
        switch (cond) {
            case SUNNY:
                return "Sunny";
            case SUNNY_CLOUDY:
                return "Sunny with Clouds";
            case CLOUDY:
                return "Cloudy";
            case FOG:
                return "Foggy";
            case DRIZZLE:
                return "Drizzle";
            case RAIN:
                return "Rainy";
            case SLEET:
                return "Sleet";
            case SNOWY:
                return "Snowy";
            case DOWNPOUR:
                return "Downpour";
            case SNOWSTORM:
                return "Snowstorm";
            case THUNDERSTORM:
                return "Thunderstorm";
            case HAIL_THUNDERSTORM:
                return "Hail with Thunderstorm";
            default:
                return "Unidentified Weather Condition";
        }
    }

    private String processUserInput()
    {
        String userInput = searchField.getText();

        return userInput.replaceAll("\\s", "");
    }

    private void generateGradientBackground()
    {
        GradientPanel gradientBackground = new GradientPanel(
                new GradientGenerator(new Color(0xFFDA76), new Color(0xFF8C9E))
        );
        setContentPane(gradientBackground);
    }

    private void generateWeatherCondition(WeatherConditions condition)
    {
        String fileHandle = (condition != null) ? createWeatherImagePath(condition) : "assets/images/cloudy-sunny.png";
        String description = (condition != null) ? getWeatherConditionName(condition) : "Sunny with Clouds";
        double temperatureVal = (weatherData != null) ? (Double) weatherData.get("temperature") : 20.0;

        ImageLabelGenerator weatherImageLabelGenerator  = new ImageLabelGenerator(fileHandle, new Rectangle(0, 125, 450, 217));

        JLabel weatherImage = weatherImageLabelGenerator.createImageLabel();
        JLabel weatherDescription = WeatherCondDescriptionMaker.createDescriptionLabel(description);
        JLabel temperatureDescription = TemperatureTextGenerator.generateLabel(temperatureVal);
        JLabel locationText = LocationTextGenerator.createDescriptionLabel("abc"); //for now

        add(weatherImage);
        add(weatherDescription);
        add(temperatureDescription);
        add(locationText);
    }

    private void generateHumidityInformation()
    {
        String fileHandle = "assets/images/humidity.png";
        double currentHumidity = (weatherData != null ? (Double) weatherData.get("humidity") : 0.0);
        ImageLabelGenerator humidityImageDisplayer = new ImageLabelGenerator(fileHandle, new Rectangle(15, 500, 74, 66));

        JLabel humidityImage = humidityImageDisplayer.createImageLabel();
        JLabel humidityText = HumidityTextGenerator.generateLabel(currentHumidity);

        add(humidityImage);
        add(humidityText);
    }

    private void generateWindSpeedInformation()
    {
        String fileHandle = "assets/images/wind.png";
        double currentWindspeed = (weatherData != null ? (Double) weatherData.get("wind_speed") : 0.0);
        ImageLabelGenerator windImageDisplayer = new ImageLabelGenerator(fileHandle, new Rectangle(220, 500, 74, 66));

        JLabel windSpeedImage = windImageDisplayer.createImageLabel();
        JLabel windSpeedText = WindSpeedTextGenerator.generateLabel(currentWindspeed);

        add(windSpeedImage);
        add(windSpeedText);
    }

    private void generateLocationInformation()
    {
        JLabel locationText = LocationTextGenerator.createDescriptionLabel("abc");
        add(locationText);
    }
}

