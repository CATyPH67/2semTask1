package ru.vsu.cs.ivanov;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Animation extends JComponent implements ActionListener {
    public static final int DELAY = 1;
    private int time = 0;
    private SolarSystem solarSystem;
    private Timer timer = new Timer(DELAY, this);

    public Animation(SolarSystem solarSystem) {
        this.solarSystem = solarSystem;
        setPreferredSize(new Dimension(1000, 1000));
    }

    public SolarSystem getSolarSystem() {
        return solarSystem;
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
