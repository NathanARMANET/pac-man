package librairie;

public class Entity {

	private float _x;
	private float _y;
	
	private CollisionBox _hitBox;

	public float getX() {
		return _x;
	}
	
	public float getY() {
		return _y;
	}
	
	public void setX(float x) {
		_x = x;
	}
	
	public void setY(float y) {
		_y = y;
	}
	
	public Entity(float x, float y, CollisionBox hitBox) {
		_x = x;
		_y = y;
		_hitBox = hitBox;
	}
	
	public Entity(float x, float y, float height, float width) {
		_x = x;
		_y = y;
		_hitBox = new CollisionBox(height, width);
	}
	
	public void translate(float x, float y) {
		_x = x;
		_y = y;
	}
	
	public boolean checkCollision(Entity obj) {
		if((_x >= obj._x + obj._hitBox.getWidth())      // trop à droite
				|| (_x + _hitBox.getWidth() <= obj._x) // trop à gauche
				|| (_x >= obj._x + obj._hitBox.getWidth()) // trop en bas
				|| (_x + _hitBox.getWidth() <= obj._x))   // trop en haut
			return false; 
		else
			return true;
	}
}
