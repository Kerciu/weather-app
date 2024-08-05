package main.java.GuiComponents;

import javax.swing.*;
import java.awt.*;

public class GradientTextField extends JTextField {
    private GradientGenerator gradientGenerator;

    public GradientTextField(GradientGenerator gradientGenerator)
    {
        this.gradientGenerator = gradientGenerator;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        gradientGenerator.paintComponent(this, g);
        super.paintComponent(g);
    }
}
