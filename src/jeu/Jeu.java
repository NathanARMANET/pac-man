package jeu;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import jeu.entitées.*;

import java.util.Observable;

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

    public Pacman getPacman(){
        return _pacman;
    }
    
    public Jeu(Group root){

        _lives = 3;
        _score = 0;

        _tabFantomes = new Fantome[4];

        int [][] g = new int[][]{
                {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8},
                {8, 2, 1, 1, 1, 8, 8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 8},
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
                {8, 1, 1, 1, 1, 8, 8, 1, 1, 1, 1, 8, 8, 0, 8, 8, 4, 0, 8, 0, 8, 1, 1, 8, 8, 1, 1, 1, 1, 1, 8},
                {8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 8, 0, 8, 8, 5, 0, 0, 0, 1, 1, 8, 8, 8, 1, 8, 8, 8, 8, 8},
                {8, 1, 8, 8, 8, 8, 8, 3, 8, 8, 8, 8, 8, 0, 8, 8, 6, 0, 0, 0, 1, 1, 8, 8, 8, 1, 8, 8, 8, 8, 8},
                {8, 1, 1, 1, 1, 8, 8, 1, 1, 1, 1, 8, 8, 0, 8, 8, 7, 0, 8, 0, 8, 1, 1, 8, 8, 1, 1, 1, 1, 1, 8},
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
                {8, 2, 1, 1, 1, 8, 8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 8},
                {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8}
        };

        _boardManager = new BoardManager();

        Wall w;
        Pacgomme pg;
        SuperPacgomme spg;

        for (int i=0; i< 28; i++) {
            for (int j=0 ; j < 31 ; j++) {
                switch (g[i][j]) {
                    case 8 :
                        w = new Wall(10+30*j, 40+30*i, 30, 30);
                        _boardManager.addEntity(w.getEntity());
                        root.getChildren().add(w);
                        break;

                    case 1 :
                        pg = new Pacgomme((20+30*(2*j+1))/2, (80+30*(2*i+1))/2, 5);
                        _boardManager.addEntity(pg.getEntity());
                        root.getChildren().add(pg);
                        break;

                    case 2 :
                        spg=new SuperPacgomme((20+30*(2*j+1))/2, (80+30*(2*i+1))/2, 10);
                        _boardManager.addEntity(spg.getEntity());
                        root.getChildren().add(spg);
                        break;

                    case 3 :
                        _pacman = new Pacman(10+30*j, 40+30*i, 20, 20, 3);
                        _boardManager.addMovableEntity(_pacman.getEntity());
                        root.getChildren().add(_pacman);
                        break;

                    case 4 :
                        _tabFantomes[0] = new Fantome(10+30*j, 40+30*i, 20, 20, 3, Color.RED);
                        _boardManager.addMovableEntity(_tabFantomes[0].getEntity());
                        root.getChildren().add(_tabFantomes[0]);
                        break;

                    case 5 :
                        _tabFantomes[1] = new Fantome(10+30*j, 40+30*i, 20, 20, 3, Color.BLUE);
                        _boardManager.addMovableEntity(_tabFantomes[1].getEntity());
                        root.getChildren().add(_tabFantomes[1]);
                        break;

                    case 6 :
                        _tabFantomes[2] = new Fantome(10+30*j, 40+30*i, 20, 20, 3, Color.PINK);
                        _boardManager.addMovableEntity(_tabFantomes[2].getEntity());
                        root.getChildren().add(_tabFantomes[2]);
                        break;

                    case 7 :
                        _tabFantomes[3] = new Fantome(10+30*j, 40+30*i, 20, 20, 3, Color.GREEN);
                        _boardManager.addMovableEntity(_tabFantomes[3].getEntity());
                        root.getChildren().add(_tabFantomes[3]);
                        break;

                    default: break;

                }
            }
        }


    }
    
    @Override
    public void run() {
        
        while(true){
            for (Fantome f : _tabFantomes) f.deplacer();
            _pacman.deplacer();
            _boardManager.checkAllCollision(this);
            setChanged();
            notifyObservers();
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

    }
}
