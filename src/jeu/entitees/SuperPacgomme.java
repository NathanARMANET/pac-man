package jeu.entitees;

import javafx.scene.paint.Color;

public class SuperPacgomme extends Pacgomme {
    public SuperPacgomme(double x, double y, double radius) {
        super(x, y, radius);
        _image.setFill(Color.RED);
    }
}
