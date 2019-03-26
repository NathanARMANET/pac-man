package jeu;

import jeu.entitees.Fantome;
import jeu.entitees.Pacman;
import java.util.ArrayList;
import javafx.scene.Group;
import java.util.Observable;
import librairie.BoardManager;
import librairie.Direction;

public class Jeu extends Observable implements Runnable {

    private Pacman _pacman;
    private ArrayList<Fantome> _tabFantomes;
    private Direction _directionPacman;
    private Direction _directionFantomeJ2;
    public BoardManager _boardManager;
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

    public Jeu(Group root){

        BoardBuilder bb = new BoardBuilder(20, 20, 30,root);
        bb.setBoardPath("./mapTest.txt");
        bb.build();
        _boardManager = bb.getBoardManager();
        _pacman = bb.getPacman();
        _tabFantomes = bb.getFantomes();
        _lives = 3;
        _score = 0;
        _scoreTotal = bb.getScore();
        _fantomeJ2 = -1;

//        int [][] g = new int[][]{
//                {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8},
//                {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8},
//                {8, 8, 2, 1, 1, 1, 8, 8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 8, 8},
//                {8, 8, 1, 8, 8, 1, 8, 8, 1, 8, 8, 1, 8, 8, 8, 8, 1, 8, 8, 8, 8, 1, 8, 8, 1, 8, 8, 8, 1, 8, 8},
//                {8, 8, 1, 8, 8, 1, 1, 1, 1, 8, 8, 1, 8, 8, 8, 8, 1, 8, 8, 8, 8, 1, 8, 8, 1, 8, 8, 8, 1, 8, 8},
//                {8, 8, 1, 8, 8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 1, 8, 8, 8, 8, 1, 8, 8, 1, 8, 8, 8, 1, 8, 8},
//                {8, 8, 1, 8, 8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 1, 8, 8, 8, 8, 1, 8, 8, 1, 8, 8, 8, 1, 8, 8},
//                {8, 8, 1, 8, 8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 8, 8},
//                {8, 8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 1, 8, 8, 8, 8, 0, 8, 8, 8, 8, 8, 8, 8, 1, 8, 8, 8, 1, 8, 8},
//                {8, 8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 1, 8, 8, 8, 8, 0, 8, 8, 8, 8, 8, 8, 8, 1, 8, 8, 8, 1, 8, 8},
//                {8, 8, 1, 8, 8, 1, 1, 1, 1, 8, 8, 1, 8, 8, 0, 0, 0, 0, 0, 8, 8, 1, 1, 1, 1, 8, 8, 8, 1, 8, 8},
//                {8, 8, 1, 8, 8, 1, 8, 8, 1, 8, 8, 1, 8, 8, 0, 8, 8, 8, 0, 8, 8, 1, 8, 8, 1, 8, 8, 8, 1, 8, 8},
//                {8, 8, 1, 1, 1, 1, 8, 8, 1, 1, 1, 1, 8, 8, 0, 8, 4, 0, 0, 0, 1, 1, 8, 8, 1, 1, 1, 1, 1, 8, 8},
//                {8, 8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 8, 0, 8, 5, 0, 0, 0, 1, 8, 8, 8, 1, 8, 8, 8, 8, 8, 8},
//                {8, 8, 1, 8, 8, 8, 8, 8, 3, 8, 8, 8, 8, 8, 0, 8, 6, 0, 0, 0, 1, 8, 8, 8, 1, 8, 8, 8, 8, 8, 8},
//                {8, 8, 1, 1, 1, 1, 8, 8, 1, 1, 1, 1, 8, 8, 0, 8, 7, 0, 0, 0, 1, 1, 8, 8, 1, 1, 1, 1, 1, 8, 8},
//                {8, 8, 1, 8, 8, 1, 8, 8, 1, 8, 8, 1, 8, 8, 0, 8, 8, 8, 0, 8, 8, 1, 8, 8, 1, 8, 8, 8, 1, 8, 8},
//                {8, 8, 1, 8, 8, 1, 1, 1, 1, 8, 8, 1, 8, 8, 0, 0, 0, 0, 0, 8, 8, 1, 1, 1, 1, 8, 8, 8, 1, 8, 8},
//                {8, 8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 1, 8, 8, 8, 8, 0, 8, 8, 8, 8, 8, 8, 8, 1, 8, 8, 8, 1, 8, 8},
//                {8, 8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 1, 8, 8, 8, 8, 0, 8, 8, 8, 8, 8, 8, 8, 1, 8, 8, 8, 1, 8, 8},
//                {8, 8, 1, 8, 8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 8, 8},
//                {8, 8, 1, 8, 8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 1, 8, 8, 8, 8, 1, 8, 8, 1, 8, 8, 8, 1, 8, 8},
//                {8, 8, 1, 8, 8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 1, 8, 8, 8, 8, 1, 8, 8, 1, 8, 8, 8, 1, 8, 8},
//                {8, 8, 1, 8, 8, 1, 1, 1, 1, 8, 8, 1, 8, 8, 8, 8, 1, 8, 8, 8, 8, 1, 8, 8, 1, 8, 8, 8, 1, 8, 8},
//                {8, 8, 1, 8, 8, 1, 8, 8, 1, 8, 8, 1, 8, 8, 8, 8, 1, 8, 8, 8, 8, 1, 8, 8, 1, 8, 8, 8, 1, 8, 8},
//                {8, 8, 2, 1, 1, 1, 8, 8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 8, 8},
//                {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8},
//                {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8}
//        };
//
//        BoardManager boardManager = new BoardManager();
//        Wall w;
//        Pacgomme pg;
//        SuperPacgomme spg;
//
//        int nbrPacGomme;
//
//        for (int i=0; i< 28; i++) {
//            for (int j=0 ; j < 31 ; j++) {
//                switch (g[i][j]) {
//
//                    case 1 :
//                        _scoreTotal += 10;
//                        pg = new Pacgomme((20+25*(2*(float)j+1))/2, (80+25*(2*(float)i+1))/2, 2);
//                        boardManager.addEntity(pg.getEntity());
//                        root.getChildren().add(pg);
//                        break;
//
//                    case 2 :
//                        _scoreTotal += 20;
//                        spg=new SuperPacgomme((20+25*(2*(float)j+1))/2, (80+25*(2*(float)i+1))/2, 4);
//                        boardManager.addEntity(spg.getEntity());
//                        root.getChildren().add(spg);
//                        break;
//
//                    case 3 :
//                        _pacman = new Pacman(10+25*j, 40+25*i, 25, 25, 1);
//                        _pacman.setBoardManager(boardManager);
//                        boardManager.addMovableEntity(_pacman.getEntity());
//                        root.getChildren().add(_pacman);
//                        break;
//
//
//                    case 4 :
//                        _tabFantomes[0] = new Fantome(10+25*j, 40+25*i, 25, 25, 1, "rouge");
//                        _tabFantomes[0].setBoardManager(boardManager);
//                        boardManager.addMovableEntity(_tabFantomes[0].getEntity());
//                        root.getChildren().add(_tabFantomes[0]);
//                        break;
//
//                    case 5 :
//                        _tabFantomes[1] = new Fantome(10+25*j, 40+25*i, 25, 25, 1, "bleu");
//                        _tabFantomes[1].setBoardManager(boardManager);
//                        boardManager.addMovableEntity(_tabFantomes[1].getEntity());
//                        root.getChildren().add(_tabFantomes[1]);
//                        break;
//
//
//                    case 6 :
//                        _tabFantomes[2] = new Fantome(10+25*j, 40+25*i, 25, 25, 1, "rose");
//                        _tabFantomes[2].setBoardManager(boardManager);
//                        boardManager.addMovableEntity(_tabFantomes[2].getEntity());
//                        root.getChildren().add(_tabFantomes[2]);
//                        break;
//
//                    case 7 :
//                        _tabFantomes[3] = new Fantome(10+25*j, 40+25*i, 25, 25, 1, "orange");
//                        _tabFantomes[3].setBoardManager(boardManager);
//                        boardManager.addMovableEntity(_tabFantomes[3].getEntity());
//                        root.getChildren().add(_tabFantomes[3]);
//                        break;
//
//                    case 8 :
//                        w= null;
//                        if ((i == 0 && j == 0)
//                            || (i == 0 && j == 30)
//                            || (i == 27 && j == 0)
//                            || (i == 27 && j == 30))
//                            w = new Wall(10+25*j, 40+25*i, 25, 25, "coin", 0);
//                        else if (i == 0 || i == 27)
//                            w = new Wall(10+25*j, 40+25*i, 25, 25, "mur", 0);
//                        else if (j == 0 || j == 30)
//                            w = new Wall(10+25*j, 40+25*i, 25, 25, "mur", 270);
//                        else if (g[i-1][j]==8 && g[i+1][j]==8 && (g[i][j-1]!=8 || g[i][j+1]!=8))
//                            w = new Wall(10+25*j, 40+25*i, 25, 25, "mur", 270);
//                        else if (g[i][j-1]==8 && g[i][j+1]==8 && (g[i-1][j]!=8 || g[i+1][j]!=8))
//                            w = new Wall(10+25*j, 40+25*i, 25, 25, "mur", 0);
//                        else if ((g[i-1][j]==8 && g[i][j+1]==8 && g[i][j-1]!=8 && g[i+1][j]!=8)
//                                || (g[i+1][j]==8 && g[i][j+1]==8 && g[i][j-1]!=8 && g[i-1][j]!=8)
//                                || (g[i][j-1]==8 && g[i-1][j]==8 && g[i][j+1]!=8 && g[i+1][j]!=8)
//                                || (g[i][j-1]==8 && g[i+1][j]==8 && g[i][j+1]!=8 && g[i-1][j]!=8))
//                            w = new Wall(10+25*j, 40+25*i, 25, 25, "coin", 0);
//                        else {
//                            nbrPacGomme = 0;
//
//                            for (int x = -1 ; x <= 1 ; x++){
//                                for (int y = -1 ; y <= 1 ; y++) {
//                                    if (g[i+x][j+y] != 8) nbrPacGomme++;
//                                }
//                            }
//
//                            if (nbrPacGomme >= 1 && nbrPacGomme < 3) w = new Wall(10+25*j, 40+25*i, 25, 25, "coin", 0);
//                        }
//
//                        if (w != null) {
//                            boardManager.addEntity(w.getEntity());
//                            root.getChildren().add(w);
//                        }
//                        break;
//
//                    default: break;
//
//                }
//            }
//        }
    }

    @Override
    public void run() {
        while(_lives > 0 && _score < _scoreTotal) {
            // enregistre le temps au début
            long startTime = System.currentTimeMillis();
            // réalise tout les calculs et les affichagesœ
            for (int i = 0; i < _tabFantomes.size(); i++) {
                if (i == _fantomeJ2) {
                    _tabFantomes.get(i).changeDirection(_directionFantomeJ2);
                    _tabFantomes.get(i).deplacer();
                }else {
                    _tabFantomes.get(i).deplacerRandom();
                }
            }

            _pacman.changeDirection(_directionPacman);
            _pacman.deplacer(this);

            setChanged();
            notifyObservers();

            // calcule le temps écoulé depuis le début
            long elapsedTime = System.currentTimeMillis() - startTime;
            // calcule le temps restant pour avoir un affichage 60 image par seconde
            long remainingTime = (1000 / 60) - elapsedTime;
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
