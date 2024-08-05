package main.java.GUI.GuiComponents;

import javax.swing.*;
import java.awt.*;

public class SearchField {

    public static JTextField createSearchField()
    {
        JTextField searchTextField = new JTextField();
        addSearchFieldAttributes(searchTextField);
        return searchTextField;
    }

    private static void addSearchFieldAttributes(JTextField searchTextField)
    {
        searchTextField.setBounds(15, 15, 350, 45);
        searchTextField.setFont(new Font("Dialog", Font.PLAIN, 28));
    }
}
