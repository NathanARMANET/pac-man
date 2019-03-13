package librairie;

import javafx.scene.paint.Color;
import jeu.Jeu;
import jeu.entitées.Pacgomme;

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

    public void checkAllCollision(Jeu jeu){
        for(MovableEntity entityTested : _movableEntities){
            Entity entity = checkCollision(entityTested);
            if(entity != null) {
                entityTested.eventCollision(jeu, entity);
                if (entity.get_name().equals("pacgomme") && entityTested.get_name().equals("pacman")) {
                    ((Pacgomme)entity.getContainer()).getImage().setFill(Color.TRANSPARENT);
                    _entities.remove(entity);
                }
            }
        }
    }
}
