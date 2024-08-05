package main.java.GUI;

import main.java.GuiComponents.SearchField;

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

        generateGuiComponents();
    }

    private void generateGuiComponents()
    {
        generateSearchFieldComponent();
    }

    private void generateSearchFieldComponent()
    {
        add(SearchField.createSearchField());
        add(SearchField.createSearchButton("assets/images/loupe.png"));
    }
}
