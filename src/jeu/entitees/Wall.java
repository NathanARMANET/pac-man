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

    public Entity getEntity(){
        return _entity;
    }
    
    public Wall(double x, double y, double height, double width){
        _entity = new Entity(x, y, height, width);
        Shape image = new Rectangle(x, y, width, height);
        image.setFill(Color.BROWN);
        _entity.setGraphicalEntity(this);
        this.getChildren().add(image);
    }
}
