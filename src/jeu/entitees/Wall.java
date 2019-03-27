package jeu.entitees;

import javafx.scene.Parent;
import librairie.Entity;
import librairie.GraphicalEntity;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

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
    
    public Wall(double x, double y, double height, double width){
        _entity = new Entity("wall", x, y, height, width);
        _image = new Rectangle(x,y,width,height);
        _image.setFill(Color.BROWN);
        _entity.setGraphicalEntity(this);
        this.getChildren().add(_image);
    }
    
    
}
