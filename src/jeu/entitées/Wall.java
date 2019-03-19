package jeu.entitées;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import librairie.Entity;
import librairie.GraphicalEntity;

/**
 *
 * @author thiti
 */
public class Wall extends Parent implements GraphicalEntity {
    
    private Entity _entity;
    private Shape _image;             

    public Entity getEntity(){
        return _entity;
    }
    
    public Shape getImage(){
        return _image;
    }
    
    public Wall(double x, double y, double heigth, double width){
        _entity = new Entity("wall", x, y, heigth, width);
        _image = new Rectangle(x,y,width,heigth);
        _image.setFill(Color.BROWN);
        _entity.setGraphicalEntity(this);
        this.getChildren().add(_image);
    }
    
    
}
