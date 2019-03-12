package jeu;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import jeu.Jeu;

import java.util.Observable;
import java.util.Observer;
import librairie.Direction;

public class Main extends Application implements Observer {
    public Jeu jeu;
    public Text score;
    public Text life;

    @Override
    public void start(Stage primaryStage) {
        jeu = new Jeu();

        primaryStage.setTitle("Pac Man");

        Group root = new Group();

        root.getChildren().add(jeu.getPacman());

        Text consigne = new Text();
        consigne.setText("Touche pour deplacer Pac-man :\n" +
                "- z -> haut\n" +
                "- d -> droite\n" +
                "- q -> gauche\n" +
                "- s -> bas\n\n" +

                "- i -> haut fantome J2\n" +
                "- l -> droite fantome J2\n" +
                "- k -> bas fantome J2\n" +
                "- j -> gauche fantome J2\n\n" +

                "- w -> fantome Rouge\n" +
                "- x -> fantome Bleu\n" +
                "- c -> fantome Rose\n" +
                "- v -> fantome Vert\n" +
                "- n -> pas de fantome\n");
        consigne.setX(800);
        consigne.setY(40);

        root.getChildren().add(consigne);

        score = new Text();
        score.setX(800);
        score.setY(20);

        root.getChildren().add(score);

        life = new Text();
        life.setX(600);
        life.setY(20);

        root.getChildren().add(life);
        
        
        EventHandler<KeyEvent> keyEventHander = event -> {
            Direction dir = Direction.immobile;
            switch (event.getCharacter()) {
                //deplacement pac-mac
                case "z" : dir = Direction.haut;
                    break;

                case "d" : dir =  Direction.droite;
                    break;

                case "s" : dir =  Direction.bas;
                    break;

                case "q" : dir =  Direction.gauche;
                    break;

                //choix fantome
                /*
                case "w" : jeu.fantomeJ2 = 0;
                    break;

                case "x" : jeu.fantomeJ2 = 1;
                    break;

                case "c" : jeu.fantomeJ2 = 2;
                    break;

                case "v" : jeu.fantomeJ2 = 3;
                    break;

                case "n" : jeu.fantomeJ2 = 4;
                    break;

                //deplacement fantome
                case "i" : if (jeu.fantomeJ2 < 4) jeu.fantomes[jeu.fantomeJ2].d = Direction.haut;
                    break;

                case "l" : if (jeu.fantomeJ2 < 4) jeu.fantomes[jeu.fantomeJ2].d = Direction.droite;
                    break;

                case "k" : if (jeu.fantomeJ2 < 4) jeu.fantomes[jeu.fantomeJ2].d = Direction.bas;
                    break;

                case "j" : if (jeu.fantomeJ2 < 4) jeu.fantomes[jeu.fantomeJ2].d = Direction.gauche;
                    break;
                    */
            }
            jeu.getPacman().changeDirection(dir);
        };

        root.requestFocus();

        primaryStage.setScene(new Scene(root, 1000, 800));

        primaryStage.addEventHandler(KeyEvent.KEY_TYPED, keyEventHander);

        primaryStage.requestFocus();

        primaryStage.show();

        jeu.addObserver(this);

        new Thread(jeu).start();
    }

    @Override
    public void update(Observable o, Object arg) {
        //score.setText("Score : "+jeu.score);
        //life.setText("Life : "+jeu.life);
        //jeu.grid.affichage(rectGrid);
    }

    public static void main(String[] args) {
        launch(args);

    }


}
