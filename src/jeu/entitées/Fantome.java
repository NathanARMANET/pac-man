package jeu.entitées;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import librairie.CollisionBox;
import librairie.Direction;
import librairie.GraphicalEntity;
import librairie.MovableEntity;

import java.util.Observable;
import java.util.Observer;

public class Fantome extends Parent implements Observer, GraphicalEntity {
    private MovableEntity _entity;
    private Shape _image;

    public MovableEntity getEntity(){
        return _entity;
    }

    public Shape getImage(){
        return _image;
    }

    public Fantome(double x, double y, double heigth, double width, double speed, Color color){
        _entity = new MovableEntity("fantome", x, y, heigth, width, speed, this);
        _entity.setGraphicalEntity((GraphicalEntity)this);
        _entity.addObserver(this);
        _image = new Rectangle(x,y,width,heigth);
        _image.setFill(color);
        this.getChildren().add(_image);

    }

    public void changeDirection(Direction direction){
        _entity.set_d(direction);
        // tourner l'image
    }

    public void deplacer(){
        if (_entity.get_d() == Direction.immobile) _entity.set_d(Direction.randomDirection());
        _entity.deplacer();
        super.relocate(_entity.getX(),_entity.getY());
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
