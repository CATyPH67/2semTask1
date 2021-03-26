package ru.vsu.cs.ivanov;

import java.awt.*;

public class Planet {
    private double planetX;
    private double planetY;
    private double speed;
    private double orbitRadius;
    private double planetDiameter;
    private Color color;

    public Planet(double planetX, double planetY, double speed, double orbitRadius, double planetDiameter, Color color) {
        this.planetX = planetX;
        this.planetY = planetY;
        this.speed = speed;
        this.orbitRadius = orbitRadius;
        this.planetDiameter = planetDiameter;
        this.color = color;
    }

    public double getPlanetX() {
        return planetX;
    }

    public double getPlanetY() {
        return planetY;
    }

    public double getPlanetDiameter() {
        return planetDiameter;
    }

    public Color getColor() {
        return color;
    }

    public void update(double starX, double starY, int time) {
        planetX = starX + orbitRadius * Math.cos(time * speed);
        planetY = starY + orbitRadius * Math.sin(time * speed);
    }
}
