package main.java.GuiComponents;


import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class BorderRounder {
    public static void roundComponent(JComponent component, Graphics graphics)
    {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int componentWidth = component.getWidth();
        int componentHeight = component.getHeight();
        int arcSize = 20;

        Shape roundedRectangle = new RoundRectangle2D.Float(0, 0, componentWidth, componentHeight, arcSize, arcSize);
        graphics2D.setClip(roundedRectangle);
    }
}