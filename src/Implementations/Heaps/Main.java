package Implementations.Heaps;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        Heap<Integer> heap = new Heap<>();

        heap.insert(10);
        heap.insert(5);
        heap.insert(15);
        heap.insert(20);
        heap.insert(25);
        heap.insert(30);

        ArrayList<Integer> list = heap.heapSort();
        System.out.println(list);

        //heapify
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(5);
        arr.add(15);
        arr.add(20);
        arr.add(25);
        arr.add(30);

        // Convert ArrayList to Integer array
        Integer[] arrArray = new Integer[arr.size()];
        arr.toArray(arrArray);

        Heap<Integer> heap2 = new Heap<>();
        heap2.heapify(arrArray);
    }
}