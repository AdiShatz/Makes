package com.makes.makes.systemObjects;

import java.awt.*;

public class PageConfiguration {
    Location textLocation;
    Location turningPointLocation;
    Color textColor = new Color(000000);

    public PageConfiguration(Location textLocation, Location turningPointLocation, int rgbColor){
        setTextLocation(textLocation);
        setTurningPointLocation(turningPointLocation);
        setTextColor(rgbColor);
    }

    public PageConfiguration(Location textLocation, Location turningPointLocation){
        setTextLocation(textLocation);
        setTurningPointLocation(turningPointLocation);
    }

    public void setTextLocation(Location textLocation) {
        this.textLocation = textLocation;
    }

    public void setTurningPointLocation(Location turningPointLocation) {
        this.turningPointLocation = turningPointLocation;
    }

    public Color getTextColor() {
        return textColor;
    }

    public Location getTextLocation() {
        return textLocation;
    }

    public Location getTurningPointLocation() {
        return turningPointLocation;
    }

    public void setTextColor(int rgbColor) {
        this.textColor = new Color(rgbColor);
    }


}
