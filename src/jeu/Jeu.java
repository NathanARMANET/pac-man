package jeu;

import jeu.entitées.Fantome;
import jeu.entitées.Pacman;

import java.util.Observable;

public class Jeu extends Observable implements Runnable {
    private Pacman _pacman;
    private Fantome _tabFantomes[];
    private int fantomeJ2;
    private int _lives;

    @Override
    public void run() {

    }
}
