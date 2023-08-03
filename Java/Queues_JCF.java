import java.util.*;

public class Queues_JCF {
    public static void main(String args[]) {
        // Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q1 = new ArrayDeque<>(); //
        q1.add(1);
        q1.add(2);
        q1.add(3);
        while(!q1.isEmpty()) {
            System.out.println(q1.remove());
        }

        System.out.println("\n");
        Queue<Integer> q2 = new ArrayDeque<>();
        q2.add(6);
        q2.add(7);
        q2.add(8);
        q2.add(9);
        while(!q2.isEmpty()) {
            System.out.println(q2.remove());
        }
    }
}
