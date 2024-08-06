package main.java.GUI.TextGenerator;

import javax.swing.*;
import java.awt.*;

public class WindSpeedTextGenerator {
    public static JLabel generateLabel()
    {
        JLabel temperatureLabel = new JLabel("<html><b>Windspeed</b> 20km/h</html>");
        setLabelAttributes(temperatureLabel);
        return temperatureLabel;

    }

    private static void setLabelAttributes(JLabel temperatureLabel)
    {
        temperatureLabel.setBounds(310, 500, 88, 55);
        temperatureLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
    }
}
