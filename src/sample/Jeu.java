package sample;

import java.util.Observable;

public class Jeu extends Observable implements Runnable{

    public Grille grid;
    public Entitee pacman;
    public Fantome[] fantomes;
    public int fantomeJ2;
    public int score;
    public int life = 3;

    public Jeu() {
        grid = new Grille();
        pacman = new Entitee(13, 7, 3, false);
        pacman.d = Direction.immobile;
        grid.grille[13][7] = pacman.value;

        fantomes = new Fantome[4];
        for (int i = 0 ; i < 4 ; i++) {
            fantomes[i] = new Fantome(12+i, 16, 4+i, true);
            grid.grille[12+i][16] = fantomes[i].value;
            fantomes[i].d = Direction.immobile;
        }

        fantomes[1].d = Direction.droite;
        fantomes[2].d = Direction.droite;
        score = 0;
        fantomeJ2 = 4;
    }

    public String getState() {
        return grid.toString();
    }

    @Override
    public void run() {
        try {
            while (life>0) {
                for (int i = 0 ; i < 4 ; i++) {
                    if (i != fantomeJ2) {
                        fantomes[i].deplacerAlea(this);
                    }
                }
                if (fantomeJ2 < 4) {
                    fantomes[fantomeJ2].deplacer(this);
                }
                setChanged();
                notifyObservers();
                Thread.sleep(500);
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
