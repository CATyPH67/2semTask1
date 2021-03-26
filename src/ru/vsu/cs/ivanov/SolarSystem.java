package ru.vsu.cs.ivanov;

import java.util.ArrayList;

public class SolarSystem {
    private double starX;
    private double starY;
    private ArrayList<Planet> planets = new ArrayList<>();

    public SolarSystem(double centreX, double centreY) {
        this.starX = centreX;
        this.starY = centreY;
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
