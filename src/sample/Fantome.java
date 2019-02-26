package sample;

public class Fantome extends Entitee {

    public Fantome(int x, int y, int value, boolean estFantome) {
        super(x, y, value, estFantome);
    }

    void deplacerAlea(Jeu j) {
        super.deplacer(j);

        if (d == Direction.immobile) {
            d = Direction.randomDirection();
        }
    }
}
