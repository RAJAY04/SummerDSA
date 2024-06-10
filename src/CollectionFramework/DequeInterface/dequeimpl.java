package CollectionFramework.DequeInterface;

import java.util.Deque;
import java.util.LinkedList;
//im only adding important implementation,there are many check gfg article for more
public class dequeimpl {
    //Deque interface present in java.util package is a subtype of the queue interface.
    // The Deque is related to the double-ended queue that supports the addition or removal of
    // elements from either end of the data structure. It can either be used as a queue(first-in-first-out/FIFO)
    // or as a stack(last-in-first-out/LIFO). Deque is the acronym for double-ended queue.
    public static void main(String[] args) {
        Deque<String> deque
                = new LinkedList<String>();

        // We can add elements to the queue
        // in various ways

        // Add at the last
        deque.add("Element 1 (Tail)");

        // Add at the first
        deque.addFirst("Element 2 (Head)");

        // Add at the last
        deque.addLast("Element 3 (Tail)");

        // Add at the first
        deque.push("Element 4 (Head)");

        // Add at the last
        deque.offer("Element 5 (Tail)");

        // Add at the first
        deque.offerFirst("Element 6 (Head)");

        System.out.println(deque + "\n");

        // We can remove the first element
        // or the last element.
        deque.removeFirst();
        deque.removeLast();
        System.out.println("Deque after removing "
                + "first and last: "
                + deque);
    }
}
