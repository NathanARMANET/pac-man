<<<<<<< HEAD
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package librairie.test;
//
//import java.util.Observable;
//import java.util.Observer;
//import javafx.scene.Parent;
//import librairie.MovableEntity;
//import librairie.GraphicalEntity;
//
///**
// *
// * @author thiti
// */
//public class PacMan extends Parent implements Observer,GraphicalEntity{
//    
//    private MovableEntity _entity;
//
//    @Override
//    public void update(Observable o, Object arg) {
//        
//    }
//    
//    public PacMan(){
//        _entity = new MovableEntity("pacman", 50, 40, 40, 40, 40, this);
//        _entity.setGraphicalEntity((GraphicalEntity)this);
//        _entity.addObserver(this);
//    }
//    
//    
//}
=======
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
        _entity = new MovableEntity("pacman", 50, 40, 40, 40, 40, this);
        _entity.setGraphicalEntity(this);
        _entity.addObserver(this);
    }
    
    
}
>>>>>>> 38d7ffeac031c45bcd19ce4bcdaf6fbccea4710a
