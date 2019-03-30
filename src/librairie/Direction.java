package librairie;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Enumération des direction possible
 */
public enum Direction {
    gauche,
    droite,
    haut,
    bas,
    immobile;

    private static final List<Direction> VALUES = new ArrayList<>();
    static {
        VALUES.add(Direction.gauche);
        VALUES.add(Direction.droite);
        VALUES.add(Direction.haut);
        VALUES.add(Direction.bas);
        VALUES.add(Direction.immobile);
        
    }
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    /**
     * @return Une direction aléatoire
     */
    public static Direction randomDirection()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
