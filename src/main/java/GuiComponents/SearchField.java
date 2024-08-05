package main.java.GuiComponents;

import main.java.Utility.IconLoader;

import javax.swing.*;
import java.awt.*;

public class SearchField {

    public static JTextField createSearchField()
    {
        JTextField searchTextField = new JTextField();
        addSearchFieldAttributes(searchTextField);
        return searchTextField;
    }

    public static JButton createSearchButton(String imagePath)
    {
        JButton searchButton = new JButton(IconLoader.loadImageIcon(imagePath));
        addSearchButtonAttributes(searchButton);
        return searchButton;
    }

    private static void addSearchFieldAttributes(JTextField searchTextField)
    {
        searchTextField.setBounds(15, 15, 350, 45);
        searchTextField.setFont(new Font("Dialog", Font.PLAIN, 28));
    }

    private static void addSearchButtonAttributes(JButton searchButton)
    {
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchButton.setBounds(375, 15, 47, 45);
    }
}
