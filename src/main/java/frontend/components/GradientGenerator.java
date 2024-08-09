package main.java.frontend.components;

import javax.swing.*;
import java.awt.*;

public class GradientGenerator {
    private Color colorOne;
    private Color colorTwo;
    private Color colorThree;
    private Color colorFour;

    public GradientGenerator(Color topColor, Color bottomColor) {
        this.colorOne = topColor;
        this.colorTwo = bottomColor;
    }

    public GradientGenerator(Color topColor, Color middleColor, Color bottomColor) {
        this.colorOne = topColor;
        this.colorTwo = middleColor;
        this.colorThree = bottomColor;
    }

    public GradientGenerator(Color topColor, Color middleTopColor, Color middleBottomColor, Color bottomColor) {
        this.colorOne = topColor;
        this.colorTwo = middleTopColor;
        this.colorThree = middleBottomColor;
        this.colorFour = bottomColor;
    }

    public void paintComponent(JComponent component, Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;

        int panelWidth = component.getWidth();
        int panelHeight = component.getHeight();

        if (colorThree == null) {
            graphics2D.setPaint(createGradientPaint(panelHeight));
        } else {
            graphics2D.setPaint(createLinearGradientPaint(panelHeight));
        }
        graphics2D.fillRect(0, 0, panelWidth, panelHeight);
    }

    private GradientPaint createGradientPaint(int panelHeight)
    {
        return new GradientPaint(0, 0, colorOne, 0, panelHeight, colorTwo);
    }

    private LinearGradientPaint createLinearGradientPaint(int panelHeight)
    {
        float[] fractions;
        Color[] colors;

        if (colorFour == null)
        {
            fractions = new float[]{0.0f, 0.5f, 1.0f};
            colors = new Color[]{colorOne, colorTwo, colorThree};
        }
        else
        {
            fractions = new float[]{ 0.0f, 0.33f, 0.66f, 1.0f };
            colors = new Color[] { colorOne, colorTwo, colorThree, colorFour };
        }

        return new LinearGradientPaint(0, 0, 0, panelHeight, fractions, colors);
    }
}
