package sample;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Arrays;
import java.util.Observable;
import java.util.Vector;

public class Grille {
    public int[][] grille;
    public static final int LARGEUR = 28;
    public static final int HAUTEUR = 31;

    public Grille() {
        this.grille = new int[][]{
                {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8},
                {8, 1, 1, 1, 1, 8, 8, 1, 1, 1, 1, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 8, 1, 1, 1, 1, 1, 1, 1, 1, 8},
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
                {8, 1, 1, 1, 1, 8, 8, 1, 1, 1, 1, 8, 8, 0, 8, 8, 0, 0, 8, 0, 1, 1, 1, 8, 8, 1, 1, 1, 1, 1, 8},
                {8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 8, 0, 8, 8, 0, 0, 0, 0, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 8},
                {8, 1, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 8, 0, 8, 8, 0, 0, 0, 0, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 8},
                {8, 1, 1, 1, 1, 8, 8, 1, 1, 1, 1, 8, 8, 0, 8, 8, 0, 0, 8, 0, 1, 1, 1, 8, 8, 1, 1, 1, 1, 1, 8},
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
                {8, 1, 1, 1, 1, 8, 8, 1, 1, 1, 1, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 8, 1, 1, 1, 1, 1, 1, 1, 1, 8},
                {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8}
        };
    }

    @Override
    public String toString() {
        String txt = "-------------------------------------------------------------------------------\n\n";
        for (int i = 0 ; i < LARGEUR ; i++) {
            for (int j = 0 ; j < HAUTEUR ; j++) {
                switch (grille[i][j]) {
                    case 0 : txt += "|   "; // case vide
                        break;

                    case 1 : txt += "| * "; //pac gomme
                        break;

                    case 2 : txt += "| § "; // super pac gomme
                        break;

                    case 3 : txt += "| X "; // pac-man
                        break;

                    case 4 : txt += "| O "; // fantomeRouge
                        break;


                    case 8 : txt += "||||"; // mur
                        break;

                    default: break;
                }
            }
            txt += "\n";
        }
        txt += "\n";

        return txt;
    }

    public void affichage(Rectangle[][] tabRect) {
        Color color;

        for (int i = 0 ; i < LARGEUR ; i++) {
            for (int j = 0 ; j < HAUTEUR ; j++) {
                switch (grille[i][j]) {
                    case 0:
                        color = Color.grayRgb(204);
                        break;

                    case 1 :
                        color = Color.WHITE; //pac gomme
                        break;

                    case 2 :
                        color = Color.GREEN; // super pac gomme
                        break;

                    case 3 :
                        color = Color.YELLOW; // pac-man
                        break;

                    case 4 :
                        color = Color.RED; // fantomeRouge
                        break;

                    case 5 :
                        color = Color.BLUE; // fantomeRouge
                        break;

                    case 6 :
                        color = Color.PINK;
                        break;

                    case 7 :
                        color = Color.GREEN;
                        break;

                    case 8:
                        color = Color.BLACK; // mur
                        break;

                    default:
                        color = Color.BLACK;
                        break;
                }

                tabRect[i][j].setFill(color);
            }
        }
    }
}
