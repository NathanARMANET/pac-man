package jeu;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import jeu.entitées.*;
import java.util.Observable;
import librairie.BoardManager;
import librairie.Direction;

public class Jeu extends Observable implements Runnable {

    private Pacman _pacman;
    private Fantome[] _tabFantomes;
    private Direction _directionPacman;
    private Direction _directionFantomeJ2;
=======
    private Fantome[] _tabFantomes;
    private Direction _directionPacman;
    private Direction _directionFantomeJ2;
>>>>>>> 88fcd1867b4d6b3c01526b6b442826154f561216
    private int _fantomeJ2;
    private int _lives;
    private int _score;
    private int _scoreTotal;

    public void setDirectionPacman(Direction dir){
        _directionPacman = dir;
    }

    public void setDirectionfantomeJ2(Direction dir){
        _directionFantomeJ2 = dir;
    }

    public Pacman getPacman() {
        return _pacman;
    }

    public void setPacman(Pacman pacman) {
        this._pacman = pacman;
    }

    public Fantome getFantomes(int indice) {
        return _tabFantomes.get(indice);
    }

    public void setFantomes(int indice, Fantome fantome) {
        this._tabFantomes.set(indice, fantome);
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

=======
>>>>>>> 88fcd1867b4d6b3c01526b6b442826154f561216
    public Jeu(Group root){

        _lives = 3;
        _score = 0;
        _scoreTotal = 0;
        _fantomeJ2 = -1;

        int [][] g = new int[][]{
                {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8},
                {8, 2, 1, 1, 1, 8, 8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 8},
                {8, 1, 8, 8, 1, 8, 8, 1, 8, 8, 1, 8, 8, 8, 8, 1, 8, 8, 8, 8, 1, 8, 8, 1, 8, 8, 8, 1, 8},
                {8, 1, 8, 8, 1, 1, 1, 1, 8, 8, 1, 8, 8, 8, 8, 1, 8, 8, 8, 8, 1, 8, 8, 1, 8, 8, 8, 1, 8},
                {8, 1, 8, 8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 1, 8, 8, 8, 8, 1, 8, 8, 1, 8, 8, 8, 1, 8},
                {8, 1, 8, 8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 1, 8, 8, 8, 8, 1, 8, 8, 1, 8, 8, 8, 1, 8},
                {8, 1, 8, 8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 8},
                {8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 1, 8, 8, 8, 8, 0, 8, 8, 8, 8, 8, 8, 8, 1, 8, 8, 8, 1, 8},
                {8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 1, 8, 8, 8, 8, 0, 8, 8, 8, 8, 8, 8, 8, 1, 8, 8, 8, 1, 8},
                {8, 1, 8, 8, 1, 1, 1, 1, 8, 8, 1, 8, 8, 0, 0, 0, 0, 0, 8, 8, 1, 1, 1, 1, 8, 8, 8, 1, 8},
                {8, 1, 8, 8, 1, 8, 8, 1, 8, 8, 1, 8, 8, 0, 8, 8, 8, 0, 8, 8, 1, 8, 8, 1, 8, 8, 8, 1, 8},
                {8, 1, 1, 1, 1, 8, 8, 1, 1, 1, 1, 8, 8, 0, 8, 4, 0, 0, 0, 1, 1, 8, 8, 1, 1, 1, 1, 1, 8},
=======
                {8, 1, 8, 8, 1, 8, 8, 1, 8, 8, 1, 8, 8, 0, 8, 8, 8, 0, 8, 8, 1, 8, 8, 1, 8, 8, 8, 1, 8},
                {8, 1, 1, 1, 1, 8, 8, 1, 1, 1, 1, 8, 8, 0, 8, 4, 0, 0, 0, 1, 1, 8, 8, 1, 1, 1, 1, 1, 8},
>>>>>>> 88fcd1867b4d6b3c01526b6b442826154f561216
                {8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 8, 0, 8, 5, 0, 0, 0, 1, 8, 8, 8, 1, 8, 8, 8, 8, 8},
                {8, 1, 8, 8, 8, 8, 8, 3, 8, 8, 8, 8, 8, 0, 8, 6, 0, 0, 0, 1, 8, 8, 8, 1, 8, 8, 8, 8, 8},
                {8, 1, 1, 1, 1, 8, 8, 1, 1, 1, 1, 8, 8, 0, 8, 7, 0, 0, 0, 1, 1, 8, 8, 1, 1, 1, 1, 1, 8},
                {8, 1, 8, 8, 1, 8, 8, 1, 8, 8, 1, 8, 8, 0, 8, 8, 8, 0, 8, 8, 1, 8, 8, 1, 8, 8, 8, 1, 8},
                {8, 1, 8, 8, 1, 1, 1, 1, 8, 8, 1, 8, 8, 0, 0, 0, 0, 0, 8, 8, 1, 1, 1, 1, 8, 8, 8, 1, 8},
                {8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 1, 8, 8, 8, 8, 0, 8, 8, 8, 8, 8, 8, 8, 1, 8, 8, 8, 1, 8},
                {8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 1, 8, 8, 8, 8, 0, 8, 8, 8, 8, 8, 8, 8, 1, 8, 8, 8, 1, 8},
                {8, 1, 8, 8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 8},
                {8, 1, 8, 8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 1, 8, 8, 8, 8, 1, 8, 8, 1, 8, 8, 8, 1, 8},
                {8, 1, 8, 8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 1, 8, 8, 8, 8, 1, 8, 8, 1, 8, 8, 8, 1, 8},
                {8, 1, 8, 8, 1, 1, 1, 1, 8, 8, 1, 8, 8, 8, 8, 1, 8, 8, 8, 8, 1, 8, 8, 1, 8, 8, 8, 1, 8},
                {8, 1, 8, 8, 1, 8, 8, 1, 8, 8, 1, 8, 8, 8, 8, 1, 8, 8, 8, 8, 1, 8, 8, 1, 8, 8, 8, 1, 8},
                {8, 2, 1, 1, 1, 8, 8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 8},
                {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8}
        };

=======
        BoardManager boardManager = new BoardManager();
        _tabFantomes = new Fantome[4];
>>>>>>> ac7d6a0863a92a732a18e738dcbfd22c1f392fa6
        Wall w;
        Pacgomme pg;
        SuperPacgomme spg;

        for (int i=0; i< 26; i++) {
            for (int j=0 ; j < 29 ; j++) {
                switch (g[i][j]) {

                    case 1 :
                        _scoreTotal += 10;
<<<<<<< HEAD
                        pg = new Pacgomme((20+25*(2*(float)j+1))/2, (80+25*(2*(float)i+1))/2, 5);
=======
                        pg = new Pacgomme((20+25*(2*(float)j+1))/2, (80+25*(2*(float)i+1))/2, 2);
                        boardManager.addEntity(pg.getEntity());
                        root.getChildren().add(pg);
                        break;
>>>>>>> ac7d6a0863a92a732a18e738dcbfd22c1f392fa6

                    case 2 :
                        _scoreTotal += 20;
                        spg=new SuperPacgomme((20+25*(2*(float)j+1))/2, (80+25*(2*(float)i+1))/2, 4);
                        boardManager.addEntity(spg.getEntity());
                        root.getChildren().add(spg);
                        break;

                    case 3 :
                        _pacman = new Pacman(10+25*j, 40+25*i, 25, 25, 1);
                        _pacman.setBoardManager(boardManager);
                        boardManager.addMovableEntity(_pacman.getEntity());
                        root.getChildren().add(_pacman);
                        break;


                    case 4 :
                        _tabFantomes[0] = new Fantome(10+25*j, 40+25*i, 25, 25, 1, Color.RED);
=======

                    case 4 :
                        _tabFantomes[0] = new Fantome(10+25*j, 40+25*i, 25, 25, 1, "rouge");
                        _tabFantomes[0].setBoardManager(boardManager);
                        boardManager.addMovableEntity(_tabFantomes[0].getEntity());
                        root.getChildren().add(_tabFantomes[0]);
                        break;

                    case 5 :
                        _tabFantomes[1] = new Fantome(10+25*j, 40+25*i, 25, 25, 1, "bleu");
                        _tabFantomes[1].setBoardManager(boardManager);
                        boardManager.addMovableEntity(_tabFantomes[1].getEntity());
                        root.getChildren().add(_tabFantomes[1]);
                        break;


                    case 6 :
                        _tabFantomes[2] = new Fantome(10+25*j, 40+25*i, 25, 25, 1, "rose");
                        _tabFantomes[2].setBoardManager(boardManager);
                        boardManager.addMovableEntity(_tabFantomes[2].getEntity());
                        root.getChildren().add(_tabFantomes[2]);
                        break;

                    case 7 :
                        _tabFantomes[3] = new Fantome(10+25*j, 40+25*i, 25, 25, 1, "orange");
                        _tabFantomes[3].setBoardManager(boardManager);
                        boardManager.addMovableEntity(_tabFantomes[3].getEntity());
                        root.getChildren().add(_tabFantomes[3]);
                        break;

                    case 8 :
                        w = new Wall(10+25*j, 40+25*i, 25, 25);
                        boardManager.addEntity(w.getEntity());
                        root.getChildren().add(w);
                        break;

                    default: break;

                }
            }
        }
    }

    @Override
    public void run() {
        while(_lives > 0 && _score < _scoreTotal) {
            // enregistre le temps au début
            long startTime = System.currentTimeMillis();
            // réalise tout les calculs et les affichages

=======
            for (int i = 0; i < 4; i++) {
                if (i == _fantomeJ2) {
                    _tabFantomes[i].changeDirection(_directionFantomeJ2);
                    _tabFantomes[i].deplacer();
                }else {
                    _tabFantomes[i].deplacerRandom();
                }
            }

            _pacman.changeDirection(_directionPacman);
            _pacman.deplacer(this);

            setChanged();
            notifyObservers();

            // calcule le temps écoulé depuis le début
            long elapsedTime = System.currentTimeMillis() - startTime;
            // calcule le temps restant pour avoir un affichage 60 image par seconde
            long remainingTime = (1000 / 120) - elapsedTime;
            if (remainingTime > 0) {
                try {
                    Thread.sleep(remainingTime);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        }
    }
}
