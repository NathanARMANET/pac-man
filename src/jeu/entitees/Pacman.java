package jeu.entitees;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import librairie.BoardManager;
import librairie.GraphicalEntity;
import librairie.MovableEntity;
import librairie.Direction;
import librairie.Entity;
import jeu.Jeu;

public class Pacman extends Parent implements Observer,GraphicalEntity{

    private double _startX;
    private double _startY;
    private MovableEntity _entity;
    private ImageView _image;
    private BoardManager _boardManager;
    private boolean _superPacMan;
    private int _timeSuperPacman;
    private double _heigth;
    private double _width;

    public boolean isSuperPacMan() {
        return _superPacMan;
    }

    public void set_superPacMan(boolean _superPacMan) {
        this._superPacMan = _superPacMan;
    }

    public MovableEntity getEntity(){
        return _entity;
    }

    public void setBoardManager(BoardManager board){
        _boardManager = board;
    }

    public Pacman(double x, double y, double heigth, double width, double speed){
        _superPacMan = false;
        _heigth = heigth;
        _width = width;
        _timeSuperPacman = 0;
        _entity = new MovableEntity("pacman", x, y, heigth, width, speed);
        _startX = x;
        _startY = y;
        _entity.setGraphicalEntity(this);
        _entity.addObserver(this);

        try {
            FileInputStream input1 = new FileInputStream("./images/pacman.png");
            Image img1 = new Image(input1, width, heigth, true, true);
            _image = new ImageView(img1);
            this.getChildren().add(_image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void changeDirection(Direction direction){
        if (direction == null) return;

        Direction oldDirection = _entity.getDirection();
        double x = _entity.getX();
        double y = _entity.getY();

        _entity.setDirection(direction);
        _entity.deplacer();
        Entity entity = _boardManager.checkCollision(_entity);
        if(entity != null /*&& !(entity.getGraphicalEntity() instanceof Pacgomme)*/) {
            _entity.setDirection(oldDirection);
        }
        _entity.translate(x, y);
    }

    public void deplacer(Jeu j){
        ArrayList<Entity> listEntity = _boardManager.upcommingCollision(_entity);
        if (_timeSuperPacman > 0) {
            _timeSuperPacman--;
            if (_timeSuperPacman == 0) {
                _superPacMan = false;
                try {
                    FileInputStream input1 = new FileInputStream("./images/pacman.png");
                    Image img1 = new Image(input1, _width, _heigth, true, true);
                    _image.setImage(img1);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        if(listEntity.size() > 0){
            for (Entity entityTested : listEntity) {
                GraphicalEntity g = entityTested.getGraphicalEntity();
                if (g instanceof Wall) {
                    _entity.setDirection(Direction.immobile);
                } else if (g instanceof SuperPacgomme) {
                    j.setScore(j.getScore()+20);
                    ((SuperPacgomme) g).getImage().setFill(Color.TRANSPARENT);
                    _boardManager.removeEntity(entityTested);
                    _superPacMan = true;
                    _timeSuperPacman = 1000;
                    try {
                        FileInputStream input1 = new FileInputStream("./images/super-pacman.png");
                        Image img1 = new Image(input1, _width, _heigth, true, true);
                        _image.setImage(img1);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                } else if (g instanceof Pacgomme) {
                    j.setScore(j.getScore()+10);
                    ((Pacgomme) g).getImage().setFill(Color.TRANSPARENT);
                    _boardManager.removeEntity(entityTested);
                }else if(g instanceof Fantome && !_superPacMan) {
                    j.setLives(j.getLives()-1);
                    _entity.setX(_startX);
                    _entity.setY(_startY);
                    _superPacMan  = true;
                    _timeSuperPacman = 50;
                }
            }
        }
        _entity.deplacer();
        switch (_entity.getDirection()) {
            case droite: _image.setRotate(0);
            break;

            case gauche: _image.setRotate(180);
            break;

            case haut: _image.setRotate(270);
            break;

            case bas: _image.setRotate(90);
            break;

            default:break;
        }
        super.relocate(_entity.getX(),_entity.getY());
    }

    @Override
    public void update(Observable o, Object arg) {
    }

}
