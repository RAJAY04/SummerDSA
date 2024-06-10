package CollectionFramework.SetInterface;

import java.awt.*;
import java.util.EnumSet;
import java.util.Set;
enum Color {
    RED, GREEN, BLUE, YELLOW, BLACK, WHITE
}

public class EnumSetExample {
    public static void main(String[] args) {
        // Creating EnumSets
        Set<Color> set1 = EnumSet.of(Color.RED, Color.GREEN, Color.BLUE);
        Set<Color> set2 = EnumSet.of(Color.BLUE, Color.YELLOW, Color.BLACK);

        // Union of the two sets
        Set<Color> union = EnumSet.copyOf(set1);
        union.addAll(set2);
        System.out.println("Union of the two sets: " + union);

        // Intersection of the two sets
        Set<Color> intersection = EnumSet.copyOf(set1);
        intersection.retainAll(set2);
        System.out.println("Intersection of the two sets: " + intersection);

        // Difference of the two sets
        Set<Color> difference = EnumSet.copyOf(set1);
        difference.removeAll(set2);
        System.out.println("Difference of the two sets: " + difference);
    }
}
