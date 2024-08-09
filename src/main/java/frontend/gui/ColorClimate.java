package main.java.frontend.gui;

import main.java.backend.model.WeatherConditions;

import java.awt.*;

public class ColorClimate {
    private WeatherConditions condition;
    private Color[] sunny = {new Color(0x36BA98ff), new Color(0xE9C46Aff), new Color(0xF4A261ff), new Color(0xE76F51ff)};
    private Color[] sunnyCloudy = {new Color(0xF3FEB8ff), new Color(0xFFDE4Dff), new Color(0xFFB22Cff), new Color(0xFF4C4Cff)};
    private Color[] cloudy = {new Color(0xFFFDB5ff), new Color(0x6FDCE3ff), new Color(0x5C88C4ff), new Color(0x5C2FC2ff)};
    private Color[] foggy = {new Color(0x538392ff), new Color(0x6295A2ff), new Color(0x80B9ADff), new Color(0xB3E2A7ff)};
    private Color[] drizzly = {new Color(0x5A639Cff), new Color(0x7776B3ff), new Color(0x9B86BDff), new Color(0xE2BBE9)};
    private Color[] rainy = {new Color(0x615EFCff), new Color(0x7E8EF1ff), new Color(0xD1D8C5ff), new Color(0xEEEEEEff)};
    private Color[] snowy = {new Color(0x6482ADff), new Color(0x7FA1C3ff), new Color(0xE2DAD6ff), new Color(0xF5EDEDff)};
    private Color[] downpour = {new Color(0x190482ff), new Color(0x7752FEff), new Color(0x8E8FFA), new Color(0xC2D9FFff)};
    private Color[] sleet = {new Color(0xEEF5FFff), new Color(0xB4D4FFff), new Color(0x86B6F6ff), new Color(0x176B87ff)};
    private Color[] snowstorm = {new Color(0xECF2FFff), new Color(0x3E54ACff), new Color(0x655DBBff), new Color(0xBFACE2ff)};
    private Color[] thunderstorm = {new Color(0xFF204Eff), new Color(0xA0153Eff), new Color(0x5D0E41ff), new Color(0x00224Dff)};
    private Color[] hail = {new Color(0x3F0071ff), new Color(0xFB2576ff), new Color(0x332FD0ff), new Color(0xC4E4FFff)};

    /*
    public enum WeatherConditions {
        SUNNY, SUNNY_CLOUDY, CLOUDY, FOG, DRIZZLE,
        RAIN, SNOWY, DOWNPOUR, SLEET,
        SNOWSTORM, THUNDERSTORM, HAIL_THUNDERSTORM,
        UNIDENTIFIED
    } */

    public ColorClimate(WeatherConditions condition)
    {
        this.condition = condition;
    }

    public WeatherConditions getCondition() {
        return condition;
    }

    public void setCondition(WeatherConditions condition) {
        this.condition = condition;
    }


}
