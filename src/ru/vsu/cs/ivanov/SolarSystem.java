package ru.vsu.cs.ivanov;

import java.awt.*;
import java.util.ArrayList;

public class SolarSystem {
    private double starX;
    private double starY;
    private ArrayList<Planet> planets = new ArrayList<>();

    public SolarSystem(double centreX, double centreY) {
        this.starX = centreX;
        this.starY = centreY;
    }

    public void setSolarSystem() {
        addPlanet(new Planet(getStarX(), getStarY(),
                0, 0, 85, Color.ORANGE)); //sun

        addPlanet(new Planet(getStarX() + 60, getStarY(),
                0.0048, 60, 8, Color.GRAY)); //Mercury
        addPlanet(new Planet(getStarX() + 75, getStarY(),
                0.0035, 75, 12, new Color(207,153,52))); //Venus
        addPlanet(new Planet(getStarX() + 95, getStarY(),
                0.003, 95, 12, Color.BLUE)); //Earth
        addPlanet(new Planet(getStarX() + 116, getStarY(),
                0.0024, 116, 7, Color.RED)); //Mars
        addPlanet(new Planet(getStarX() + 260, getStarY(),
                0.0013, 260, 20, new Color(255,140,0))); //Jupiter
        addPlanet(new Planet(getStarX() + 350, getStarY(),
                0.001, 350, 18, new Color(112,128,144))); //Saturn
        addPlanet(new Planet(getStarX() + 390, getStarY(),
                0.0007, 390, 15, new Color(196,233,238))); //Uranus
        addPlanet(new Planet(getStarX() + 450, getStarY(),
                0.0005, 450, 15, new Color(66, 98, 243))); //Neptune
    }

    public double getStarX() {
        return starX;
    }

    public double getStarY() {
        return starY;
    }

    public void addPlanet(Planet newPlanet) {
        planets.add(newPlanet);
    }

    public Planet getPlanet(int index) {
        return planets.get(index);
    }

    public int getNumberOfPlanets() {
        return planets.size();
    }

    public void update(int time) {
        time += Animation.DELAY;
        for (Planet planet : planets) {
            planet.update(starX, starY, time);
        }
    }
}
