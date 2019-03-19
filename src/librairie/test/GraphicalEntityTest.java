///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package librairie.test;
//
//import javafx.scene.Parent;
//import javafx.scene.shape.Rectangle;
//import librairie.Entity;
//
//
///**
// *
// * @author thiti
// */
//public class GraphicalEntityTest extends Parent{
//
//    private Entity entity;
//    
//    public Entity getEntity(){
//        return entity;
//    } 
//    
//    public GraphicalEntityTest(String name, double x, double y, double heigth, double width ){
//        
//        // bug collinsion
//        Rectangle rect = new Rectangle(x,y,width,heigth);
//        entity = new Entity(name, x,y,heigth,width, this);
//        // on ajoute le rectangle au groupe
//        this.getChildren().add(rect);
//    }    
//    
//    @Override
//    public void relocate(double x, double y){
//        super.relocate(x, y);
//        entity.translate(x, y);
//    }
//    
//    public void translateX(double x){
//        entity.translate(x, entity.getY());
//        super.relocate(x, entity.getY());
//        
//    }
//    
//    public void translateY(double y){
//        entity.translate(entity.getX(), y);
//        super.relocate(entity.getX(), y);
//        
//    }
//  
//    public boolean checkCollision(GraphicalEntityTest obj){
//        return entity.checkCollision(obj.getEntity());
//    }
//}
