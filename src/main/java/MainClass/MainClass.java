package main.java.MainClass;

import main.java.GUI.AppGUI;

import javax.swing.*;

public class MainClass {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AppGUI().setVisible(true);
            }
        });
    }
}