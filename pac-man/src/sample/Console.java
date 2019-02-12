package sample;

import java.util.Observable;
import java.util.Observer;

public class Console implements Observer {

    private static Jeu game;

    public Console(Jeu j) {
        game = j;

    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Score = "+game.score);
        System.out.print(game.getState());
    }

    public static void main(String[] args) {
        Jeu j = new Jeu();
        Console c = new Console(j);

        j.addObserver(c);

        new Thread(j).start();

        try {
            while (true) {
                Thread.sleep(2000);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
