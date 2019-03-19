package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public enum Direction {
    gauche,
    droite,
    haut,
    bas,
    immobile;

    private static final List<Direction> VALUES = new ArrayList<Direction>();
    static {
        VALUES.add(Direction.gauche);
        VALUES.add(Direction.droite);
        VALUES.add(Direction.haut);
        VALUES.add(Direction.bas);
        VALUES.add(Direction.immobile);
        
    }
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Direction randomDirection()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
