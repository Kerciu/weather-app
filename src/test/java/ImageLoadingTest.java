package test.java;

import main.java.GuiComponents.WeatherConditionImageLoader;
import main.java.Utility.IconLoader;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ImageLoadingTest {
    @org.junit.Test
    @Test
    public void testLoadImageIcon() throws IOException {
        String testImagePath = "src/test/resources/testImage.png";

        ImageIcon icon = IconLoader.loadImageIcon(testImagePath);
        assertNotNull(String.valueOf(icon), "Icon should not be null");
        assertTrue("Image should be of type BufferedImage", icon.getImage() instanceof BufferedImage);

        BufferedImage bufferedImage = (BufferedImage) icon.getImage();
        assertEquals("Width should be 40px", 40, bufferedImage.getWidth());
        assertEquals("Height should be 40px", 40, bufferedImage.getHeight());

        new File(testImagePath).delete();
    }

    @org.junit.Test
    @Test
    public void testWeatherConditionImageLoader() throws  IOException {
        String testImagePath = "src/test/resources/testImage.png";
        JLabel weatherLabel = WeatherConditionImageLoader.createImageLabel(testImagePath);

        assertNotNull(String.valueOf(weatherLabel), "Weather label should not be null");
        assertEquals("Width should be 450", 450, weatherLabel.getWidth());
        assertEquals("Height should be 217", 217, weatherLabel.getHeight());
        assertEquals("X coord should be 0", 0, weatherLabel.getX());
        assertEquals("Y coord should be 125", 125, weatherLabel.getY());
    }
}
