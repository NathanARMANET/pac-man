package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Jeu jeu; 
        jeu = new Jeu();

        primaryStage.setTitle("Pac Man");

        Group root = new Group();

        Text consigne = new Text();
        consigne.setText("Touche pour deplacer Pac-man :\n" +
                "- z -> haut\n" +
                "- d -> droite\n" +
                "- q -> gauche\n" +
                "- s -> bas");
        consigne.setX(800);
        consigne.setY(40);

        Text score = new Text();
        score.setText("Score : "+jeu.score);
        score.setX(800);
        score.setY(20);

        root.getChildren().add(score);

        TextField txt = new TextField();

        root.getChildren().add(txt);

        jeu.grid.affichage(root);

        EventHandler<KeyEvent> keyEventHander = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCharacter()) {
                    case "z": jeu.pacman.d = Direction.haut;
                        break;

                    case "d": jeu.pacman.d = Direction.droite;
                        break;

                    case "s": jeu.pacman.d = Direction.bas;
                        break;

                    case "q": jeu.pacman.d = Direction.gauche;
                        break;
                }
                jeu.pacman.deplacer(jeu);
                jeu.grid.affichage(root);
                score.setText("Score : "+jeu.score);
                txt.clear();
            }
        };

        txt.addEventHandler(KeyEvent.KEY_TYPED, keyEventHander);

        root.getChildren().add(consigne);

        primaryStage.setScene(new Scene(root, 1000, 800));

        jeu.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                jeu.grid.affichage(root);
                primaryStage.show();
            }
        });

        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
