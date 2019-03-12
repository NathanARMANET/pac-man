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
    
    private int _fantomeJ2;
    private int _lives;
    private int _score;

    public Pacman get_pacman() {
        return _pacman;
    }

    public void set_pacman(Pacman pacman) {
        this._pacman = pacman;
    }

    public Fantome get_fantomes(int indice) {
        return _tabFantomes[indice];
    }

    public void set_fantomes(int indice, Fantome fantome) {
        this._tabFantomes[indice] = fantome;
    }

    public int get_fantomeJ2() {
        return _fantomeJ2;
    }

    public void set_fantomeJ2(int fantomeJ2) {
        this._fantomeJ2 = fantomeJ2;
    }

    public int get_lives() {
        return _lives;
    }

    public void set_lives(int lives) {
        this._lives = lives;
    }

    public int get_score() {
        return _score;
    }

    public void set_score(int score) {
        this._score = score;
    }

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
