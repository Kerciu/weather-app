package main.java.GuiComponents;

import main.java.Utility.IconLoader;

import javax.swing.*;

public class HumidityImageDisplayer {
    private ImageIcon humidityImage;

    public HumidityImageDisplayer(String fileHandle)
    {
        this.humidityImage = IconLoader.loadImageIcon(fileHandle, false);
    }

    public JLabel createImageLabel()
    {
        JLabel humidityImageLabel = new JLabel(humidityImage);
        setLabelAttributes(humidityImageLabel);
        return humidityImageLabel;
    }

    private void setLabelAttributes(JLabel humidityImageLabel)
    {
        humidityImageLabel.setBounds(15, 500, 74, 66);
    }
}
