package ru.vsu.cs.ivanov;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Animation extends JComponent implements ActionListener {
    public static final int DELAY = 1;
    private int time = 0;
    private SolarSystem solarSystem = new SolarSystem(500, 500);
    private Timer timer = new Timer(DELAY, this);

    public Animation() {
        setSolarSystem();
        setPreferredSize(new Dimension(1000, 1000));
    }

    private void setSolarSystem() {
        solarSystem.addPlanet(new Planet(solarSystem.getStarX(), solarSystem.getStarY(),
                                    0, 0, 85, Color.ORANGE)); //sun

        solarSystem.addPlanet(new Planet(solarSystem.getStarX() + 60, solarSystem.getStarY(),
                                    0.0048, 60, 8, Color.GRAY)); //Mercury
        solarSystem.addPlanet(new Planet(solarSystem.getStarX() + 75, solarSystem.getStarY(),
                                    0.0035, 75, 12, new Color(207,153,52))); //Venus
        solarSystem.addPlanet(new Planet(solarSystem.getStarX() + 95, solarSystem.getStarY(),
                                    0.003, 95, 12, Color.BLUE)); //Earth
        solarSystem.addPlanet(new Planet(solarSystem.getStarX() + 116, solarSystem.getStarY(),
                                    0.0024, 116, 7, Color.RED)); //Mars
        solarSystem.addPlanet(new Planet(solarSystem.getStarX() + 260, solarSystem.getStarY(),
                                    0.0013, 260, 20, new Color(255,140,0))); //Jupiter
        solarSystem.addPlanet(new Planet(solarSystem.getStarX() + 350, solarSystem.getStarY(),
                                    0.001, 350, 18, new Color(112,128,144))); //Saturn
        solarSystem.addPlanet(new Planet(solarSystem.getStarX() + 390, solarSystem.getStarY(),
                                    0.0007, 390, 15, new Color(196,233,238))); //Uranus
        solarSystem.addPlanet(new Planet(solarSystem.getStarX() + 450, solarSystem.getStarY(),
                                    0.0005, 450, 15, new Color(66, 98, 243))); //Neptune
    }

    public void addPlanet(Planet newPlanet) {
        solarSystem.addPlanet(newPlanet);
    }

    public double getStarX() {
        return solarSystem.getStarX();
    }

    public double getStarY() {
        return solarSystem.getStarY();
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        for (int i = 0; i < solarSystem.getNumberOfPlanets(); i++) {
            g2d.setColor(solarSystem.getPlanet(i).getColor());
            drawCircleByCenter(g2d, (int) solarSystem.getPlanet(i).getPlanetX(),
                    (int) solarSystem.getPlanet(i).getPlanetY(),
                    (int) solarSystem.getPlanet(i).getPlanetDiameter());
        }
        timer.start();
    }

    private void drawCircleByCenter(Graphics g, int x, int y, int diameter){
        g.fillOval(x - diameter / 2, y - diameter / 2, diameter, diameter);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        time += DELAY;
        solarSystem.update(time);
        repaint();
    }
}
