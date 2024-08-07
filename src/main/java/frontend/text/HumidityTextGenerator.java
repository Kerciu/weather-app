package main.java.frontend.text;

import javax.swing.*;
import java.awt.*;

public class HumidityTextGenerator {
    public static JLabel generateLabel()
    {
        JLabel humidityLabel = new JLabel(
                "<html><b>Humidity</b> 100%</html>"
        );
        setLabelAttributes(humidityLabel);
        return humidityLabel;

    }

    private static void setLabelAttributes(JLabel humidityLabel)
    {
        humidityLabel.setBounds(90, 500, 85, 55);
        humidityLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
    }
}
