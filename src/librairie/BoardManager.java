package librairie;

import java.util.List;
import java.util.ArrayList;

public class BoardManager {
	
	private List<Entity> _entities = new ArrayList<Entity>();
        private List<Entity> _movableEntities = new ArrayList<MovableEntity>();
	
	public void addEntity(Entity entity) {
            _entities.add(entity);
	}
	
	public boolean removeEntity(Entity entity) {
            return _entities.remove(entity);
	}
        
        public void addMovableEntity(MovableEntity entity){
            _movableEntities.add(entity);
            if (!_entities.contains(entity)) {
                addEntity(entity);
            }
        }
        
        public boolean removeMovableEntity(MovableEntity entity){
            return _movableEntities.remove(entity) && _entities.remove(entity);
        }
	
	public entity checkCollision(Entity entity) {
		for (Entity entityTested : _entities) {
			if(entity != entityTested)
				if(entity.checkCollision(entityTested))
					return entityTested; // sorry
		}
		return null;
	}
        
        public void checkAllCollision(){
            for(MovableEntity entityTested : _movableEntities){
                Entity entity = checkCollision(entityTested);
                entity != null ? entityTested.eventCollision(entity) :;
            }
        }
	

}
