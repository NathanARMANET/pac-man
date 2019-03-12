package librairie;

public class MovableEntity extends Entity {

    private double _speed;
    private Direction _d;

    public MovableEntity(double x, double y, CollisionBox hitBox, double speed) {
        super(x, y, hitBox);
        _d = Direction.immobile;
        _speed = speed;
    }

    public MovableEntity(double x, double y, double height, double width, double speed) {
        this(x, y, new CollisionBox(height, width), speed);
    }

    public double get_speed() {
        return _speed;
    }

    public void set_speed(double _speed) {
        this._speed = _speed;
    }

    public Direction get_d() {
        return _d;
    }

    public void set_d(Direction _d) {
        this._d = _d;
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
        switch (_d) {
            case haut: _y += _speed;
                break;

            case bas: _y -= _speed;
                break;

            case gauche: _x += _speed;
                break;

            case droite: _x -= _speed;
                break;

            default: break;
        }
        this._d = Direction.immobile;
        notifyObservers(obj);
    }
}
