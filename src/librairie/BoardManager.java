package librairie;

import java.util.List;
import java.util.ArrayList;

public class BoardManager {

    private List<Entity> _entities = new ArrayList<>();
    private List<MovableEntity> _movableEntities = new ArrayList<>();

    /**
     * Ajoute une entitée à la liste _entities
     * @param entity Entitée a ajouter à la liste
     */
    public void addEntity(Entity entity) {
       _entities.add(entity);
    }

    /**
     * Retire une entitée de la liste _entities
     * @param entity Entitée a retirer
     */
    public boolean removeEntity(Entity entity) {
        return _entities.remove(entity);
    }

    /**
     * Ajoute une entitée à la liste _movableEntities
     * @param entity Entitée mouvable a ajouter à la liste
     */
    public void addMovableEntity(MovableEntity entity){
        _movableEntities.add(entity);
        if (!_entities.contains(entity)) {
            addEntity(entity);
        }
    }

    /**
     * Verifie si l'entitée passée en parametre est en colision ou non avec une entitée de la liste _entities
     * @param entity Entitée pour laquel on vérifie si il y a une colision ou non
     * @return Si il y a une colision ou pas
     */
    public Entity checkCollision(Entity entity) {
        for (Entity entityTested : _entities) {
            if((entity != entityTested) && (entity.checkCollision(entityTested))) return entityTested; // sorry
        }
        return null;
    }

    /**
     * Verifie si l'entitée mouvable passée en parametre sera en colision ou non avec une entitée de la liste _entities
     * si elle se déplace
     * @param originEntity Entitée mouvable pour laquel on vérifie si il y aura une colision ou non
     * @return Si il y aura une colision ou non
     */
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
    }

    @Deprecated
    public void checkAllCollision(){
        Entity entity;
        for(MovableEntity entityTested : _movableEntities){
            entity = checkCollision(entityTested);
            if(entity != null) {
                //entityTested.eventCollision(entity);
            }
        }
    }
}
