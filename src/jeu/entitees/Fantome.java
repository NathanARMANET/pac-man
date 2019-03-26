package jeu.entitees;

import com.sun.javafx.scene.traversal.WeightedClosestCorner;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import librairie.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class Fantome extends Parent implements Observer, GraphicalEntity {
    
    private static Random rdom = new Random();
    private static String[] colors = {"rouge","rose","orange","bleu"};

    private MovableEntity _entity;
    private Direction _previousDirection;
    private ImageView _image;
    private BoardManager _boardManager;

    public MovableEntity getEntity(){
        return _entity;
    }

    public Fantome(double x, double y, double heigth, double width, double speed, String couleur){
        _entity = new MovableEntity("fantome", x, y, heigth, width, speed);
        _entity.setGraphicalEntity(this);
        _entity.setDirection(Direction.droite);
        _previousDirection = Direction.droite;
        _entity.addObserver(this);

        String str = "./images/fantome-"+couleur+".png";

        try {
            FileInputStream input1 = new FileInputStream(str);
            Image img1 = new Image(input1, heigth, width, true, true);
            _image = new ImageView(img1);
            this.getChildren().add(_image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public Fantome(double x, double y, double heigth, double width, double speed){
        this(x,y,heigth,width,speed,colors[rdom.nextInt(colors.length)]);
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
            int ind_R =  rdom.nextInt(2)+1;
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
