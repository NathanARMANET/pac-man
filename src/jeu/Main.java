package jeu;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import librairie.Direction;
import java.util.Observable;
import java.util.Observer;

public class Main extends Application implements Observer {

    private Jeu _jeu;
    private Text _score;
    private Text _life;

    @Override
    public void start(Stage primaryStage) {
        try {
            primaryStage.setTitle("Pac Man");
            primaryStage.getIcons().add(new Image("File:./images/pacman.png"));

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
                    "- v -> fantome Orange\n" +
                    "- n -> pas de fantome\n");

            consigne.setX(800);
            consigne.setY(40);

            root.getChildren().add(consigne);

            _score = new Text();
            _score.setX(800);
            _score.setY(20);

            root.getChildren().add(_score);

            _life = new Text();
            _life.setX(900);
            _life.setY(20);

            root.getChildren().add(_life);

            Button quit = new Button("Quitter");
            quit.setLayoutX(800);
            quit.setLayoutY(600);
            quit.setOnAction(event -> {

                Platform.exit();
                System.exit(0);
            });
            root.getChildren().add(quit);

            Button replay = new Button("Rejouer");
            replay.setLayoutX(800);
            replay.setLayoutY(650);
            replay.setOnAction(event -> {
                // reload app

                primaryStage.close();
                Platform.runLater( () -> new Main().start( new Stage() ) );
            });
            root.getChildren().add(replay);

            EventHandler<KeyEvent> keyEventHander = event -> {

                switch (event.getCharacter()) {
                    //deplacement pac-mac
                    case "a" : _jeu.setDirectionPacman(Direction.immobile);
                        break;

                    case "z" : _jeu.setDirectionPacman(Direction.haut);
                        break;

                    case "d" : _jeu.setDirectionPacman(Direction.droite);
                        break;

                    case "s" : _jeu.setDirectionPacman(Direction.bas);
                        break;

                    case "q" : _jeu.setDirectionPacman(Direction.gauche);
                        break;

                    //choix fantome

                    case "w" : _jeu.setFantomeJ2(0);
                        break;

                    case "x" : _jeu.setFantomeJ2(1);
                        break;

                    case "c" : _jeu.setFantomeJ2(2);
                        break;

                    case "v" : _jeu.setFantomeJ2(3);
                        break;

                    case "n" : _jeu.setFantomeJ2(4);
                        break;

                    //deplacement fantome
                    case "i" : if (_jeu.getFantomeJ2() < 4) _jeu.setDirectionfantomeJ2(Direction.haut);
                        break;

                    case "l" : if (_jeu.getFantomeJ2() < 4) _jeu.setDirectionfantomeJ2(Direction.droite);
                        break;

                    case "k" : if (_jeu.getFantomeJ2() < 4) _jeu.setDirectionfantomeJ2(Direction.bas);
                        break;

                    case "j" : if (_jeu.getFantomeJ2() < 4) _jeu.setDirectionfantomeJ2(Direction.gauche);
                        break;
                }
            };

            root.requestFocus();

            primaryStage.setScene(new Scene(root, 1100, 800));

            primaryStage.addEventHandler(KeyEvent.KEY_TYPED, keyEventHander);

            primaryStage.setOnCloseRequest(e -> {
                Platform.exit();
                System.exit(0);
            });

            primaryStage.requestFocus();

            primaryStage.show();

            _jeu.addObserver(this);

            Thread _thread = new Thread(_jeu);

            _thread.setDaemon(false);
            _thread.start();

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void update(Observable o, Object arg) {
        _score.setText("Score : "+ _jeu.getScore());
        _life.setText("Life : "+ _jeu.getLives());
        Platform.isFxApplicationThread();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
