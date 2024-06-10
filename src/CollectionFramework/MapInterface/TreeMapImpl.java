package CollectionFramework.MapInterface;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapImpl {
    public static void main(String[] args)
    {
//TreeMap: Stores key-value pairs in a sorted order (according to the natural ordering of the keys or a specified comparator);
// it provides log-time performance for basic operations.
        // Creating an empty TreeMap
        Map<String, Integer> map = new TreeMap<>();

        // Inserting custom elements in the Map
        // using put() method
        map.put("vishal", 10);
        map.put("sachin", 30);
        map.put("vaibhav", 20);

        // Iterating over Map using for each loop
        for (Map.Entry<String, Integer> e : map.entrySet())

            // Printing key-value pairs
            System.out.println(e.getKey() + " "
                    + e.getValue());
    }
}
