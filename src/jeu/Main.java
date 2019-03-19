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

    private Jeu _jeu;
    private Text _score;
    private Text _life;

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Pac Man");

        Group root = new Group();

        _jeu = new Jeu(root);


        Text consigne = new Text();
        consigne.setText("Touche pour deplacer Pac-man :\n" +
                "- a -> immobile\n" +
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

        consigne.setX(950);
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
<<<<<<< HEAD
            Direction dir = _jeu.getPacman().getEntity().getDirection();
            
=======
            Direction dir = _jeu.getPacman().getEntity().get_d();

>>>>>>> 38d7ffeac031c45bcd19ce4bcdaf6fbccea4710a
            switch (event.getCharacter()) {
                //deplacement pac-mac
                case "a" : _jeu.getPacman().changeDirection(Direction.immobile);
                    break;

                case "z" : _jeu.getPacman().changeDirection(Direction.haut);
                    break;

                case "d" : _jeu.getPacman().changeDirection(Direction.droite);
                    break;

                case "s" : _jeu.getPacman().changeDirection(Direction.bas);
                    break;

                case "q" : _jeu.getPacman().changeDirection(Direction.gauche);
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
            _jeu.setDirection(dir);
        };

        //this.onKeyReleased();



        root.requestFocus();

        primaryStage.setScene(new Scene(root, 1200, 1000));

        primaryStage.addEventHandler(KeyEvent.KEY_TYPED, keyEventHander);

        primaryStage.requestFocus();

        primaryStage.show();

        _jeu.addObserver(this);

        new Thread(_jeu).start();
    }

    @Override
    public void update(Observable o, Object arg) {
        _score.setText("Score : "+ _jeu.getScore());
        _life.setText("Life : "+ _jeu.getLives());
    }

    public static void main(String[] args) {
        launch(args);

    }


}
