/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librairie.test;

import javafx.scene.shape.Rectangle;
import librairie.Entity;


/**
 *
 * @author thiti
 */
public class GraphicalEntity extends Rectangle{

    private Entity entity;
    
    public GraphicalEntity(float x, float y, float heigth, float width){
        super(x,y,heigth,width);
        entity = new Entity(x,y,heigth,width);
    }
    
    public void translate(float x, float y){
        super.relocate(x, y);
        entity.translate(x, y);
    }   
    
}
