package main.java.frontend.gui;

import main.java.backend.model.WeatherConditions;
import main.java.backend.service.RetrieveAPIData;
import main.java.frontend.components.*;
import main.java.frontend.text.*;
import main.java.frontend.utility.CountryImageResolver;
import main.java.frontend.utility.WeatherStateResolver;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
    #TODO add appropriate gradient background to every weather state
    #TODO add nighttime icons, fetch time and create approriate gui
 */

public class AppGUI extends JFrame {
    private JSONObject weatherData;
    private JSONObject locationData;
    private JTextField searchField;
    private JButton searchButton;
    private ColorClimate GUIColors;

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
        if (locationData != null) generateLocationInformation();
        generateSearchButtonComponent();
    }

    private void generateSearchFieldComponent()
    {
        searchField = SearchField.createSearchField();
        add(searchField);
    }

    private void generateSearchButtonComponent()
    {
        String buttonImagePath = "assets/images/utils/loupe.png";
        Color[] colors = (GUIColors != null) ? GUIColors.getButtonGradientColors() : new Color[]{new Color(0xF8EDE3), new Color(0xDFD3C3)};

        searchButton = SearchField.createSearchButton(buttonImagePath, colors[0], colors[1]);
        searchButton.addActionListener(createButtonActionListener());
        add(searchButton);
    }

    private ActionListener createButtonActionListener()
    {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = processUserInput();
                weatherData = RetrieveAPIData.getWeatherData(userInput);
                locationData = RetrieveAPIData.getLocationAndCountry(userInput);

                if (weatherData != null && locationData != null)
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

    private String parseLocationName()
    {
        return (String) locationData.get("name");
    }

    private String parseCountryName()
    {
        return (String) locationData.get("country");
    }

    private void updateWeatherInformation(WeatherConditions cond)
    {
        getContentPane().removeAll();

        generateGradientBackground(cond);
        setLayout(null);

        generateWeatherCondition(cond);
        generateHumidityInformation();
        generateWindSpeedInformation();
        generateLocationInformation();

        add(searchField);
        generateSearchButtonComponent();

        revalidate();
        repaint();
    }

    private String createWeatherImagePath(WeatherConditions cond) {
        return WeatherStateResolver.getWeatherImagePath(cond);
    }

    private String getWeatherConditionName(WeatherConditions cond) {
        return WeatherStateResolver.getWeatherConditionName(cond);
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

    private void generateGradientBackground(WeatherConditions condition)
    {
        drawAppropriateGUIColor(condition);
        Color[] gradientColors = GUIColors.getColorPalette();

        GradientGenerator gradientGenerator = new GradientGenerator(gradientColors[0], gradientColors[1], gradientColors[2], gradientColors[3]);
        GradientPanel gradientBackground = new GradientPanel(gradientGenerator);

        setContentPane(gradientBackground);
    }

    private void drawAppropriateGUIColor(WeatherConditions condition)
    {
        // default new Color(0xFFDA76), new Color(0xFF8C9E)
            GUIColors = new ColorClimate(condition);
    }

    private void generateWeatherCondition(WeatherConditions condition)
    {
        String fileHandle = (condition != null) ? createWeatherImagePath(condition) : "assets/images/weather/cloudy-sunny.png";
        String description = (condition != null) ? getWeatherConditionName(condition) : "Sunny with Clouds";
        double temperatureVal = (weatherData != null) ? (Double) weatherData.get("temperature") : 20.0;

        ImageLabelGenerator weatherImageLabelGenerator  = new ImageLabelGenerator(fileHandle, new Rectangle(0, 125, 450, 217));

        JLabel weatherImage = weatherImageLabelGenerator.createImageLabel();
        JLabel weatherDescription = WeatherCondDescriptionMaker.createDescriptionLabel(description);
        JLabel temperatureDescription = TemperatureTextGenerator.generateLabel(temperatureVal);

        add(weatherImage);
        add(weatherDescription);
        add(temperatureDescription);
    }

    private void generateHumidityInformation()
    {
        String fileHandle = "assets/images/utils/humidity.png";
        double currentHumidity = (weatherData != null ? (Double) weatherData.get("humidity") : 0.0);
        ImageLabelGenerator humidityImageDisplayer = new ImageLabelGenerator(fileHandle, new Rectangle(15, 500, 74, 66));

        JLabel humidityImage = humidityImageDisplayer.createImageLabel();
        JLabel humidityText = HumidityTextGenerator.generateLabel(currentHumidity);

        add(humidityImage);
        add(humidityText);
    }

    private void generateWindSpeedInformation()
    {
        String fileHandle = "assets/images/utils/wind.png";
        double currentWindspeed = (weatherData != null ? (Double) weatherData.get("wind_speed") : 0.0);
        ImageLabelGenerator windImageDisplayer = new ImageLabelGenerator(fileHandle, new Rectangle(220, 500, 74, 66));

        JLabel windSpeedImage = windImageDisplayer.createImageLabel();
        JLabel windSpeedText = WindSpeedTextGenerator.generateLabel(currentWindspeed);

        add(windSpeedImage);
        add(windSpeedText);
    }

    private void generateLocationInformation()
    {
        String locationName = (locationData != null) ? parseLocationName() : "N/A";
        String countryName = (locationData != null) ? parseCountryName() : "N/A";

        String fileHandle = CountryImageResolver.getCountryImagePath(countryName);
        ImageLabelGenerator countryImageDisplayer = new ImageLabelGenerator(fileHandle, new Rectangle(0, 56, 74, 66));

        JLabel countryFlagImage = countryImageDisplayer.createImageLabel();
        JLabel locationText = LocationTextGenerator.createDescriptionLabel(locationName+ ", " + countryName);

        add(countryFlagImage);
        add(locationText);
    }
}

