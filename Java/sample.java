import java.util.*;

public class sample {
    public static void main(String args[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        pq.add(2);
        pq.add(3);
        pq.add(4);
    System.out.println(pq.poll());
    }

}