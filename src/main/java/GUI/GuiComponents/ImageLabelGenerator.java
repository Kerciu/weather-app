package main.java.GUI.GuiComponents;

import main.java.GUI.Utility.IconLoader;

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

    public Rectangle getBounds() {
        return bounds;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
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
