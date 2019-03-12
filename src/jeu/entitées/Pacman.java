package jeu.entitées;

import java.util.Observable;
import java.util.Observer;
import javafx.scene.Parent;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import librairie.CollisionBox;
import librairie.GraphicalEntity;
import librairie.MovableEntity;
import librairie.Direction;

public class Pacman extends Parent implements Observer,GraphicalEntity{
    
    private MovableEntity _entity;
    private Shape _image;             

    public MovableEntity getEntity(){
        return _entity;
    }
    
    public Shape getImage(){
        return _image;
    }
    
    public Pacman(double x, double y, double heigth, double width, double speed){
        _entity = new MovableEntity(x, y, heigth, width, speed);
        _entity.setGraphicalEntity((GraphicalEntity)this);
        _entity.addObserver(this);
        _image = new Rectangle(x,y,width,heigth);
        this.getChildren().add(_image);
        
    }
    
    public void changeDirection(Direction direction){
        _entity.set_d(direction);
        // tourner l'image 
    }
    
    public void deplacer(){
        _entity.deplacer();
        super.relocate(_entity.getX(),_entity.getY());
    }
    
    @Override
    public void update(Observable o, Object arg) {
        
    }
    
}
