package main.java.frontend.gui;

import main.java.backend.model.WeatherConditions;

import java.awt.*;

public class ColorClimate {
    private WeatherConditions condition;

    // background colors
    private static final Color[] SUNNY = {new Color(0xFFD700), new Color(0xFF8C00), new Color(0xFF4500), new Color(0xFF6347)};
    private static final Color[] SUNNY_CLOUDY = {new Color(0xFCE205), new Color(0xFFB22C), new Color(0xFFA07A), new Color(0xF0E68C)};
    private static final Color[] CLOUDY = {new Color(0xB0C4DE), new Color(0x4682B4), new Color(0x4169E1), new Color(0x1E90FF)};
    private static final Color[] FOGGY = {new Color(0xD3D3D3), new Color(0xB0B0B0), new Color(0xC0C0C0), new Color(0xF0F8FF)};
    private static final Color[] DRIZZLY = {new Color(0x7B68EE), new Color(0xB0E0E6), new Color(0xD8BFD8), new Color(0xE6E6FA)};
    private static final Color[] RAINY = {new Color(0x4682B4), new Color(0x87CEFA), new Color(0xB0C4DE), new Color(0xADD8E6)};
    private static final Color[] SNOWY = {new Color(0xE0FFFF), new Color(0xB0C4DE), new Color(0xDCDCDC), new Color(0xF8F8FF)};
    private static final Color[] DOWNPOUR = {new Color(0x00008B), new Color(0x4B0082), new Color(0x6A5ACD), new Color(0x8A2BE2)};
    private static final Color[] SLEET = {new Color(0xF0F8FF), new Color(0xB0E0E6), new Color(0xADD8E6), new Color(0x4682B4)};
    private static final Color[] SNOWSTORM = {new Color(0xF0F8FF), new Color(0x1E90FF), new Color(0x6A5ACD), new Color(0xB0C4DE)};
    private static final Color[] THUNDERSTORM = {new Color(0xFF4500), new Color(0xB22222), new Color(0x4B0082), new Color(0x00008B)};
    private static final Color[] HAIL = {new Color(0x4B0082), new Color(0x8A2BE2), new Color(0x6A5ACD), new Color(0xD3D3D3)};
    private static final Color[] DEFAULT_COLORS = {new Color(0xEF5A6F), new Color(0xFFF1DB), new Color(0xD4BDAC), new Color(0x536493)};

    // button colors
    private static final Color[] BUTTON_GRADIENT_SUNNY = {new Color(0xFCE205), new Color(0xFF8C00)};
    private static final Color[] BUTTON_GRADIENT_SUNNY_CLOUDY = {new Color(0xF3FEB8), new Color(0xFFB22C)};
    private static final Color[] BUTTON_GRADIENT_CLOUDY = {new Color(0xB0C4DE), new Color(0x4682B4)};
    private static final Color[] BUTTON_GRADIENT_FOG = {new Color(0xC0C0C0), new Color(0xD3D3D3)};
    private static final Color[] BUTTON_GRADIENT_DRIZZLE = {new Color(0x7B68EE), new Color(0xD8BFD8)};
    private static final Color[] BUTTON_GRADIENT_RAIN = {new Color(0x4682B4), new Color(0x87CEFA)};
    private static final Color[] BUTTON_GRADIENT_SNOWY = {new Color(0xE0FFFF), new Color(0xB0C4DE)};
    private static final Color[] BUTTON_GRADIENT_DOWNPOUR = {new Color(0x00008B), new Color(0x8A2BE2)};
    private static final Color[] BUTTON_GRADIENT_SLEET = {new Color(0xF0F8FF), new Color(0xADD8E6)};
    private static final Color[] BUTTON_GRADIENT_SNOWSTORM = {new Color(0xF0F8FF), new Color(0x1E90FF)};
    private static final Color[] BUTTON_GRADIENT_THUNDERSTORM = {new Color(0xFF4500), new Color(0xB22222)};
    private static final Color[] BUTTON_GRADIENT_HAIL = {new Color(0x4B0082), new Color(0xFF69B4)};
    private static final Color[] BUTTON_GRADIENT_DEFAULT = {new Color(0xEF5A6F), new Color(0xFFF1DB)};

    public ColorClimate(WeatherConditions condition)
    {
        this.condition = condition;
    }

    public Color[] getColorPalette() {
        return switch (condition) {
            case SUNNY -> SUNNY;
            case SUNNY_CLOUDY -> SUNNY_CLOUDY;
            case CLOUDY -> CLOUDY;
            case FOG -> FOGGY;
            case DRIZZLE -> DRIZZLY;
            case RAIN -> RAINY;
            case SNOWY -> SNOWY;
            case DOWNPOUR -> DOWNPOUR;
            case SLEET -> SLEET;
            case SNOWSTORM -> SNOWSTORM;
            case THUNDERSTORM -> THUNDERSTORM;
            case HAIL_THUNDERSTORM -> HAIL;
            default -> DEFAULT_COLORS;
        };
    }

    public Color[] getButtonGradientColors() {
        return switch (condition) {
            case SUNNY -> BUTTON_GRADIENT_SUNNY;
            case SUNNY_CLOUDY -> BUTTON_GRADIENT_SUNNY_CLOUDY;
            case CLOUDY -> BUTTON_GRADIENT_CLOUDY;
            case FOG -> BUTTON_GRADIENT_FOG;
            case DRIZZLE -> BUTTON_GRADIENT_DRIZZLE;
            case RAIN -> BUTTON_GRADIENT_RAIN;
            case SNOWY -> BUTTON_GRADIENT_SNOWY;
            case DOWNPOUR -> BUTTON_GRADIENT_DOWNPOUR;
            case SLEET -> BUTTON_GRADIENT_SLEET;
            case SNOWSTORM -> BUTTON_GRADIENT_SNOWSTORM;
            case THUNDERSTORM -> BUTTON_GRADIENT_THUNDERSTORM;
            case HAIL_THUNDERSTORM -> BUTTON_GRADIENT_HAIL;
            default -> BUTTON_GRADIENT_DEFAULT;
        };
    }

    public WeatherConditions getCondition() {
        return condition;
    }

    public void setCondition(WeatherConditions condition) {
        this.condition = condition;
    }


}
