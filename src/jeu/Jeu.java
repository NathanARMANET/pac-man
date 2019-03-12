package jeu;

import jeu.entitées.Fantome;
import jeu.entitées.Pacman;

import java.util.Observable;
import jeu.entitées.Pacman;
import librairie.BoardManager;

public class Jeu extends Observable implements Runnable {
    
    private Pacman _pacman;
    private Fantome _tabFantomes[];
    private BoardManager _boardManager;
    
    private int fantomeJ2;
    private int _lives;

    public Jeu(){
        _pacman = new Pacman(50, 50, 40, 40, 3);
        
        _boardManager = new BoardManager();
        _boardManager.addMovableEntity(_pacman.getEntity());
    }
    
    @Override
    public void run() {
        
        _pacman.deplacer();
        _boardManager.checkAllCollision();
        try {
            Thread.sleep(40);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }


    }
}
