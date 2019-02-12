package librairie;

public class CollisionBox {
	
	private float _height;
	private float _width;
	
	public float getHeight() {
		return _height;
	}
	public float getWidth() {
		return _width;
	}
	public void setHeight(float _height) {
		this._height = _height;
	}
	public void setWidth(float _width) {
		this._width = _width;
	}
	
	public CollisionBox(float height, float width) {
		setHeight(height);
		setWidth(width);
	}
	
	
	
	
}
