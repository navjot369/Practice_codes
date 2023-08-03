import java.util.*;

public class Deque_JCF {
    public static void main(String args[]){
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addFirst(1);
        dq.addFirst(2);
        dq.addLast(4);
        dq.addLast(3);
        System.out.println(dq);

        dq.removeLast();
        dq.removeFirst();
        System.out.println(dq);

        dq.addLast(6);
        dq.addLast(8);
        System.out.println("First element in dq: " + dq.getFirst());
        System.out.println("Last element in dq: " + dq.getLast());

        System.out.println("\n" + dq);
    }
}
