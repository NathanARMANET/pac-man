package librairie;

public class MovableEntity extends Entity {

    private Direction _d;
    private double _speed;

    public MovableEntity(double x, double y, CollisionBox hitBox) {
        super(x, y, hitBox);
        _d = Direction.immobile;
    }

    public MovableEntity(double x, double y, double height, double width) {
        this(x, y, new CollisionBox(height, width));
    }

    public void deplacer() {
        switch (_d) {
            case haut: _y -= _speed;
            break;

            case bas: _y += _speed;
            break;

            case gauche: _x -= _speed;
            break;

            case droite: _x += _speed;
            break;

            default: break;
        }
    }

    public void eventCollision(Entity obj) {
        notifyObservers(obj);
    }
}
