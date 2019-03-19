package jeu.entitées;

import java.util.Observable;
import java.util.Observer;
import javafx.scene.Parent;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import librairie.BoardManager;
import librairie.CollisionBox;
import librairie.GraphicalEntity;
import librairie.MovableEntity;
import librairie.Direction;
import librairie.Entity;

public class Pacman extends Parent implements Observer,GraphicalEntity{
    
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
        _entity = new MovableEntity(x, y, heigth, width, speed);
        _entity.setGraphicalEntity((GraphicalEntity)this);
        _entity.addObserver(this);
        _image = new Rectangle(x,y,width,heigth);
        this.getChildren().add(_image);
        
    }
    
    public void changeDirection(Direction direction){
        Direction oldDirection = _entity.get_d();
        double x = _entity.getX();
        double y = _entity.getY();
        
        _entity.set_d(direction);
        _entity.deplacer();
        Entity entity = _boardManager.checkCollision(_entity);
        if(entity != null){
            _entity.set_d(oldDirection);
        }
        _entity.translate(x, y);
    }
    
    //code cracra
    public void deplacer(){
        Entity entity = _boardManager.upcommingCollision(_entity);
        if(entity != null){
            _entity.eventCollision(entity);
        }
        else{
            _entity.deplacer();
            super.relocate(_entity.getX(),_entity.getY());
        }
    }
    
    @Override
    public void update(Observable o, Object arg) {
        
    }
    
}
