package main.java.GUI;

import main.java.GuiComponents.GradientGenerator;
import main.java.GuiComponents.GradientPanel;
import main.java.GuiComponents.SearchField;
import main.java.GuiComponents.WeatherConditionImageLoader;

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

    private void generateWeatherConditionImage()
    {
        String fileHandle = "assets/image/loupe.png"
        JLabel weatherCond = WeatherConditionImageLoader.createImageLabel(fileHandle);
    }
}

