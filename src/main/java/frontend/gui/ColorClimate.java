package main.java.frontend.gui;

import main.java.backend.model.WeatherConditions;
import main.java.frontend.utility.ColorConstants;

import java.awt.*;

public class ColorClimate {
    private WeatherConditions condition;
    private double temperature;


    public ColorClimate(WeatherConditions condition, double temperature)
    {
        this.condition = condition;
        this.temperature = temperature;
    }

    public Color[] getColorPalette() {
        return switch (condition) {
            case SUNNY -> getSunnyPalette();
            case SUNNY_CLOUDY -> getSunnyCloudyPalette();
            case CLOUDY -> getCloudyPalette();
            case FOG -> ColorConstants.FOGGY;
            case DRIZZLE -> ColorConstants.DRIZZLY;
            case RAIN -> getRainPalette();
            case SNOWY -> ColorConstants.SNOWY;
            case DOWNPOUR -> ColorConstants.DOWNPOUR;
            case SLEET -> ColorConstants.SLEET;
            case SNOWSTORM -> ColorConstants.SNOWSTORM;
            case THUNDERSTORM -> getThunderstormPalette();
            case HAIL_THUNDERSTORM -> ColorConstants.HAIL;
            default -> ColorConstants.DEFAULT_COLORS;
        };
    }

    public Color[] getButtonGradientColors() {
        return switch (condition) {
            case SUNNY -> ColorConstants.BUTTON_GRADIENT_SUNNY;
            case SUNNY_CLOUDY ->  ColorConstants.BUTTON_GRADIENT_SUNNY_CLOUDY;
            case CLOUDY ->  ColorConstants.BUTTON_GRADIENT_CLOUDY;
            case FOG ->  ColorConstants.BUTTON_GRADIENT_FOG;
            case DRIZZLE ->  ColorConstants.BUTTON_GRADIENT_DRIZZLE;
            case RAIN ->  ColorConstants.BUTTON_GRADIENT_RAIN;
            case SNOWY ->  ColorConstants.BUTTON_GRADIENT_SNOWY;
            case DOWNPOUR ->  ColorConstants.BUTTON_GRADIENT_DOWNPOUR;
            case SLEET ->  ColorConstants.BUTTON_GRADIENT_SLEET;
            case SNOWSTORM ->  ColorConstants.BUTTON_GRADIENT_SNOWSTORM;
            case THUNDERSTORM ->  ColorConstants.BUTTON_GRADIENT_THUNDERSTORM;
            case HAIL_THUNDERSTORM ->  ColorConstants.BUTTON_GRADIENT_HAIL;
            default ->  ColorConstants.BUTTON_GRADIENT_DEFAULT;
        };
    }

    private Color[] getSunnyPalette() {
        if (temperature > 35) {
            return ColorConstants.SUNNY_ABOVE_35;
        } else if (temperature > 25) {
            return ColorConstants.SUNNY_ABOVE_25_AND_BELOW_35;
        } else {
            return ColorConstants.SUNNY_BELOW_25;
        }
    }

    private Color[] getSunnyCloudyPalette() {
        if (temperature > 30) {
            return ColorConstants.SUNNY_CLOUDY_ABOVE_30;
        } else {
            return ColorConstants.SUNNY_CLOUDY_BELOW_30;
        }
    }

    private Color[] getCloudyPalette() {
        if (temperature > 25) {
            return ColorConstants.CLOUDY_ABOVE_25;
        } else {
            return ColorConstants.CLOUDY_BELOW_25;
        }
    }

    private Color[] getRainPalette() {
        if (temperature > 25) {
            return ColorConstants.RAINY_ABOVE_25;
        } else {
            return ColorConstants.RAINY_BELOW_25;
        }
    }

    private Color[] getThunderstormPalette() {
        if (temperature > 25) {
            return ColorConstants.THUNDERSTORM_ABOVE_25;
        } else {
            return ColorConstants.THUNDERSTORM_BELOW_25;
        }
    }

    public WeatherConditions getCondition() {
        return condition;
    }

    public void setCondition(WeatherConditions condition) {
        this.condition = condition;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
