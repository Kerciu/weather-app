package test.java.GuiTests;

import main.java.frontend.components.*;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GradientElementsTest {
    @Test
    public void testGradientButton() {
        GradientGenerator generator = new GradientGenerator(Color.RED, Color.BLUE);
        ImageIcon icon = new ImageIcon(new BufferedImage(40, 40, BufferedImage.TYPE_INT_ARGB));
        GradientButton button = new GradientButton(generator, icon);

        assertNotNull(String.valueOf(button), "GradientButton should not be null");
        assertEquals("GradientGenerator should match", generator, button.getGradientGenerator());
        assertEquals("Icon should match", icon, button.getIcon());
    }

    @Test
    public void testGradientTextField() {
        GradientGenerator generator = new GradientGenerator(Color.RED, Color.BLUE);
        GradientTextField textField = new GradientTextField(generator);

        assertNotNull(String.valueOf(textField), "GradientTextField should not be null");
        assertEquals("Width should be 0", 0, textField.getWidth());
        assertEquals("Height should be 0", 0, textField.getHeight());
        assertEquals("GradientGenerator should match", generator, textField.getGradientGenerator());
    }

}
