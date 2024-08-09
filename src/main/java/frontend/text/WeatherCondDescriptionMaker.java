package main.java.frontend.text;

import javax.swing.*;
import java.awt.*;

public class WeatherCondDescriptionMaker {
    public static JLabel createDescriptionLabel(String description)
    {
        JLabel descriptionLabel = new JLabel(description);
        setLabelAttributes(descriptionLabel);
        return descriptionLabel;
    }

    private static void setLabelAttributes(JLabel descriptionLabel)
    {
        descriptionLabel.setBounds(0, 405, 450, 46);
        descriptionLabel.setFont(new Font("Dialog", Font.PLAIN, 32));
        descriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }
}
