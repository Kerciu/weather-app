package main.java.frontend.gui;

import main.java.backend.model.WeatherConditions;

import java.awt.*;

public class ColorClimate {
    private WeatherConditions condition;
    private Color topColor;
    private Color bottomColor;

    public ColorClimate(WeatherConditions condition)
    {
        this.condition = condition;
    }

    public Color getTopColor() {
        return topColor;
    }

    public Color getBottomColor() {
        return bottomColor;
    }

    public WeatherConditions getCondition() {
        return condition;
    }

    public void setTopColor(Color topColor) {
        this.topColor = topColor;
    }

    public void setBottomColor(Color bottomColor) {
        this.bottomColor = bottomColor;
    }

    public void setCondition(WeatherConditions condition) {
        this.condition = condition;
    }
}
