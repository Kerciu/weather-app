package main.java.GuiComponents;

import javax.swing.*;
import java.awt.*;

public class GradientPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics graphics)
    {
        Graphics2D graphics2D = (Graphics2D) graphics;

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        GradientPaint gradientPaint = createGradientPaint(panelHeight);
        graphics2D.setPaint(gradientPaint);
        graphics2D.fillRect(0, 0, panelWidth, panelHeight);
    }

    private GradientPaint createGradientPaint(int panelHeight)
    {
        Color topColor = new Color(0xFFDA76);
        Color bottomColor = new Color(0xFF8C9E);

        return new GradientPaint(0, 0, topColor, 0, panelHeight, bottomColor);
    }
}
