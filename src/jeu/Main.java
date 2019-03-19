package jeu;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import librairie.Direction;

import java.util.Observable;
import java.util.Observer;
import javafx.scene.input.InputEvent;
import librairie.Direction;

public class Main extends Application implements Observer {

    public Jeu _jeu;
    public Text _score;
    public Text _life;

    @Override
    public void start(Stage primaryStage) {
        _jeu = new Jeu();

        primaryStage.setTitle("Pac Man");

        Group root = new Group();

        root.getChildren().add(_jeu.getPacman());

        _jeu.initGrille(root);


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

        _score = new Text();
        _score.setX(800);
        _score.setY(20);

        root.getChildren().add(_score);

        _life = new Text();
        _life.setX(600);
        _life.setY(20);

        root.getChildren().add(_life);
        
        
        EventHandler<KeyEvent> keyEventHander = event -> {
            Direction dir = _jeu.getPacman().getEntity().get_d();
            
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
            }
            _jeu.setDirection(dir);
        };
        
        //this.onKeyReleased();
        
        

        root.requestFocus();

        primaryStage.setScene(new Scene(root, 1000, 800));

        primaryStage.addEventHandler(KeyEvent.KEY_TYPED, keyEventHander);

        primaryStage.requestFocus();

        primaryStage.show();

        _jeu.addObserver(this);

        new Thread(_jeu).start();
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    public static void main(String[] args) {
        launch(args);

    }


}
