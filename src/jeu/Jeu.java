package jeu;

import jeu.entitees.Fantome;
import jeu.entitees.Pacman;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import java.util.Observable;
import librairie.BoardManager;
import librairie.Direction;

public class Jeu extends Observable implements Runnable {

    private Pacman _pacman;
    private ArrayList<Fantome> _tabFantomes;
    private Direction _directionPacman;
    private Direction _directionFantomeJ2;
    BoardManager _boardManager;
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
                    Thread.sleep(16);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        }
    }
}
