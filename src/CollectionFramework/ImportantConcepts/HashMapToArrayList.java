package CollectionFramework.ImportantConcepts;

import java.util.*;

public class HashMapToArrayList {
    public static void main(String[] args) {

        //method 1
        HashMap<String, Integer> map
                = new HashMap<>();

        // Add elements to the map
        map.put("vishal", 10);
        map.put("sachin", 30);
        map.put("vaibhav", 20);

        // Finding the Set of keys from
        // the HashMap
        Set<String> keySet = map.keySet();

        // Creating an ArrayList of keys
        // by passing the keySet
        ArrayList<String> listOfKeys
                = new ArrayList<String>(keySet);

        // Getting Collection of values from HashMap
        Collection<Integer> values = map.values();

        // Creating an ArrayList of values
        ArrayList<Integer> listOfValues
                = new ArrayList<>(values);

        System.out.println("The Keys of the Map are "
                + listOfKeys);

        System.out.println("The Values of the Map are "
                + listOfValues);





        //method 2
        HashMap<String, Integer> map1
                = new HashMap<>();

        // Add elements to the map
        map.put("vishal", 10);
        map.put("sachin", 30);
        map.put("vaibhav", 20);

        // Set of the entries from the
        // HashMap
        Set<Map.Entry<String, Integer> > entrySet
                = map.entrySet();

        // Creating an ArrayList of Entry objects
        ArrayList<Map.Entry<String, Integer> > listOfEntry
                = new ArrayList<Map.Entry<String, Integer>>(entrySet);

        System.out.println(listOfEntry);
    }
}
