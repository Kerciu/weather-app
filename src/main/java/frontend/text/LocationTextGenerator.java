package main.java.frontend.text;

import javax.swing.*;
import java.awt.*;

public class LocationTextGenerator {
    public static JLabel createDescriptionLabel(String description)
    {
        JLabel locationLabel = new JLabel(description);
        setLabelAttributes(locationLabel);
        return locationLabel;
    }

    private static void setLabelAttributes(JLabel locationLabel)
    {
        locationLabel.setBounds(65, 67, 400, 45);
        locationLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
        locationLabel.setHorizontalAlignment(SwingConstants.LEFT);
    }
}
