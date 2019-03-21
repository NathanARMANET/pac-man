package jeu.entitées;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import librairie.Entity;
import librairie.GraphicalEntity;

public class Pacgomme extends Parent implements GraphicalEntity{
    protected Entity _entity;
    protected Shape _image;

    public Entity getEntity(){
        return _entity;
    }

    public Shape getImage(){
        return _image;
    }

    public Pacgomme(double x, double y, double radius){
        _entity = new Entity("pacgomme", x, y, radius, radius);
        _image = new Circle();
        ((Circle) _image).setCenterX(x);
        ((Circle) _image).setCenterY(y);
        ((Circle) _image).setRadius(radius);
        _image.setFill(Color.BLACK);
        this.getChildren().add(_image);
        _entity.setGraphicalEntity(this);
    }
    
    public void delete(){
        
    }
}
