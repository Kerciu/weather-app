package main.java.frontend.components;

import main.java.frontend.utility.IconLoader;

import javax.swing.*;
import java.awt.*;

public class SearchField {

    public static JTextField createSearchField()
    {
        JTextField searchTextField = new GradientTextField(
                new GradientGenerator(new Color(0xF8EDE3), new Color(0xDFD3C3))
        );
        addSearchFieldAttributes(searchTextField);

        return searchTextField;
    }

    public static JButton createSearchButton(String imagePath, Color topColor, Color bottomColor)
    {
        JButton searchButton = new GradientButton(
                new GradientGenerator(topColor, bottomColor),
                IconLoader.loadImageIcon(imagePath, true)
        );
        addSearchButtonAttributes(searchButton);

        return searchButton;
    }

    private static void addSearchFieldAttributes(JTextField searchTextField)
    {
        searchTextField.setBounds(15, 15, 350, 45);
        searchTextField.setFont(new Font("Dialog", Font.PLAIN, 28));
        searchTextField.setForeground(Color.BLACK);
    }

    private static void addSearchButtonAttributes(JButton searchButton)
    {
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchButton.setBounds(375, 15, 47, 45);
    }

}