package test.java;

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

public class IconLoaderTest {
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
}
