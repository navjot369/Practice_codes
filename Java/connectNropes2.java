import java.util.*;

public class connectNropes2 {
    public static void main(String args[]) {
        int arr[] = {4, 3, 2, 6};

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }

        int cost = 0;
        while(pq.size() > 1) {
            int rope1 = pq.remove();
            int rope2 = pq.remove();

            cost += (rope1 + rope2);
            pq.add(rope1 + rope2);
        }

        System.out.println("Total cost: " + cost + "\nTotal length: " + pq.remove());
    }
}
