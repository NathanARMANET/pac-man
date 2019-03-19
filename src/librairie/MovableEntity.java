package librairie;

import javafx.scene.Parent;
import jeu.Jeu;
import jeu.entitées.Wall;

import java.awt.*;

public class MovableEntity extends Entity {

    private double _startX;
    private double _startY;
    private double _speed;
    private Direction _d;

    public MovableEntity(String name, double x, double y, CollisionBox hitBox, double speed, Parent container) {
        super(name, x, y, hitBox, container);
        _startX = x;
        _startY = y;
        _d = Direction.immobile;
        _speed = speed;
    }

    public MovableEntity(String name, double x, double y, double height, double width, double speed, Parent container) {
        this(name, x, y, new CollisionBox(height, width), speed, container);
    }
    
    public MovableEntity(MovableEntity entity){
        this(entity._name, entity._x ,entity._y, entity._hitBox, entity._speed, entity._container);
        this._d = entity._d;
    }

    public double get_speed() {
        return _speed;
    }

    public void set_speed(double _speed) {
        this._speed = _speed;
    }

    public Direction get_d() {
        return _d;
    }

    public void set_d(Direction _d) {
        this._d = _d;
    }

    public double get_startX() {
        return _startX;
    }

    public void set_startX(double startX) {
        this._startX = startX;
    }

    public double get_startY() {
        return _startY;
    }

    public void set_startY(double startY) {
        this._startY = startY;
    }

    public void deplacer() {
        switch (_d) {
            case haut: _y -= _speed;
            break;

            case bas: _y += _speed;
            break;

            case gauche: _x -= _speed;
            break;

            case droite: _x += _speed;
            break;

            default: break;
        }
    }

    public void eventCollision(Jeu jeu, Entity obj) {
        switch (obj.get_name()) {
            case "wall" :
                switch (_d) {
                    case haut:
                        _y += _speed;
                        break;

                    case bas:
                        _y -= _speed;
                        break;

                    case gauche:
                        _x += _speed;
                        break;

                    case droite:
                        _x -= _speed;
                        break;

                    default: break;
                }
                this._d = Direction.immobile;
                break;

            case "pacgomme" :
                if (this._name.equals("pacman")) jeu.setScore(jeu.getScore()+10);
                break;

            case "superpacgomme" :
                if (this._name.equals("pacman")) jeu.setScore(jeu.getScore()+20);
                break;

            case "fantome" :
                if (this._name.equals("pacman")) {
                    jeu.setLives(jeu.getLives()-1);
                    this.setX(this.get_startX());
                    this.setY(this.get_startY());
                }
                break;

            case "pacman" : jeu.setLives(jeu.getLives()-1);
                break;

            default: break;
        }
    }
}
