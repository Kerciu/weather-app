package test.java.GuiTests;

import main.java.frontend.components.ImageLabelGenerator;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ImageLabelGeneratorTest {
    @org.junit.Test
    @Test
    public void testImageLabelGeneratorCreation() throws IOException
    {
        String fileHandle = "src/test/resources/testImage.png";
        Rectangle rectangle = new Rectangle(250, 300, 150, 220);
        ImageLabelGenerator imageLabelGenerator = new ImageLabelGenerator(
            fileHandle, rectangle
        );

        assertNotNull(imageLabelGenerator, "Image Label Generator should not be null");
        assertNotNull(imageLabelGenerator.getImage(), "Image should not be null");
        assertEquals(250, imageLabelGenerator.getBounds().x, "X position should be 250");
        assertEquals(300, imageLabelGenerator.getBounds().y, "Y position should be 300");
        assertEquals(150, imageLabelGenerator.getBounds().width, "Width position should be 150");
        assertEquals(220, imageLabelGenerator.getBounds().height, "Height position should be 220");
        assertEquals(imageLabelGenerator.getBounds(), rectangle, "Rectangle and bounds should be the same");
    }
}
