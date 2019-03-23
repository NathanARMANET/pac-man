package jeu.entitées;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import librairie.*;

import java.util.Random;
=======
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
>>>>>>> 88fcd1867b4d6b3c01526b6b442826154f561216

public class Fantome extends Parent implements Observer, GraphicalEntity {

    private MovableEntity _entity;
    private Direction _previousDirection;
=======
    private ImageView _image;
    private BoardManager _boardManager;
>>>>>>> 88fcd1867b4d6b3c01526b6b442826154f561216

    public MovableEntity getEntity(){
        return _entity;
    }

    public ImageView getImage(){
        return _image;
    }

    public Fantome(double x, double y, double heigth, double width, double speed, String couleur){
        _entity = new MovableEntity("fantome", x, y, heigth, width, speed);
        _entity.setGraphicalEntity((GraphicalEntity)this);
        _entity.setDirection(Direction.droite);
        _previousDirection = Direction.droite;
        _entity.addObserver(this);

        String str = "./images/fantome-"+couleur+".png";

        try {
            FileInputStream input1 = new FileInputStream(str);
            Image img1 = new Image(input1, 20, 20, true, true);
            _image = new ImageView(img1);
            this.getChildren().add(_image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    public void setBoardManager(BoardManager board){
        _boardManager = board;
    }

    public void setBoardManager(BoardManager board){
        _boardManager = board;
    }


    public void changeDirection(Direction direction){
        if (direction == null) return;

        Direction oldDirection = _entity.getDirection();
        double x = _entity.getX();
        double y = _entity.getY();

        _entity.setDirection(direction);
        _entity.deplacer();

        ArrayList<Entity> listEntity = _boardManager.upcommingCollision(_entity);
        if(listEntity.size() > 0){
            for (Entity entityTested : listEntity) {
                GraphicalEntity g = entityTested.getGraphicalEntity();
                if (g instanceof Wall) {
                    _entity.setDirection(oldDirection);
                }
            }
        }
        _entity.translate(x, y);
    public void deplacer() {
=======
    }

    public void deplacerRandom() {
        Direction impossible;
        switch (_previousDirection) {
            case haut: impossible = Direction.bas;
                break;

            case droite: impossible = Direction.gauche;
                break;

            case bas: impossible = Direction.haut;
                break;

            case gauche: impossible = Direction.droite;
                break;

            default: impossible = Direction.immobile;
                break;
        }

        if (_entity.getDirection() == Direction.immobile) {
            Random r = new Random();
            int ind_R =  r.nextInt(2)+1;
            int ind = 0;
            for (Direction dir : Direction.values()) {
                if (dir != impossible && dir != _previousDirection && dir != Direction.immobile && ind < ind_R) {
                    changeDirection(dir);
                    ind++;
                }
            }
        }

        ArrayList<Entity> listEntity = _boardManager.upcommingCollision(_entity);
        if(listEntity.size() > 0){
            for (Entity entityTested : listEntity) {
                GraphicalEntity g = entityTested.getGraphicalEntity();
                if (g instanceof Wall) {
                    _previousDirection = _entity.getDirection();
                    _entity.setDirection(Direction.immobile);
                }
            }
        }
        _entity.deplacer();
        super.relocate(_entity.getX(),_entity.getY());
    }

    public void deplacer() {
        ArrayList<Entity> listEntity = _boardManager.upcommingCollision(_entity);
        if(listEntity.size() > 0){
            for (Entity entityTested : listEntity) {
                GraphicalEntity g = entityTested.getGraphicalEntity();
                if (g instanceof Wall) {
                    _previousDirection = _entity.getDirection();
                    _entity.setDirection(Direction.immobile);
                }
            }
        }

        _entity.deplacer();
        super.relocate(_entity.getX(),_entity.getY());
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
