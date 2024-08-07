package test.java.GuiTests;

import main.java.frontend.components.SearchField;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class SearchFieldTest {

    @Test
    public void testCreateSearchField() {
        JTextField searchField = SearchField.createSearchField();

        assertNotNull(searchField, "Search field should not be null");
        assertEquals(15, searchField.getBounds().x, "X position should be 15");
        assertEquals(15, searchField.getBounds().y, "Y position should be 15");
        assertEquals(350, searchField.getBounds().width, "Width should be 350");
        assertEquals(45, searchField.getBounds().height, "Height should be 45");
        assertEquals(new Font("Dialog", Font.PLAIN, 28), searchField.getFont(), "Font should be Dialog, plain, size 28");
    }

    @Test
    public void testCreateSearchButton() {
        String testImagePath = "src/test/resources/testImage.png";
        // Ensure the image file exists

        JButton searchButton = SearchField.createSearchButton(testImagePath);

        assertNotNull(searchButton, "Search button should not be null");
        assertEquals(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR), searchButton.getCursor(), "Cursor should be HAND_CURSOR");
        assertEquals(375, searchButton.getBounds().x, "X position should be 375");
        assertEquals(15, searchButton.getBounds().y, "Y position should be 15");
        assertEquals(47, searchButton.getBounds().width, "Width should be 47");
        assertEquals(45, searchButton.getBounds().height, "Height should be 45");
    }
}
