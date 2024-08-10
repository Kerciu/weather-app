package main.java.frontend.utility;

import java.awt.*;

public class ColorConstants {
    // background colors
    public static final Color[] SUNNY_ABOVE_35 = {
            new Color(0xFFD700),
            new Color(0xFF8C00),
            new Color(0xFFFF6565, true),
            new Color(0xFF6347)};

    public static final Color[] SUNNY_ABOVE_25_AND_BELOW_35 = {
            new Color(0xFEFFD2),
            new Color(0xFFEEA9),
            new Color(0xFFBF78),
            new Color(0xFF7D29)};

    public static final Color[] SUNNY_BELOW_25 = {
            new Color(0xFFA62F),
            new Color(0xFFC96F),
            new Color(0xFFE8C8),
            new Color(0xACD793)};

    public static final Color[] SUNNY_CLOUDY_ABOVE_30 = {
            new Color(0xFCE205),
            new Color(0xFFB22C),
            new Color(0xFFA07A),
            new Color(0xF0E68C)};

    public static final Color[] SUNNY_CLOUDY_BELOW_30 = {
            new Color(0x03AED2),
            new Color(0x68D2E8),
            new Color(0xFDDE55),
            new Color(0xFEEFAD)};

    public static final Color[] CLOUDY_ABOVE_25 = {
            new Color(0x008DDA),
            new Color(0x41C9E2),
            new Color(0xACE2E1),
            new Color(0xF7EEDD)};

    public static final Color[] CLOUDY_BELOW_25 = {
            new Color(0xB0C4DE),
            new Color(0x4682B4),
            new Color(0x4169E1),
            new Color(0x1E90FF)};

    public static final Color[] FOGGY = {
            new Color(0xB3C8CF),
            new Color(0xBED7DC),
            new Color(0xF1EEDC),
            new Color(0xE5DDC5)};

    public static final Color[] DRIZZLY = {
            new Color(0x7B68EE),
            new Color(0xB0E0E6),
            new Color(0xD8BFD8),
            new Color(0xE6E6FA)};

    public static final Color[] RAINY_ABOVE_25 = {
            new Color(0xD1E9F6),
            new Color(0xF6EACB),
            new Color(0xF1D3CE),
            new Color(0xEECAD5)};

    public static final Color[] RAINY_BELOW_25 = {
            new Color(0x4682B4),
            new Color(0x87CEFA),
            new Color(0xB0C4DE),
            new Color(0xADD8E6)};

    public static final Color[] SNOWY = {
            new Color(0xE0FFFF),
            new Color(0xB0C4DE),
            new Color(0xDCDCDC),
            new Color(0xF8F8FF)};

    public static final Color[] DOWNPOUR = {
            new Color(0x402E7A),
            new Color(0x4C3BCF),
            new Color(0x4B70F5),
            new Color(0x3DC2EC)};

    public static final Color[] SLEET = {
            new Color(0xF0F8FF),
            new Color(0xB0E0E6),
            new Color(0xADD8E6),
            new Color(0x4682B4)};

    public static final Color[] SNOWSTORM = {
            new Color(0xF0F8FF),
            new Color(0x1E90FF),
            new Color(0x6A5ACD),
            new Color(0xB0C4DE)};

    public static final Color[] THUNDERSTORM_ABOVE_25 = {
            new Color(0xFF4500),
            new Color(0xB22222),
            new Color(0x4B0082),
            new Color(0x00008B)};

    public static final Color[] THUNDERSTORM_BELOW_25 = {
            new Color(0x332941),
            new Color(0x3B3486),
            new Color(0x864AF9),
            new Color(0xF8E559)};

    public static final Color[] HAIL = {
            new Color(0x4B0082),
            new Color(0x8A2BE2),
            new Color(0x6A5ACD),
            new Color(0xD3D3D3)};

    public static final Color[] DEFAULT_COLORS = {
            new Color(0xEF5A6F),
            new Color(0xFFF1DB),
            new Color(0xD4BDAC),
            new Color(0x536493)};

    // button colors
    public static final Color[] BUTTON_GRADIENT_SUNNY = {new Color(0xFCE205), new Color(0xFF8C00)};
    public static final Color[] BUTTON_GRADIENT_SUNNY_CLOUDY = {new Color(0xF3FEB8), new Color(0xFFB22C)};
    public static final Color[] BUTTON_GRADIENT_CLOUDY = {new Color(0xB0C4DE), new Color(0x4682B4)};
    public static final Color[] BUTTON_GRADIENT_FOG = {new Color(0xC0C0C0), new Color(0xD3D3D3)};
    public static final Color[] BUTTON_GRADIENT_DRIZZLE = {new Color(0x7B68EE), new Color(0xD8BFD8)};
    public static final Color[] BUTTON_GRADIENT_RAIN = {new Color(0x4682B4), new Color(0x87CEFA)};
    public static final Color[] BUTTON_GRADIENT_SNOWY = {new Color(0xE0FFFF), new Color(0xB0C4DE)};
    public static final Color[] BUTTON_GRADIENT_DOWNPOUR = {new Color(0x00008B), new Color(0x8A2BE2)};
    public static final Color[] BUTTON_GRADIENT_SLEET = {new Color(0xF0F8FF), new Color(0xADD8E6)};
    public static final Color[] BUTTON_GRADIENT_SNOWSTORM = {new Color(0xF0F8FF), new Color(0x1E90FF)};
    public static final Color[] BUTTON_GRADIENT_THUNDERSTORM = {new Color(0xFF4500), new Color(0xB22222)};
    public static final Color[] BUTTON_GRADIENT_HAIL = {new Color(0x4B0082), new Color(0xFF69B4)};
    public static final Color[] BUTTON_GRADIENT_DEFAULT = {new Color(0xEF5A6F), new Color(0xFFF1DB)};
}
