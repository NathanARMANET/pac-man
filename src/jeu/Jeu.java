package jeu;

import javafx.scene.Group;
import jeu.entitées.Fantome;
import jeu.entitées.Pacman;

import java.util.Observable;
import jeu.entitées.Pacman;
import jeu.entitées.Wall;
import librairie.BoardManager;
import librairie.Direction;
import librairie.Entity;


public class Jeu extends Observable implements Runnable {
    
    private Pacman _pacman;
    private Fantome _tabFantomes[];
    private BoardManager _boardManager;
    private Direction _direction;
    
    private int _fantomeJ2;
    private int _lives;
    private int _score;

    public void setDirection(Direction dir){
        _direction = dir;
    }
    
    public Pacman getPacman() {
        return _pacman;
    }

    public void setPacman(Pacman pacman) {
        this._pacman = pacman;
    }

    public Fantome getFantomes(int indice) {
        return _tabFantomes[indice];
    }

    public void setFantomes(int indice, Fantome fantome) {
        this._tabFantomes[indice] = fantome;
    }

    public int getFantomeJ2() {
        return _fantomeJ2;
    }

    public void setFantomeJ2(int fantomeJ2) {
        this._fantomeJ2 = fantomeJ2;
    }

    public int getLives() {
        return _lives;
    }

    public void setLives(int lives) {
        this._lives = lives;
    }

    public int getScore() {
        return _score;
    }

    public void setScore(int score) {
        this._score = score;
    }
    
    public Jeu(){
        _direction = Direction.immobile;
        _pacman = new Pacman(60, 60, 20, 20, 1);
        
        _boardManager = new BoardManager();
        _boardManager.addMovableEntity(_pacman.getEntity());
        
        _pacman.setBoardManager(_boardManager);
    }
    
    @Override
    public void run() {
        
        while(true){
            // enregistre le temps au début
            long startTime = System.currentTimeMillis();
            // réalise tout les calculs et les affichages
            _pacman.changeDirection(_direction);
            _pacman.deplacer();
            
            // calcule le temps écoulé depuis le début
            long elapsedTime = System.currentTimeMillis() - startTime;
            // calcule le temps restant pour avoir un affichage 60 image par seconde
            long remainingTime = (1000 / 60) - elapsedTime;
            if (remainingTime > 0) {
                try {
                    Thread.sleep(remainingTime);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            
        }

    }

    public void initGrille(Group root) {
        int [][] g = new int[][]{
                {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8},
                {8, 2, 1, 1, 1, 8, 8, 1, 1, 1, 1, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 8, 1, 1, 1, 1, 1, 1, 1, 2, 8},
                {8, 1, 8, 8, 1, 8, 8, 1, 8, 8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 1, 8, 8, 8, 1, 8},
                {8, 1, 8, 8, 1, 1, 1, 1, 8, 8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 1, 8, 8, 8, 1, 8},
                {8, 1, 8, 8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 1, 8, 8, 8, 1, 8},
                {8, 1, 8, 8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 1, 8, 8, 8, 1, 8},
                {8, 1, 8, 8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 8},
                {8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 1, 8, 8, 8, 8, 8, 0, 8, 8, 8, 8, 8, 8, 8, 8, 1, 8, 8, 8, 1, 8},
                {8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 1, 8, 8, 8, 8, 8, 0, 8, 8, 8, 8, 8, 8, 8, 8, 1, 8, 8, 8, 1, 8},
                {8, 1, 8, 8, 1, 1, 1, 1, 8, 8, 1, 8, 8, 0, 0, 0, 0, 0, 0, 0, 8, 8, 1, 1, 1, 1, 8, 8, 8, 1, 8},
                {8, 1, 8, 8, 1, 8, 8, 1, 8, 8, 1, 8, 8, 0, 8, 8, 8, 8, 8, 0, 8, 8, 1, 8, 8, 1, 8, 8, 8, 1, 8},
                {8, 1, 8, 8, 1, 8, 8, 1, 8, 8, 1, 8, 8, 0, 8, 8, 0, 0, 8, 0, 8, 8, 1, 8, 8, 1, 8, 8, 8, 1, 8},
                {8, 1, 1, 1, 1, 8, 8, 1, 1, 1, 1, 8, 8, 0, 8, 8, 0, 0, 8, 0, 8, 1, 1, 8, 8, 1, 1, 1, 1, 1, 8},
                {8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 8, 0, 8, 8, 0, 0, 0, 0, 1, 1, 8, 8, 8, 1, 8, 8, 8, 8, 8},
                {8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 8, 0, 8, 8, 0, 0, 0, 0, 1, 1, 8, 8, 8, 1, 8, 8, 8, 8, 8},
                {8, 1, 1, 1, 1, 8, 8, 1, 1, 1, 1, 8, 8, 0, 8, 8, 0, 0, 8, 0, 8, 1, 1, 8, 8, 1, 1, 1, 1, 1, 8},
                {8, 1, 8, 8, 1, 8, 8, 1, 8, 8, 1, 8, 8, 0, 8, 8, 0, 0, 8, 0, 8, 8, 1, 8, 8, 1, 8, 8, 8, 1, 8},
                {8, 1, 8, 8, 1, 8, 8, 1, 8, 8, 1, 8, 8, 0, 8, 8, 8, 8, 8, 0, 8, 8, 1, 8, 8, 1, 8, 8, 8, 1, 8},
                {8, 1, 8, 8, 1, 1, 1, 1, 8, 8, 1, 8, 8, 0, 0, 0, 0, 0, 0, 0, 8, 8, 1, 1, 1, 1, 8, 8, 8, 1, 8},
                {8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 1, 8, 8, 8, 8, 8, 0, 8, 8, 8, 8, 8, 8, 8, 8, 1, 8, 8, 8, 1, 8},
                {8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 1, 8, 8, 8, 8, 8, 0, 8, 8, 8, 8, 8, 8, 8, 8, 1, 8, 8, 8, 1, 8},
                {8, 1, 8, 8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 8},
                {8, 1, 8, 8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 1, 8, 8, 8, 1, 8},
                {8, 1, 8, 8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 1, 8, 8, 8, 1, 8},
                {8, 1, 8, 8, 1, 1, 1, 1, 8, 8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 1, 8, 8, 8, 1, 8},
                {8, 1, 8, 8, 1, 8, 8, 1, 8, 8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 1, 8, 8, 8, 1, 8},
                {8, 2, 1, 1, 1, 8, 8, 1, 1, 1, 1, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 8, 1, 1, 1, 1, 1, 1, 1, 2, 8},
                {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8}
        };


        Wall w;

        for (int i=0; i< 28; i++) {
            for (int j=0 ; j < 31 ; j++) {
                switch (g[i][j]) {
                    case 8 :
                        w = new Wall(40+20*j, 40+20*i, 20, 20);
                        _boardManager.addEntity(w.getEntity());
                        root.getChildren().add(w);
                        break;

                    default: break;

                }
            }
        }
    }
}
