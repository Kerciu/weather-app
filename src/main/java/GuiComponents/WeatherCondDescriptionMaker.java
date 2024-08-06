package main.java.GuiComponents;

import javax.swing.*;
import java.awt.*;

public class WeatherCondDescriptionMaker {
    public static JLabel createDescriptionLabel()
    {
        JLabel descriptionLabel = new JLabel("Cloudy-Sunny");
        setLabelAttributes(descriptionLabel);
        return descriptionLabel;
    }

    private static void setLabelAttributes(JLabel descriptionLabel)
    {
        descriptionLabel.setBounds(0, 405, 450, 36);
        descriptionLabel.setFont(new Font("Dialog", Font.PLAIN, 32));
        descriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }
}
