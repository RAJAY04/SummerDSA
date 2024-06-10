package CollectionFramework.ListInterface;

import java.util.AbstractList;
import java.util.ArrayList;

public class abstractListImplementaion {
    public static void main(String[] args) {
        AbstractList<String> list = new ArrayList<String>();

        // Use add() method to add elements in the list
        list.add("Geeks");
        list.add("for");
        list.add("Geeks");
        list.add("10");
        list.add("20");
        System.out.println(list);
        list.set(1,"geeks");

        // Displaying the AbstractList
        System.out.println("AbstractList:" + list);

        //              AbstractCollection
        //                      |
        //                      |
        //                    List
        //                      |
        //                      |
        //              AbstractList
        //             /            \
        //   AbstractSequentialList   ArrayList


    }
}
