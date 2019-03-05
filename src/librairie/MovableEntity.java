package librairie;

public class MovableEntity extends Entity {

    private Direction _d;

    public MovableEntity(double x, double y, CollisionBox hitBox) {
        super(x, y, hitBox);
        _d = Direction.immobile;
    }

    public MovableEntity(double x, double y, double height, double width) {
        this(x, y, new CollisionBox(height, width));
    }

    public void deplacer() {
        switch (_d) {
            case haut: _y--;
            break;

            case bas: _y++;
            break;

            case gauche: _x--;
            break;

            case droite: _x++;
            break;

            default: break;
        }
    }

    public void eventCollision(Entity obj) {
        /**
         * A definir dans le jeu
         */
    }
}
