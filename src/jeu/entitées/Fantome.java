package jeu.entitées;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import librairie.*;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class Fantome extends Parent implements Observer, GraphicalEntity {

    private MovableEntity _entity;
    private Direction _previousDirection;
    private Shape _image;
    private BoardManager _boardManager;

    public MovableEntity getEntity(){
        return _entity;
    }

    public Shape getImage(){
        return _image;
    }

    public Fantome(double x, double y, double heigth, double width, double speed, Color color){
        _entity = new MovableEntity("fantome", x, y, heigth, width, speed);
        _entity.setGraphicalEntity((GraphicalEntity)this);
        _entity.setDirection(Direction.droite);
        _previousDirection = Direction.droite;
        _entity.addObserver(this);
        _image = new Rectangle(x,y,width,heigth);
        _image.setFill(color);
        this.getChildren().add(_image);
    }

    public void setBoardManager(BoardManager board){
        _boardManager = board;
    }


    public void changeDirection(Direction direction){
        if (direction == null) return;

        Direction oldDirection = _entity.getDirection();
        double x = _entity.getX();
        double y = _entity.getY();

        _entity.setDirection(direction);
        _entity.deplacer();

        ArrayList<Entity> listEntity = _boardManager.upcommingCollision(_entity);
        if(listEntity.size() > 0){
            for (Entity entityTested : listEntity) {
                GraphicalEntity g = entityTested.getGraphicalEntity();
                if (g instanceof Wall) {
                    _entity.setDirection(oldDirection);
                }
            }
        }
        _entity.translate(x, y);
    }

    public void deplacerRandom() {
        Direction impossible;
        switch (_previousDirection) {
            case haut: impossible = Direction.bas;
                break;

            case droite: impossible = Direction.gauche;
                break;

            case bas: impossible = Direction.haut;
                break;

            case gauche: impossible = Direction.droite;
                break;

            default: impossible = Direction.immobile;
                break;
        }
        /*while (_entity.getDirection() == Direction.immobile) {

            do {
                newDirection = Direction.randomDirection();
            }while (newDirection == impossible);

            changeDirection(newDirection);
        }*/

        if (_entity.getDirection() == Direction.immobile) {
            Random r = new Random();
            int ind_R =  r.nextInt(2)+1;
            int ind = 0;
            for (Direction dir : Direction.values()) {
                if (dir != impossible && dir != _previousDirection && dir != Direction.immobile && ind < ind_R) {
                    changeDirection(dir);
                    ind++;
                }
            }
        }

        ArrayList<Entity> listEntity = _boardManager.upcommingCollision(_entity);
        if(listEntity.size() > 0){
            for (Entity entityTested : listEntity) {
                GraphicalEntity g = entityTested.getGraphicalEntity();
                if (g instanceof Wall) {
                    _previousDirection = _entity.getDirection();
                    _entity.setDirection(Direction.immobile);
                }
            }
        }
        _entity.deplacer();
        super.relocate(_entity.getX(),_entity.getY());
    }

    public void deplacer() {
        ArrayList<Entity> listEntity = _boardManager.upcommingCollision(_entity);
        if(listEntity.size() > 0){
            for (Entity entityTested : listEntity) {
                GraphicalEntity g = entityTested.getGraphicalEntity();
                if (g instanceof Wall) {
                    _previousDirection = _entity.getDirection();
                    _entity.setDirection(Direction.immobile);
                }
            }
        }

        _entity.deplacer();
        super.relocate(_entity.getX(),_entity.getY());
        _entity.deplacer();
        super.relocate(_entity.getX(),_entity.getY());
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
