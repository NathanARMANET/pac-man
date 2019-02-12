package sample;

import java.util.Observable;

public class Jeu extends Observable implements Runnable{

    public Grille grid;
    public Entitee pacman;
    public Entitee fantome;
    public int score;
    public int life = 3;

    public Jeu() {
        grid = new Grille();
        pacman = new Entitee(1, 1, 3, false);
        pacman.d = Direction.bas;
        grid.grille[1][1] = pacman.value;
        fantome = new Entitee(5, 1, 4, true);
        score = 0;
    }

    public String getState() {
        return grid.toString();
    }

    @Override
    public void run() {
        fantome.d = Direction.bas;
        fantome.deplacer(this);
        fantome.d = Direction.immobile;
        try {
            while (life>0) {
                pacman.deplacer(this);
                setChanged();
                notifyObservers();
                Thread.sleep(1000);
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
