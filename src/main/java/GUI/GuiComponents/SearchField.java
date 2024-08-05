package main.java.GUI.GuiComponents;

import main.java.GUI.Utility.IconLoader;

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

    }
}
