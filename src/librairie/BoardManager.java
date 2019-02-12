package librairie;

import java.util.List;
import java.util.ArrayList;

public class BoardManager {
	
	private List<Entity> _entities = new ArrayList<Entity>();
	
	public void addEntity(Entity entity) {
		_entities.add(entity);
	}
	
	public boolean removeEntity(Entity entity) {
		return _entities.remove(entity);
	}
	
	public boolean checkCollision(Entity entity) {
		for (Entity entityTested : _entities) {
			if(entity != entityTested)
				if(entity.checkCollision(entityTested))
					return true; // sorry
		}
		return false;
	}
	

}
