package jeu.entitees;


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

    private double _startX;
    private double _startY;
    private MovableEntity _entity;
    private Direction _previousDirection;
    private BoardManager _boardManager;

    public MovableEntity getEntity(){
        return _entity;
    }

    public Fantome(double x, double y, double heigth, double width, double speed, String couleur){
        _startX = x;
        _startY = y;
        _entity = new MovableEntity(x, y, heigth, width, speed);
        _entity.setGraphicalEntity(this);
        _entity.setDirection(Direction.droite);
        _previousDirection = Direction.droite;
        _entity.addObserver(this);

        String str = "./images/fantome-"+couleur+".png";

        try {
            FileInputStream input1 = new FileInputStream(str);
            Image img1 = new Image(input1, width, heigth, true, true);
            ImageView image = new ImageView(img1);
            this.getChildren().add(image);
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

    /**
     * Verifie si on peut aller dans la direction passer en paramètres
     * Si oui, on y va
     * Sinon, on continue dans l'acienne direction
     * @param direction la nouvelle direstion à tester
     */
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

    /**
     * Fait deplacer le pacman et gères les colisions avec les autres entitées
     * De plus, si il rencontre un mur, il choisit une nouvelle direction aléatoirement
     * Mais il ne peux pas retourner en arrière
     */
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
                }else if (g instanceof Pacman && ((Pacman) g).isSuperPacMan()) {
                    _entity.setX(_startX);
                    _entity.setY(_startY);
                    _previousDirection = Direction.immobile;
                    _entity.setDirection(Direction.immobile);
                }
            }
        }
        _entity.deplacer();
        super.relocate(_entity.getX(),_entity.getY());
    }

    /**
     * Fait deplacer le fantome et gères les colisions avec les autres entitées
     */
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
