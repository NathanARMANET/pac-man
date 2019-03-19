package librairie;

public class MovableEntity extends Entity {

    private double _speed;
<<<<<<< HEAD
    private Direction _direction;

    public MovableEntity(String name, double x, double y, CollisionBox hitBox, double speed) {
        super(name, x, y, hitBox);
        _direction = Direction.immobile;
=======
    private Direction _d;
    private Direction _previousDirection;

    public MovableEntity(String name, double x, double y, CollisionBox hitBox, double speed, Parent container) {
        super(name, x, y, hitBox, container);
        _startX = x;
        _startY = y;
        _d = Direction.immobile;
        _previousDirection = Direction.immobile;
>>>>>>> 38d7ffeac031c45bcd19ce4bcdaf6fbccea4710a
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

<<<<<<< HEAD
    public Direction getDirection() {
        return _direction;
=======
    public Direction get_d() {
        return _d;
    }

    public void set_d(Direction _d) {
        this._d = _d;
    }

    public Direction get_previousDirection() {
        return _previousDirection;
    }

    public void set_previousDirection(Direction _previousDirection) {
        this._previousDirection = _previousDirection;
    }

    public double get_startX() {
        return _startX;
>>>>>>> 38d7ffeac031c45bcd19ce4bcdaf6fbccea4710a
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

<<<<<<< HEAD
    public void eventCollision(Entity obj) {
        
=======
    public void eventCollision(Jeu jeu, Entity obj) {
        switch (obj.get_name()) {
            case "wall" :
                switch (_d) {
                    case haut:
                        _y += _speed;
                        break;

                    case bas:
                        _y -= _speed;
                        break;

                    case gauche:
                        _x += _speed;
                        break;

                    case droite:
                        _x -= _speed;
                        break;

                    default: break;
                }
                this._previousDirection = this._d;
                this._d = Direction.immobile;
                break;

            case "pacgomme" :
                if (this._name.equals("pacman")) jeu.setScore(jeu.getScore()+10);
                break;

            case "superpacgomme" :
                if (this._name.equals("pacman")) jeu.setScore(jeu.getScore()+20);
                break;

            case "fantome" :
                if (this._name.equals("pacman")) {
                    jeu.setLives(jeu.getLives()-1);
                    this.setX(this.get_startX());
                    this.setY(this.get_startY());
                }
                break;

            case "pacman" : jeu.setLives(jeu.getLives()-1);
                break;

            default: break;
        }
>>>>>>> 38d7ffeac031c45bcd19ce4bcdaf6fbccea4710a
    }
}
