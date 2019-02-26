package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

public class Main extends Application implements Observer {
    public Jeu jeu;
    public Rectangle[][] rectGrid;
    public Text score;
    public Text life;

    @Override
    public void start(Stage primaryStage) throws Exception {
        jeu = new Jeu();

        primaryStage.setTitle("Pac Man");

        Group root = new Group();

        rectGrid = new Rectangle[Grille.LARGEUR][Grille.HAUTEUR];

        for (int i = 0 ; i < Grille.LARGEUR ; i++) {
            for (int j = 0 ; j < Grille.HAUTEUR ; j++) {
                rectGrid[i][j] = new Rectangle();
                rectGrid[i][j].setX(20*j);
                rectGrid[i][j].setY(20*i+40);
                rectGrid[i][j].setWidth(20);
                rectGrid[i][j].setHeight(20);
                root.getChildren().add(rectGrid[i][j]);
            }
        }

        Text consigne = new Text();
        consigne.setText("Touche pour deplacer Pac-man :\n" +
                "- z -> haut\n" +
                "- d -> droite\n" +
                "- q -> gauche\n" +
                "- s -> bas");
        consigne.setX(800);
        consigne.setY(40);

        score = new Text();
        score.setX(800);
        score.setY(20);

        root.getChildren().add(score);

        life = new Text();
        life.setX(600);
        life.setY(20);

        root.getChildren().add(life);

        final TextField txt = new TextField();

        root.getChildren().add(txt);

        EventHandler<KeyEvent> keyEventHander;
        keyEventHander = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                /*
                switch (event.getCharacter()) {
                    case "z": jeu.pacman.d = Direction.haut;
                    break;
                    
                    case "d": jeu.pacman.d = Direction.droite;
                    break;
                    
                    case "s": jeu.pacman.d = Direction.bas;
                    break;
                    
                    case "q": jeu.pacman.d = Direction.gauche;
                    break;
                }*/
                txt.clear();
            }
        };

        txt.addEventHandler(KeyEvent.KEY_TYPED, keyEventHander);

        root.getChildren().add(consigne);

        primaryStage.setScene(new Scene(root, 1000, 800));

        primaryStage.show();

        jeu.addObserver(this);

        new Thread(jeu).start();
    }

    @Override
    public void update(Observable o, Object arg) {
        score.setText("Score : "+jeu.score);
        life.setText("Life : "+jeu.life);
        jeu.grid.affichage(rectGrid);
    }

    public static void main(String[] args) {
        launch(args);
        
    }
    
    
}
