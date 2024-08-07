package main.java.frontend.text;

import javax.swing.*;
import java.awt.*;

public class TemperatureTextGenerator {
    public static JLabel generateLabel()
    {
        JLabel temperatureLabel = new JLabel("30 C");
        setLabelAttributes(temperatureLabel);
        return temperatureLabel;

    }

    private static void setLabelAttributes(JLabel temperatureLabel)
    {
        temperatureLabel.setBounds(0, 350, 450, 54);
        temperatureLabel.setFont(new Font("Dialog", Font.BOLD, 48));
        temperatureLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }
}
