package CollectionFramework.SetInterface;

import java.util.LinkedHashSet;
import java.util.Set;

//LinkedHashSet lets us iterate through the elements in the order in which they were inserted.
public class LinkedHashSetExample {
    public static void main(String[] args) {
        // Creating a LinkedHashSet
        Set<String> linkedHashSet = new LinkedHashSet<>();

        // Adding elements to the LinkedHashSet
        linkedHashSet.add("A");
        linkedHashSet.add("B");
        linkedHashSet.add("C");
        linkedHashSet.add("D");
        linkedHashSet.add("E");

        // Attempting to add duplicate elements
        linkedHashSet.add("A");
        linkedHashSet.add("B");

        // Printing the LinkedHashSet
        System.out.println("LinkedHashSet: " + linkedHashSet);

        // Removing an element
        linkedHashSet.remove("C");
        System.out.println("After removing C: " + linkedHashSet);

        // Checking if an element exists
        boolean containsB = linkedHashSet.contains("B");
        System.out.println("Contains B: " + containsB);

        // Iterating over the elements in the LinkedHashSet
        System.out.print("Iterating over LinkedHashSet: ");
        for (String element : linkedHashSet) {
            System.out.print(element + " ");
        }
    }
}
