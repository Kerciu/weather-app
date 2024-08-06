package main.java.GUI;

import main.java.GUI.GuiComponents.*;
import main.java.GUI.TextGenerator.HumidityTextGenerator;
import main.java.GUI.TextGenerator.TemperatureTextGenerator;
import main.java.GUI.TextGenerator.WeatherCondDescriptionMaker;
import main.java.GUI.TextGenerator.WindSpeedTextGenerator;

import javax.swing.*;
import java.awt.*;

public class AppGUI extends JFrame {
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

    private void generateGuiComponents()
    {
        generateSearchFieldComponent();
        generateWeatherCondition();
        generateHumidityInformation();
        generateWindSpeedInformation();
    }

    private void generateSearchFieldComponent()
    {
        add(SearchField.createSearchField());
        add(SearchField.createSearchButton("assets/images/loupe.png"));
    }

    private void generateGradientBackground()
    {
        GradientPanel gradientBackground = new GradientPanel(
                new GradientGenerator(new Color(0xFFDA76), new Color(0xFF8C9E))
        );
        setContentPane(gradientBackground);
    }

    private void generateWeatherCondition()
    {
        // for now let it be cloudy sunny before i implement api
        String fileHandle = "assets/images/cloudy-sunny.png";
        ImageLabelGenerator weatherImageLabelGenerator  = new ImageLabelGenerator(fileHandle, new Rectangle(0, 125, 450, 217));

        JLabel weatherImage = weatherImageLabelGenerator.createImageLabel();
        JLabel temperatureText = TemperatureTextGenerator.generateLabel();
        JLabel weatherDescription = WeatherCondDescriptionMaker.createDescriptionLabel();

        add(weatherImage);
        add(temperatureText);
        add(weatherDescription);
    }

    private void generateHumidityInformation()
    {
        String fileHandle = "assets/images/humidity.png";
        ImageLabelGenerator humidityImageDisplayer = new ImageLabelGenerator(fileHandle, new Rectangle(15, 500, 74, 66));

        JLabel humidityImage = humidityImageDisplayer.createImageLabel();
        JLabel humidityText = HumidityTextGenerator.generateLabel();

        add(humidityImage);
        add(humidityText);
    }

    private void generateWindSpeedInformation()
    {
        String fileHandle = "assets/images/wind.png";
        ImageLabelGenerator windImageDisplayer = new ImageLabelGenerator(fileHandle, new Rectangle(220, 500, 74, 66));

        JLabel windSpeedImage = windImageDisplayer.createImageLabel();
        JLabel windSpeedText = WindSpeedTextGenerator.generateLabel();

        add(windSpeedImage);
        add(windSpeedText);
    }
}

