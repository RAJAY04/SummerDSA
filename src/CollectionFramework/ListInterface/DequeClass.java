package CollectionFramework.ListInterface;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class DequeClass {
    public static void main(String[] args) {
        //The Stack class in Java is a legacy class and inherits from Vector in Java.
        // It is a thread-safe class and hence involves overhead when we do not need thread safety.
        // It is recommended to use ArrayDeque for stack implementation as it is more efficient in a single-threaded environment.
        Deque<Character> stack = new ArrayDeque<Character>();
        stack.push('A');
        stack.push('B');
        System.out.println(stack.peek());
        System.out.println(stack.pop());

        //One more reason to use Deque over Stack is Deque has the ability to use streams convert to list
        // with keeping LIFO concept applied while Stack does not.
        Stack<Integer> stack1 = new Stack<>();
        Deque<Integer> deque = new ArrayDeque<>();

        stack1.push(1);//1 is the top
        deque.push(1);//1 is the top
        stack1.push(2);//2 is the top
        deque.push(2);//2 is the top

        List<Integer> list1 = stack1.stream().collect(Collectors.toList());//[1,2]
        System.out.println("Using Stack -");
        for(int i = 0; i < list1.size(); i++){
            System.out.print(list1.get(i) + " " );
        }
        System.out.println();

        List<Integer> list2 = deque.stream().collect(Collectors.toList());//[2,1]
        System.out.println("Using Deque -");
        for(int i = 0; i < list2.size(); i++){
            System.out.print(list2.get(i) + " " );
        }
        System.out.println();
    }
}
