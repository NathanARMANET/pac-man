package jeu;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Menu extends Application {

    /**
     * Ouvre et gère le menu
     * @param primaryStage la fenètre
     */
    @Override
    public void start(Stage primaryStage) {
        try {
            primaryStage.setTitle("Pac Man");

            Group root = new Group();

            Text title = new Text();
            title.setText("Menu Pac-man");
            title.setX(50);
            title.setY(40);

            root.getChildren().add(title);

            Button replay = new Button("Jouer");
            replay.setLayoutX(50);
            replay.setLayoutY(100);
            replay.setOnAction(event -> {
                primaryStage.close();
                Platform.runLater( () -> new Main().start( new Stage() ) );
            });
            root.getChildren().add(replay);

            Button quit = new Button("Quitter");
            quit.setLayoutX(50);
            quit.setLayoutY(150);
            quit.setOnAction(event -> {

                Platform.exit();
                System.exit(0);
            });
            root.getChildren().add(quit);

            root.requestFocus();

            primaryStage.setScene(new Scene(root, 200, 200));

            primaryStage.setOnCloseRequest(e -> {
                Platform.exit();
                System.exit(0);
            });

            primaryStage.requestFocus();

            primaryStage.show();

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
