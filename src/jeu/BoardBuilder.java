/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javafx.scene.Group;
import jeu.entitees.Fantome;
import jeu.entitees.Pacgomme;
import jeu.entitees.Pacman;
import jeu.entitees.SuperPacgomme;
import jeu.entitees.Wall;
import librairie.BoardManager;

/**
 *
 * @author thiti
 */
public class BoardBuilder {
    
    private double _minX;
    private double _minY;
    private double _normalSize;
    private String _boardPath;
    private BoardManager _boardManager;
    private Pacman _pacman;
    private ArrayList<Fantome> _fantomes = new ArrayList<>();
    private int _score;
    private int _index;
    private ArrayList<String> _lecture = new ArrayList<>();
    private Group _root;
            
    
    public String getBoardPath(){
        return _boardPath;
    }
    
    public void setBoardPath(String path){
        _boardPath = path;
    }
    
    public Pacman getPacman(){
        return _pacman;
    }
    
    public ArrayList<Fantome> getFantomes(){
        return _fantomes;
    }
    
    public BoardManager getBoardManager(){
        return _boardManager;
    }
    
    public int getScore(){
        return _score;
    }
    
    public BoardBuilder(double minX, double minY, double normalSize, Group root){
        _minX = minX;
        _minY = minY;
        _normalSize = normalSize;
        _root = root;
    }
    
    public void build(){
        lectureFichier();
        _boardManager = new BoardManager();
        _index = 0;
        buildWall();
        buildEntities();
    }
    
    private void buildWall(){
        while (_index < _lecture.size()) {
            if (_lecture.get(_index).length() == 0){
                _index++;
                break;
            }    
            for (int j = 0; j < _lecture.get(_index).length(); j++) {
                switch (_lecture.get(_index).charAt(j)){
                    case '1':
                        Wall w = new Wall(_minX+_normalSize*j, _minY+_normalSize*_index, _normalSize, _normalSize);
                        _boardManager.addEntity(w.getEntity());
                        _root.getChildren().add(w);
                        break;
                    case '0':
                        _score += 10;
                        Pacgomme pacgomme = new Pacgomme(_minX + _normalSize * j + _normalSize / 2 ,
                                _minY+_normalSize*_index + _normalSize / 2, 3);
                        _boardManager.addEntity(pacgomme.getEntity());
                        _root.getChildren().add(pacgomme);
                        break;
                    case 'x':
                        _score += 20;
                        SuperPacgomme spg=new SuperPacgomme(_minX + _normalSize * j + _normalSize / 2 ,
                                _minY+_normalSize*_index + _normalSize / 2, 6);
                        _boardManager.addEntity(spg.getEntity());
                        _root.getChildren().add(spg);
                        break;
                    
                    default: break;       
                }
            }
            _index++;    
        }
    }
    
    private void buildEntities(){
        String[] coord = _lecture.get(_index).split(",");
        int x = Integer.valueOf(coord[0]);
        int y = Integer.valueOf(coord[1]);
        _pacman = new Pacman(_minX+_normalSize*x, _minY+_normalSize*y, _normalSize, _normalSize, 2);
        _pacman.setBoardManager(_boardManager);
        _boardManager.addMovableEntity(_pacman.getEntity());
        _root.getChildren().add(_pacman);
        
        _index += 2;
        
        while (_index < _lecture.size()){
            if (_lecture.get(_index).length() == 0){
                _index++;
                break;
            }
            coord = _lecture.get(_index).split(",");
            x = Integer.valueOf(coord[0]);
            y = Integer.valueOf(coord[1]);
            Fantome fantome = new Fantome(_minX+_normalSize*x, _minY+_normalSize*y, _normalSize, _normalSize, 2);
            _fantomes.add(fantome);
            fantome.setBoardManager(_boardManager);
            _boardManager.addMovableEntity(fantome.getEntity());
            _root.getChildren().add(fantome);
            _index++;    
        }
    }
    
    private void lectureFichier(){
        try{
            InputStream flux=new FileInputStream(_boardPath); 
            InputStreamReader lecture=new InputStreamReader(flux);
            BufferedReader buff=new BufferedReader(lecture);
            String ligne;
            while ((ligne=buff.readLine())!=null){
                    _lecture.add(ligne);
            }
            buff.close(); 
        }		
        catch (Exception e){
            System.out.println(e.toString());
        }
    }
    
}
