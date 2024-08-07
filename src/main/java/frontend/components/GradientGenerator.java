package main.java.frontend.components;

import javax.swing.*;
import java.awt.*;

public class GradientGenerator {
    private Color topColor;
    private Color bottomColor;

    public GradientGenerator(Color topColor, Color bottomColor) {
        this.topColor = topColor;
        this.bottomColor = bottomColor;
    }

    public Color getTopColor() {
        return topColor;
    }

    public Color getBottomColor() {
        return bottomColor;
    }

    public void setTopColor(Color topColor) {
        this.topColor = topColor;
    }

    public void setBottomColor(Color bottomColor) {
        this.bottomColor = bottomColor;
    }

    public void paintComponent(JComponent component, Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;

        int panelWidth = component.getWidth();
        int panelHeight = component.getHeight();

        GradientPaint gradientPaint = new GradientPaint(0, 0, topColor, 0, panelHeight, bottomColor);
        graphics2D.setPaint(gradientPaint);
        graphics2D.fillRect(0, 0, panelWidth, panelHeight);
    }
}
