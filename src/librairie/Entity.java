package librairie;

import java.util.Observable;
import librairie.GraphicalEntity;

public class Entity extends Observable{

    protected double _x;
    protected double _y;
    protected CollisionBox _hitBox;
    protected GraphicalEntity _graphic;

    public double getX() {
        return _x;
    }

    public double getY() {
        return _y;
    }


    public void setX(double x) {
        _x = x;
    }


    public void setY(double y) {
        _y = y;
    }

    public Entity(double x, double y, CollisionBox hitBox) {
        _x = x;
        _y = y;
        _hitBox = hitBox;
    }

    public Entity(double x, double y, double height, double width) {
        this(x, y, new CollisionBox(height, width));
    }


    public void translate(double x, double y) {
        _x = x;
        _y = y;
    }


    public boolean checkCollision(Entity obj) {
        /**
         * vérification de la position :
         * trop à droite
         * trop à gauche
         * trop en bas
         * trop en haut
         */
        return !((_x >= obj._x + obj._hitBox.getWidth())
            || (_x + _hitBox.getWidth() <= obj._x)
            || (_y >= obj._y + obj._hitBox.getHeight())
            || (_y + _hitBox.getHeight() <= obj._y));
    }
    
    public void setGraphicalEntity(GraphicalEntity entity){
        if (entity == null)
            throw new IllegalArgumentException();
        _graphic = entity;
    }
}
