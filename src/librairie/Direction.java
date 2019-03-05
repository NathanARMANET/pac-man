package librairie;

import java.util.List;
import java.util.Random;

public enum Direction {
    gauche,
    droite,
    haut,
    bas,
    immobile;

    private static final List<Direction> VALUES = List.of(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Direction randomDirection()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
