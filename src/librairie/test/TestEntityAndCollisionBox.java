/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librairie.test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import librairie.Entity;

/**
 *
 * @author thiti
 */
public class TestEntityAndCollisionBox extends Application{

    private Group root;
            
    @Override
    public void start(Stage primaryStage) throws Exception {
        // set the title
        primaryStage.setTitle("Test Entity and CollisionBox");
        
        root = new Group();
        
        primaryStage.setScene(new Scene(root, 400, 300));

        createEntity(50,50);
        createEntity(100,50);
        primaryStage.show();
        
        new Thread( new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    ((GraphicalEntity)root.getChildren().get(0)).translate(i, i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(TestEntityAndCollisionBox.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
        }).start();
        
    }
    
    public void createEntity(float x, float y){
        Entity entity = new Entity(x,y,10,10);
        Node rec = new GraphicalEntity(x, y, 20, 20);
        
        root.getChildren().add(rec);
        
    }
    
    public static void main(String[] args) {
        launch(args);
        
    }
    
    
    
}
