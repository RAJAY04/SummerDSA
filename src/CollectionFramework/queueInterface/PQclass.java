package CollectionFramework.queueInterface;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PQclass {
    public static void main(String[] args) {
        Queue<String> pq = new PriorityQueue<>();

        pq.add("Geeks");
        pq.add("For");
        pq.add("Geeks");
        Iterator iterator = pq.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println("Initial Queue " + pq);

        pq.remove("Geeks");

        System.out.println("After Remove " + pq);

        System.out.println("Poll Method " + pq.poll());

        System.out.println("Final Queue " + pq);


    }
}
