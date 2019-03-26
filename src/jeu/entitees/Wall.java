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

//    public Wall(double x, double y, double height, double width, String typeMur,int angle){
//        _entity = new Entity("wall", x, y, height, width);
//
//        String str = "./images/"+typeMur+".png";
//
//        try {
//            FileInputStream input1 = new FileInputStream(str);
//            Image img1 = new Image(input1, 25, 25, true, true);
//            _image = new ImageView(img1);
//            _image.setRotate(angle);
//            _image.setX(x);
//            _image.setY(y);
//            this.getChildren().add(_image);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        _entity.setGraphicalEntity(this);
//    }
    
    public Wall(double x, double y, double height, double width){
        _entity = new Entity("wall", x, y, height, width);
        _image = new Rectangle(x,y,width,height);
        _image.setFill(Color.BROWN);
        _entity.setGraphicalEntity(this);
        this.getChildren().add(_image);
    }
    
    
}
