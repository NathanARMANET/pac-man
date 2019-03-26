package jeu.entitées;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import librairie.Entity;
import librairie.GraphicalEntity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 * @author thiti
 */
public class Wall extends Parent implements GraphicalEntity {
    
    private Entity _entity;
    private ImageView _image;

    public Entity getEntity(){
        return _entity;
    }

    public Wall(double x, double y, double heigth, double width, String typeMur,int angle){
        _entity = new Entity("wall", x, y, heigth, width);

        String str = "./images/"+typeMur+".png";

        try {
            FileInputStream input1 = new FileInputStream(str);
            Image img1 = new Image(input1, 25, 25, true, true);
            _image = new ImageView(img1);
            _image.setRotate(angle);
            _image.setX(x);
            _image.setY(y);
            this.getChildren().add(_image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        _entity.setGraphicalEntity(this);
    }
    
    
}
