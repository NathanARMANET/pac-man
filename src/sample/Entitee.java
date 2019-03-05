package sample;

public class Entitee {
    public int x, y;
    public int START_X, START_Y;
    public Direction d;
    public int etatCase;
    public boolean fantome;
    public int value;

    public Entitee(int x, int y, int value, boolean estFantome) {
        this.x = x;
        this.y = y;
        this.START_X = x;
        this.START_Y = y;
        this.d = Direction.immobile;
        this.etatCase = 0;
        this.fantome = estFantome;
        this.value = value;
    }

    public void deplacer(Jeu j) {

        if (d != Direction.immobile) {
            int tmp;
            int cols = Grille.LARGEUR;
            int rows = Grille.HAUTEUR;

            if ((d.equals(Direction.haut) && (x-1 >= 0) && j.grid.grille[x-1][y] != 8)) {
                if (j.grid.grille[x-1][y] >= 4 && j.grid.grille[x+1][y] < 8 && !fantome) {
                    j.life--;
                    j.grid.grille[x][y] = etatCase;
                    x = START_X;
                    y = START_Y;
                }else {
                    if (fantome && j.grid.grille[x][y] < 4) {
                        d = Direction.immobile;
                    }else {
                        x--;
                        j.grid.grille[x+1][y] = etatCase;
                    }
                }
                tmp = j.grid.grille[x][y];
                j.grid.grille[x][y] = value;
            }else if (d.equals(Direction.bas)&& (x+1 < cols) && j.grid.grille[x+1][y] != 8) {
                if (j.grid.grille[x+1][y] >= 4 && j.grid.grille[x+1][y] < 8 && !fantome) {
                    j.life--;
                    j.grid.grille[x][y] = etatCase;
                    x = START_X;
                    y = START_Y;
                }else {
                    if (fantome && j.grid.grille[x][y] < 4) {
                        d = Direction.immobile;
                    }else {
                        x++;
                        j.grid.grille[x-1][y] = etatCase;
                    }
                }
                tmp = j.grid.grille[x][y];
                j.grid.grille[x][y] = value;
            }else if (d.equals(Direction.gauche)&& (y-1 >= 0) && j.grid.grille[x][y-1] != 8) {
                if (j.grid.grille[x][y-1] >= 4&& j.grid.grille[x+1][y] < 8 && !fantome) {
                    j.life--;
                    j.grid.grille[x][y] = etatCase;
                    x = START_X;
                    y = START_Y;
                    j.grid.grille[x][y] = value;
                }else {
                    if (fantome && j.grid.grille[x][y] < 4) {
                        d = Direction.immobile;
                    }else {
                        y--;
                        j.grid.grille[x][y+1] = etatCase;
                    }
                }
                tmp = j.grid.grille[x][y];
                j.grid.grille[x][y] = value;
            }else if (d.equals(Direction.droite)&& (y+1 < rows) && j.grid.grille[x][y+1] != 8) {
                if (j.grid.grille[x][y+1] >= 4&& j.grid.grille[x+1][y] < 8 && !fantome) {
                    j.life--;
                    j.grid.grille[x][y] = etatCase;
                    x = START_X;
                    y = START_Y;
                }else {
                    if (fantome && j.grid.grille[x][y] < 4) {
                        d = Direction.immobile;
                    }else {
                        y++;
                        j.grid.grille[x][y-1] = etatCase;
                    }
                }
                tmp = j.grid.grille[x][y];
                j.grid.grille[x][y] = value;
            }else {
                d = Direction.immobile;
                return;
            }

            if (fantome) {
                etatCase = tmp;
            }else {
                j.score += tmp*10;
            }
        }
    }
}
