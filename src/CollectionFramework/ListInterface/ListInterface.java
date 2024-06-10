package CollectionFramework.ListInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListInterface {
    public static void main(String[] args) {
        //The implementation classes of the List interface are ArrayList, LinkedList, Stack, and Vector.
        // ArrayList and LinkedList are widely used in Java programming. The Vector class is deprecated since Java 5.
        List<Integer> l1 = new ArrayList<Integer>();

        // Adding elements to object of List interface
        // Custom inputs

        l1.add(0, 1);
        l1.add(1, 2);

        // Print the elements inside the object
        System.out.println(l1);

        // Now creating another object of the List
        // interface implemented ArrayList class
        // Declaring object of integer type
        List<Integer> l2 = new ArrayList<Integer>();

        // Again adding elements to object of List interface
        // Custom inputs
        l2.add(1);
        l2.add(2);
        l2.add(3);
        System.out.println(l2);
        // Will add list l2 from 1 index
        l1.addAll(1, l2);

        System.out.println(l1);
        l1.remove(1);

        // Printing the updated List 1
        System.out.println(l1);

        // Prints element at index 3 in list 1
        // using get() method
        System.out.println(l1.get(3));

        // Replace 0th element with 5
        // in List 1
        l1.set(0, 5);

        // Again printing the updated List 1
        System.out.println(l1);

        //operations in list interface
        //Operation 1: Adding elements to List class using add() method
        //Operation 2: Updating elements in List class using set() method
        //Operation 3: Searching for elements using indexOf(), lastIndexOf methods
        //Operation 4: Removing elements using remove() method
        //Operation 5: Accessing Elements in List class using get() method
        //Operation 6: Checking if an element is present in the List class using contains() method

        List<String> al = new ArrayList<>();

        // Adding elements to object of List interface
        // Custom elements
        al.add("Geeks");
        al.add("Geeks");
        al.add(1, "For");

        // Print all the elements inside the
        // List interface object
        System.out.println(al);

        al.set(1,"to");
        System.out.println(al);







        List<Integer> numbers = new ArrayList<>();

        // add some integers to the list
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(2);

        // use indexOf() to find the first occurrence of an
        // element in the list
        int index = numbers.indexOf(2);
        System.out.println(
                "The first occurrence of 2 is at index "
                        + index);

        // use lastIndexOf() to find the last occurrence of
        // an element in the list
        int lastIndex = numbers.lastIndexOf(2);
        System.out.println(
                "The last occurrence of 2 is at index "
                        + lastIndex);
        al.remove(1);
        //accessing elements using get

        boolean isPresent = al.contains("Geeks");

        // Printing the result
        System.out.println("Is Geeks present in the list? "
                + isPresent);


        List<Integer> lis1 = new ArrayList<>();
        List<Integer> lis2 = new ArrayList<>();

        // Adding elements to lis1 and lis2
        lis1.add(1);
        lis2.add(2);

        // Adding all elements from lis2 to lis1 starting from index 1
        lis1.addAll(lis1.size() , lis2);

        // Printing the resulting list
        System.out.println(lis1); // Expected output: [1, 2]
        lis2.clear();
        System.out.println(lis2);

        Object[] arr = lis1.toArray();
        arr[0] = 0;
        System.out.println(Arrays.toString(arr));




    }
}
