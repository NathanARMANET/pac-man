package librairie;

public class MovableEntity extends Entity {

    private double _speed;
    private Direction _direction;

    public MovableEntity(String name, double x, double y, CollisionBox hitBox, double speed) {
        super(name, x, y, hitBox);
        _direction = Direction.immobile;
        _speed = speed;
    }

    public MovableEntity(String name, double x, double y, double height, double width, double speed) {
        this(name, x, y, new CollisionBox(height, width), speed);
    }

    public MovableEntity(MovableEntity entity){
        this(entity._name, entity._x ,entity._y, entity._hitBox, entity._speed);
        this._direction = entity._direction;
    }

    public double getSpeed() {
        return _speed;
    }

    public void setSpeed(double _speed) {
        this._speed = _speed;
    }

    public Direction getDirection() {
        return _direction;
    }

    public void setDirection(Direction _d) {
        this._direction = _d;
    }

    public void deplacer() {
        switch (_direction) {
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
}
