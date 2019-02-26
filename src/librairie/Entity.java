package librairie;

public class Entity{

	private double _x;
	private double _y;
	
	private CollisionBox _hitBox;

	public double getX() {
            return _x;
	
        }

	public double getY() {
            return _y;
	}
	

	public void setX(double x) {
            _x = x;
	}
	

	public void setY(double y) {
            _y = y;
	}
	
	public Entity(double x, double y, CollisionBox hitBox) {
            _x = x;
            _y = y;
            _hitBox = hitBox;
	}
	
	public Entity(double x, double y, double height, double width) {
            _x = x;
            _y = y;
            _hitBox = new CollisionBox(height, width);
	}
	

	public void translate(double x, double y) {
            _x = x;
            _y = y;
	}
	

	public boolean checkCollision(Entity obj) {
            if((_x >= obj._x + obj._hitBox.getWidth())      // trop à droite
                || (_x + _hitBox.getWidth() <= obj._x) // trop à gauche
                || (_y >= obj._y + obj._hitBox.getHeight()) // trop en bas
                || (_y + _hitBox.getHeight() <= obj._y))   // trop en haut
                return false; 
            else
                return true;
	}
}
