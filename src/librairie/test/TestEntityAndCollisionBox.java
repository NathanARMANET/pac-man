/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librairie.test;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author thiti
 */
public class TestEntityAndCollisionBox extends Application{

    private Group root;
    private ArrayList<GraphicalEntityTest> lst = new ArrayList<GraphicalEntityTest>();
            
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
                    if(!lst.get(0).checkCollision(lst.get(1)))
                        lst.get(0).translateY(i);
                    
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(TestEntityAndCollisionBox.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
        }).start();
        
    }
    
    public void createEntity(float x, float y){
        GraphicalEntityTest entity = new GraphicalEntityTest("test", x, y,50,10);
        root.getChildren().add(entity);
        lst.add(entity);
        
    }
    
    public static void main(String[] args) {
        launch(args);
        
    }
    
    
    
}
