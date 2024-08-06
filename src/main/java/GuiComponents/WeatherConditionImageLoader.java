package main.java.GuiComponents;

import main.java.Utility.IconLoader;

import javax.swing.*;

public class WeatherConditionImageLoader {

    public static JLabel createImageLabel(String fileHandle)
    {
        JLabel weatherConditionImage = new JLabel(
                IconLoader.loadImageIcon(fileHandle)
        );

        setLabelAttributes(weatherConditionImage);
        return weatherConditionImage;
    }

    private static void setLabelAttributes(JLabel weatherConditionImage)
    {
        weatherConditionImage.setBounds(0, 125, 450, 217);
    }
}
