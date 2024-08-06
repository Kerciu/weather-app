package main.java.GuiComponents;

import javax.swing.*;
import java.awt.*;

public class GradientTextField extends JTextField {
    private GradientGenerator gradientGenerator;

    public GradientTextField(GradientGenerator gradientGenerator)
    {
        this.gradientGenerator = gradientGenerator;
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder());
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        BorderRounder.roundComponent(this, g);
        gradientGenerator.paintComponent(this, g);
        super.paintComponent(g);
    }

    public Object getGradientGenerator() {
        return gradientGenerator;
    }
}
