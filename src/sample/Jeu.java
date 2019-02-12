package sample;

import java.util.Observable;

public class Jeu extends Observable implements Runnable{

    public Grille grid;
    public Entitee pacman;
    public Entitee fantome;
    public int score;

    public Jeu() {
        grid = new Grille();
        pacman = new Entitee(1, 1, 3, false);
        grid.grille[1][1] = pacman.value;
        //fantome = new Entitee(3, 1, 4, true);
        score = 0;
    }

    public String getState() {
        return grid.toString();
    }

    @Override
    public void run() {
        try {
            while (true) {
                pacman.deplacer(this);
                fantome.deplacer(this);
                setChanged();
                notifyObservers();
                Thread.sleep(1000);
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
