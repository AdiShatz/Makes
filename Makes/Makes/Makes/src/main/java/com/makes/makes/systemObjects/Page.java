package com.makes.makes.systemObjects;

import java.awt.*;

public class Page {
    String text;
    Image rightSideBackground;
    Image leftSideBackground;
    TurningPoint turningPoint = null;
    PageConfiguration configuration;

    public Page(String text, Image rightSideBackground, Image leftSideBackground, PageConfiguration pageConfiguration, TurningPoint turningPoint){
        setText(text);
        setConfiguration(pageConfiguration);
        setRightSideBackground(rightSideBackground);
        setLeftSideBackground(leftSideBackground);
        setTurningPoint(turningPoint);
    }

    public Page(String text, Image rightSideBackground, Image leftSideBackground, PageConfiguration pageConfiguration){
        setText(text);
        setConfiguration(pageConfiguration);
        setRightSideBackground(rightSideBackground);
        setLeftSideBackground(leftSideBackground);
    }

    public Image getLeftSideBackground() {
        return leftSideBackground;
    }

    public Image getRightSideBackground() {
        return rightSideBackground;
    }

    public PageConfiguration getConfiguration() {
        return configuration;
    }

    public String getText() {
        return text;
    }

    public TurningPoint getTurningPoint() {
        return turningPoint;
    }

    public void setConfiguration(PageConfiguration configuration) {
        this.configuration = configuration;
    }

    public void setLeftSideBackground(Image leftSideBackground) {
        this.leftSideBackground = leftSideBackground;
    }

    public void setRightSideBackground(Image rightSideBackground) {
        this.rightSideBackground = rightSideBackground;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTurningPoint(TurningPoint turningPoint) {
        this.turningPoint = turningPoint;
    }
}
