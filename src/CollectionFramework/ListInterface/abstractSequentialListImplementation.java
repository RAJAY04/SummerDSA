package CollectionFramework.ListInterface;

import java.util.AbstractSequentialList;
import java.util.LinkedList;

public class abstractSequentialListImplementation {
    public static void main(String[] args) {
        //used when sequential access of data, if random access abstract list shuld be used
        // Creating an instance of
        // the AbstractSequentialList
        AbstractSequentialList<Integer> absl
                = new LinkedList<>();

        // adding elements to absl
        absl.add(5);
        absl.add(6);
        absl.add(7);

        // Printing the list
        System.out.println(absl);
    }
}
