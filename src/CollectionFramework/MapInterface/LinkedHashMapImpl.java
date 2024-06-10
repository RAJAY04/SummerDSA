package CollectionFramework.MapInterface;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapImpl {
    public static void main(String[] args)
    {
//LinkedHashMap: Similar to HashMap but maintains the insertion order of the elements;
// it uses a doubly-linked list to keep track of the order.

        // Creating an empty LinkedHashMap
        Map<String, Integer> map = new LinkedHashMap<>();

        // Inserting pair entries in above Map
        // using put() method
        map.put("vishal", 10);
        map.put("sachin", 30);
        map.put("vaibhav", 20);

        // Iterating over Map
        for (Map.Entry<String, Integer> e : map.entrySet())

            // Printing key-value pairs
            System.out.println(e.getKey() + " "
                    + e.getValue());
    }
}
