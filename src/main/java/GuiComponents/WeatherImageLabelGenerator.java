package main.java.GuiComponents;

import main.java.Utility.IconLoader;

import javax.swing.*;

public class WeatherImageLabelGenerator {
    private ImageIcon weatherConditionImage;

    public WeatherImageLabelGenerator(String fileHandle)
    {
        this.weatherConditionImage = IconLoader.loadImageIcon(fileHandle, false);
    }

    public JLabel createImageLabel()
    {
        JLabel weatherImageLabel = new JLabel(weatherConditionImage);
        setLabelAttributes(weatherImageLabel);
        return weatherImageLabel;
    }

    private void setLabelAttributes(JLabel weatherImageLabel)
    {
        weatherImageLabel.setBounds(0, 125, 450, 217);
    }
}
