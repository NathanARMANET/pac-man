package jeu.entitées;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import librairie.Direction;
import librairie.GraphicalEntity;
import librairie.MovableEntity;

import java.util.Observable;
import java.util.Observer;

public class Fantome extends Parent implements Observer, GraphicalEntity {
    private MovableEntity _entity;
    private Shape _image;

    public MovableEntity getEntity(){
        return _entity;
    }

    public Shape getImage(){
        return _image;
    }

    public Fantome(double x, double y, double heigth, double width, double speed, Color color){
<<<<<<< HEAD
        _entity = new MovableEntity("fantome", x, y, heigth, width, speed);
        _entity.setGraphicalEntity((GraphicalEntity)this);
=======
        _entity = new MovableEntity("fantome", x, y, heigth, width, speed, this);
        _entity.setGraphicalEntity(this);
>>>>>>> 38d7ffeac031c45bcd19ce4bcdaf6fbccea4710a
        _entity.addObserver(this);
        _image = new Rectangle(x,y,width,heigth);
        _image.setFill(color);
        this.getChildren().add(_image);

    }

    public void changeDirection(Direction direction){
        _entity.setDirection(direction);
        // tourner l'image
    }

    public void deplacer(){
<<<<<<< HEAD
        if (_entity.getDirection()== Direction.immobile) _entity.setDirection(Direction.randomDirection());
=======
        _entity.deplacer();
        super.relocate(_entity.getX(),_entity.getY());
    }

    public void deplacerRandom(){
        if (_entity.get_d() == Direction.immobile) {
            Direction impossible;
            switch (_entity.get_previousDirection()) {
                case haut: impossible = Direction.bas;
                break;

                case bas: impossible = Direction.haut;
                break;

                case droite: impossible = Direction.gauche;
                break;

                case gauche: impossible = Direction.droite;
                break;

                default: impossible = Direction.immobile;
                break;
            }

            do {
                _entity.set_d(Direction.randomDirection());
            }while (_entity.get_d() == impossible);

        }
>>>>>>> 38d7ffeac031c45bcd19ce4bcdaf6fbccea4710a
        _entity.deplacer();
        super.relocate(_entity.getX(),_entity.getY());
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
