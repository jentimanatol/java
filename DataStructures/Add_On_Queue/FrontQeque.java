import java.util.Deque;
import java.util.LinkedList;

public class FrontQeque {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();

        // Add elements to the end of the Deque
        deque.add("A"); 
        deque.add("B"); 
        deque.add("C"); 
        deque.add("D"); 
        deque.add("E"); 

        System.out.println("Initial Deque: " + deque);

        // Add elements to the beginning of the Deque
        deque.addFirst("a");
        deque.addLast("z");
        ///deque.end("z");

        System.out.println("Deque after adding elements at the front: " + deque);
    }
}