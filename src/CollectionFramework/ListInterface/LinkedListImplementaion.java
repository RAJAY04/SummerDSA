package CollectionFramework.ListInterface;

import java.util.LinkedList;
import java.util.List;

public class LinkedListImplementaion {
    public static void main(String[] args) {
        int n = 5;

        // Declaring the List with initial size n
        List<Integer> ll = new LinkedList<Integer>();

        // Appending the new elements
        // at the end of the list
        for (int i = 1; i <= n; i++)
            ll.add(i);

        // Printing elements
        System.out.println(ll);

        // Remove element at index 3
        ll.remove(3);

        // Displaying the list after deletion
        System.out.println(ll);

        // Printing elements one by one
        for (int i = 0; i < ll.size(); i++)
            System.out.print(ll.get(i) + " ");
    }
}
