/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librairie.test;

import java.util.Observable;
import java.util.Observer;
import javafx.scene.Parent;
import librairie.MovableEntity;
import librairie.GraphicalEntity;

/**
 *
 * @author thiti
 */
public class PacMan extends Parent implements Observer,GraphicalEntity{
    
    private MovableEntity _entity;

    @Override
    public void update(Observable o, Object arg) {
        
    }
    
    public PacMan(){
        _entity = new MovableEntity(50, 50, 40, 40, 40);
        _entity.setGraphicalEntity((GraphicalEntity)this);
        _entity.addObserver(this);
    }
    
    
}
