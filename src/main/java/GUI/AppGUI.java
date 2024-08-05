package main.java.GUI;

import javax.swing.*;
import java.awt.*;

public class AppGUI extends JFrame {
    public AppGUI()
    {
        super("Weather App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(450, 620));
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
    }
}
