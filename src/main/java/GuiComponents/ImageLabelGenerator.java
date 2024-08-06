package main.java.GuiComponents;

import main.java.Utility.IconLoader;

import javax.swing.*;
import java.awt.*;

public class ImageLabelGenerator {
    private ImageIcon image;
    private Rectangle bounds;

    public ImageLabelGenerator(String fileHandle, Rectangle bounds)
    {
        this.image = IconLoader.loadImageIcon(fileHandle, false);
        this.bounds = bounds;
    }

    public JLabel createImageLabel()
    {
        JLabel humidityImageLabel = new JLabel(image);
        setLabelAttributes(humidityImageLabel);
        return humidityImageLabel;
    }

    private void setLabelAttributes(JLabel humidityImageLabel)
    {
        humidityImageLabel.setBounds(bounds);
    }
}
