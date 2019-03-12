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

public class Main extends Application implements Observer {
    public Jeu _jeu;
    public Text _score;
    public Text _life;

    @Override
    public void start(Stage primaryStage) {
        _jeu = new Jeu();

        primaryStage.setTitle("Pac Man");

        Group root = new Group();

        root.getChildren().add(_jeu.get_pacman().getImage());
        

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
            switch (event.getCharacter()) {
                //deplacement pac-mac
                case "z" : _jeu.get_pacman().changeDirection(Direction.haut);
                    break;

                case "d" : _jeu.get_pacman().changeDirection(Direction.droite);
                    break;

                case "s" : _jeu.get_pacman().changeDirection(Direction.bas);
                    break;

                case "q" : _jeu.get_pacman().changeDirection(Direction.gauche);
                    break;

                //choix fantome
                case "w" : _jeu.set_fantomeJ2(0);
                    break;

                case "x" : _jeu.set_fantomeJ2(1);
                    break;

                case "c" : _jeu.set_fantomeJ2(2);
                    break;

                case "v" : _jeu.set_fantomeJ2(3);
                    break;

                case "n" : _jeu.set_fantomeJ2(4);
                    break;

                //deplacement fantome
                case "i" : if (_jeu.get_fantomeJ2() < 4) _jeu.get_fantomes(_jeu.get_fantomeJ2()).changeDirection(Direction.haut);
                    break;

                case "l" : if (_jeu.get_fantomeJ2() < 4) _jeu.get_fantomes(_jeu.get_fantomeJ2()).changeDirection(Direction.droite);
                    break;

                case "k" : if (_jeu.get_fantomeJ2() < 4) _jeu.get_fantomes(_jeu.get_fantomeJ2()).changeDirection(Direction.bas);
                    break;

                case "j" : if (_jeu.get_fantomeJ2() < 4) _jeu.get_fantomes(_jeu.get_fantomeJ2()).changeDirection(Direction.gauche);
                    break;
            }
        };

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
