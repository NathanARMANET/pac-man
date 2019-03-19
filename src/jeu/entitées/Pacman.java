package jeu.entitées;

import java.util.Observable;
import java.util.Observer;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import librairie.BoardManager;
import librairie.CollisionBox;
import librairie.GraphicalEntity;
import librairie.MovableEntity;
import librairie.Direction;
import librairie.Entity;

public class Pacman extends Parent implements Observer,GraphicalEntity{

    private double _startX;
    private double _startY;
    private MovableEntity _entity;
    private Shape _image;

    private BoardManager _boardManager;

    public MovableEntity getEntity(){
        return _entity;
    }

    public Shape getImage(){
        return _image;
    }

    public void setBoardManager(BoardManager board){
        _boardManager = board;
    }

    public Pacman(double x, double y, double heigth, double width, double speed){
        _entity = new MovableEntity("pacman", x, y, heigth, width, speed);
        _entity.setGraphicalEntity((GraphicalEntity)this);
        _entity.addObserver(this);
        _image = new Rectangle(x,y,width,heigth);
        _image.setFill(Color.YELLOW);
        this.getChildren().add(_image);

    }

    public void changeDirection(Direction direction){
        if (direction == null)
            return;
        Direction oldDirection = _entity.getDirection();
        double x = _entity.getX();
        double y = _entity.getY();

        _entity.setDirection(direction);
        _entity.deplacer();
        Entity entity = _boardManager.checkCollision(_entity);
        if(entity != null){
            _entity.setDirection(oldDirection);
        }
        _entity.translate(x, y);
    }

    //code cracra
    public void deplacer(){
        Entity entity = _boardManager.upcommingCollision(_entity);
        if(entity != null){

            GraphicalEntity graphical = entity.getGraphicalEntity();
            if(graphical instanceof Wall){
                return;
            }
            else if (graphical instanceof Pacgomme) {
            }
        }
            _entity.deplacer();
            super.relocate(_entity.getX(),_entity.getY());
    }

    @Override
    public void update(Observable o, Object arg) {

    }

}
