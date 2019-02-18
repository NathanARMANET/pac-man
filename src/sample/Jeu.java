package sample;

import java.util.Observable;

public class Jeu extends Observable implements Runnable{

    public Grille grid;
    public Entitee pacman;
    public Entitee[] fantomes;
    public int score;
    public int life = 3;

    public Jeu() {
        grid = new Grille();
        pacman = new Entitee(13, 7, 3, false);
        pacman.d = Direction.immobile;
        grid.grille[13][7] = pacman.value;

        fantomes = new Entitee[4];
        for (int i = 0 ; i < 4 ; i++) {
            fantomes[i] = new Entitee(12+i, 16, 4+i, true);
            grid.grille[12+i][16] = fantomes[i].value;
        }
        score = 0;

    }

    public String getState() {
        return grid.toString();
    }

    @Override
    public void run() {
        try {
            while (life>0) {
                pacman.deplacer(this);
                setChanged();
                notifyObservers();
                Thread.sleep(500);
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
