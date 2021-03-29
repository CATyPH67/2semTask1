package ru.vsu.cs.ivanov;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SolarSystem solarSystem = new SolarSystem(500, 500);
                solarSystem.setSolarSystem();

                JFrame frame = new JFrame("Solar system");
                JPanel panel = new JPanel();
                Animation animation = new Animation(solarSystem);
                panel.add(animation);

                JLabel labelSpeed = new JLabel("speed");
                labelSpeed.setForeground(Color.WHITE);
                JLabel labelOrbitRadius = new JLabel("orbit radius");
                labelOrbitRadius.setForeground(Color.WHITE);
                JLabel labelPlanetDiameter = new JLabel("planet diameter");
                labelPlanetDiameter.setForeground(Color.WHITE);
                JLabel labelColorRed = new JLabel("color red");
                labelColorRed.setForeground(Color.WHITE);
                JLabel labelColorGreen = new JLabel("color green");
                labelColorGreen.setForeground(Color.WHITE);
                JLabel labelColorBlue = new JLabel("color blue");
                labelColorBlue.setForeground(Color.WHITE);

                JTextField textSpeed = new JTextField("", 5);
                JTextField textOrbitRadius = new JTextField("", 5);
                JTextField textPlanetDiameter = new JTextField("", 5);
                JTextField textColorRed = new JTextField("", 5);
                JTextField textColorGreen = new JTextField("", 5);
                JTextField textColorBlue = new JTextField("", 5);

                JButton buttonAdd = new JButton("add planet");
                buttonAdd.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        double speed = Double.parseDouble(textSpeed.getText()) * 0.0001;
                        double orbitRadius = Double.parseDouble(textOrbitRadius.getText());
                        double planetDiameter = Double.parseDouble(textPlanetDiameter.getText());
                        int red = Integer.parseInt(textColorRed.getText());
                        int green = Integer.parseInt(textColorGreen.getText());
                        int blue = Integer.parseInt(textColorBlue.getText());
                        Color color = new Color(red, green, blue);
                        double planetX = animation.getSolarSystem().getStarX() + orbitRadius;
                        double planetY = animation.getSolarSystem().getStarY();

                        animation.getSolarSystem().addPlanet(new Planet(planetX, planetY, speed, orbitRadius, planetDiameter, color));
                    }
                });

                Container container = new Container();
                container.setLayout(new GridLayout(7, 2));
                container.add(labelSpeed);
                container.add(textSpeed);
                container.add(labelOrbitRadius);
                container.add(textOrbitRadius);
                container.add(labelPlanetDiameter);
                container.add(textPlanetDiameter);
                container.add(labelColorRed);
                container.add(textColorRed);
                container.add(labelColorGreen);
                container.add(textColorGreen);
                container.add(labelColorBlue);
                container.add(textColorBlue);
                container.add(buttonAdd);

                panel.add(container);
                panel.setBackground(Color.BLACK);
                frame.getContentPane().add(panel);

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
