package jeu.entitées;

import librairie.CollisionBox;
import librairie.MovableEntity;

public class Pacman extends MovableEntity {
    public Pacman(double x, double y, CollisionBox hitBox, double speed) {
        super(x, y, hitBox, speed);
    }

    public Pacman(double x, double y, double height, double width, double speed) {
        super(x, y, height, width, speed);
    }
}
