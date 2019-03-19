package jeu.entitées;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import librairie.Entity;

public class Pacgomme extends Parent {
    private Entity _entity;
    private Shape _image;

    public Entity getEntity(){
        return _entity;
    }

    public Shape getImage(){
        return _image;
    }

    public Pacgomme(double x, double y, double radius){
        _entity = new Entity("pacgomme", x, y, radius, radius, this);
        _image = new Circle();
        ((Circle) _image).setCenterX(x);
        ((Circle) _image).setCenterY(y);
        ((Circle) _image).setRadius(radius);
        _image.setFill(Color.BLACK);
        this.getChildren().add(_image);
    }
}
