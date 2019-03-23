package librairie;

import java.util.List;
import java.util.ArrayList;

public class BoardManager {

    private List<Entity> _entities = new ArrayList<Entity>();
    private List<MovableEntity> _movableEntities = new ArrayList<MovableEntity>();

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

    public Entity checkCollision(Entity entity) {
        for (Entity entityTested : _entities) {
            if((entity != entityTested) && (entity.checkCollision(entityTested))) return entityTested; // sorry
        }
        return null;
    }

    public ArrayList<Entity> upcommingCollision(MovableEntity originEntity){
        double x = originEntity.getX();
        double y = originEntity.getY();
        originEntity.deplacer();
        ArrayList<Entity> listEntity = new ArrayList<>();
        for (Entity entityTested : _entities) {
            if((originEntity != entityTested) && (originEntity.checkCollision(entityTested))){
                listEntity.add(entityTested);
            }
        }
        originEntity.translate(x, y);
        return listEntity;
=======
        return listEntity;
>>>>>>> 88fcd1867b4d6b3c01526b6b442826154f561216
    }

    public void checkAllCollision(){
        Entity entity;
        for(MovableEntity entityTested : _movableEntities){
            entity = checkCollision(entityTested);
            if(entity != null) {
                entityTested.eventCollision(entity);
            }
        }
    }
}
