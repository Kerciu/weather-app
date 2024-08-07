package main.java.frontend.components;

import javax.swing.*;
import java.awt.*;

public class GradientPanel extends JPanel {
    private GradientGenerator gradientGenerator;

    public GradientPanel(GradientGenerator gradientGenerator)
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
