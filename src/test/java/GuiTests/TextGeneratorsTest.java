package test.java.GuiTests;

import main.java.frontend.text.*;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TextGeneratorsTest {
    @org.junit.Test
    @Test
    public void testWeatherCondDescription()
    {
        JLabel label = WeatherCondDescriptionMaker.createDescriptionLabel("Sunny");

        Rectangle bounds = label.getBounds();

        assertNotNull(label, "Label should not be null");
        assertEquals(0, bounds.x, "X should be 0");
        assertEquals(405, bounds.y, "Y should be 405");
        assertEquals(450, bounds.width, "Width should be 450");
        assertEquals(36, bounds.height, "Height should be 36");

        assertEquals("Dialog", label.getFont().getName());
        assertEquals(Font.PLAIN, label.getFont().getStyle());
        assertEquals(32, label.getFont().getSize());

        assertEquals(SwingConstants.CENTER, label.getHorizontalAlignment());
    }

    @org.junit.Test
    @Test
    public void testTemperatureText()
    {
        JLabel label = TemperatureTextGenerator.generateLabel(20.5);

        Rectangle bounds = label.getBounds();
        assertNotNull(label, "Label should not be null");
        assertEquals(0, bounds.x, "X should be 0");
        assertEquals(350, bounds.y, "Y should be 350");
        assertEquals(450, bounds.width, "Width should be 450");
        assertEquals(54, bounds.height, "Height should be 54");

        assertEquals("Dialog", label.getFont().getName());
        assertEquals(Font.BOLD, label.getFont().getStyle());
        assertEquals(48, label.getFont().getSize());

        assertEquals(SwingConstants.CENTER, label.getHorizontalAlignment());
    }

    @org.junit.Test
    @Test
    public void testHumidityText()
    {
        JLabel label = HumidityTextGenerator.generateLabel(50.0);

        Rectangle bounds = label.getBounds();

        String humiditySubString = "<html><b>Humidity</b> ";
        assertEquals(label.getText().substring(0, humiditySubString.length()), humiditySubString);

        assertNotNull(label, "Label should not be null");
        assertEquals(90, bounds.x, "X should be 90");
        assertEquals(500, bounds.y, "Y should be 500");
        assertEquals(85, bounds.width, "Width should be 85");
        assertEquals(55, bounds.height, "Height should be 55");

        assertEquals("Dialog", label.getFont().getName());
        assertEquals(Font.PLAIN, label.getFont().getStyle());
        assertEquals(16, label.getFont().getSize());
    }

    @org.junit.Test
    @Test
    public void testWindspeedText()
    {
        JLabel label = WindSpeedTextGenerator.generateLabel(20.0);

        Rectangle bounds = label.getBounds();

        String humiditySubString = "<html><b>Windspeed</b> ";
        assertEquals(label.getText().substring(0, humiditySubString.length()), humiditySubString);

        assertNotNull(label, "Label should not be null");
        assertEquals(310, bounds.x, "X should be 310");
        assertEquals(500, bounds.y, "Y should be 500");
        assertEquals(88, bounds.width, "Width should be 88");
        assertEquals(55, bounds.height, "Height should be 55");

        assertEquals("Dialog", label.getFont().getName());
        assertEquals(Font.PLAIN, label.getFont().getStyle());
        assertEquals(16, label.getFont().getSize());
    }

    @org.junit.Test
    @Test
    public void testLocationText()
    {
        String longFranceDesc = "Nice, Alpes-Maritimes département, Provence–Alpes–Côte-d'Azur région, southeastern France";
        JLabel labelDefault = LocationTextGenerator.createDescriptionLabel("Donetsk, Ukraine");
        JLabel labelWrapped = LocationTextGenerator.createDescriptionLabel(longFranceDesc);

        assertTrue(labelWrapped.getText().contains("<br>"));
        assertFalse(labelDefault.getText().contains("<br>"));
        assertNotNull(labelDefault);
        assertNotNull(labelWrapped);

        assertEquals(65, labelDefault.getX());
        assertEquals(67, labelDefault.getY());
        assertEquals(400, labelDefault.getWidth());
        assertEquals(45, calculateLabelHeight(labelDefault.getText()));

        assertEquals(65, labelWrapped.getX());
        assertEquals(58, labelWrapped.getY());
        assertEquals(400, labelWrapped.getWidth());
        assertEquals(65, calculateLabelHeight(labelWrapped.getText()));

    }

    private static int calculateLabelHeight(String description) {
        int lines = description.split("<br>").length;
        return 45 + (lines - 1) * 20;
    }
}
