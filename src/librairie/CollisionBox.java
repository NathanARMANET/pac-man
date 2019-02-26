package librairie;

public class CollisionBox {
	
	private double _height;
	private double _width;
	
	public double getHeight() {
		return _height;
	}
	public double getWidth() {
		return _width;
	}
	public void setHeight(double _height) {
		this._height = _height;
	}
	public void setWidth(double _width) {
		this._width = _width;
	}
	
	public CollisionBox(double height, double width) {
		setHeight(height);
		setWidth(width);
	}
	
	
	
	
}
