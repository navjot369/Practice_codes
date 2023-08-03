import java.util.*;

public class ConnectNRopes { 
    public static int minCost(int arr[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int total = 0;

        for(int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }

        while(pq.size() > 1) {
            int cost = pq.poll() + pq.poll();
            total += cost;
            pq.add(cost);
        }
        return total;
    }

    public static void main(String args[]) {
        int arr[] = {4, 3, 2, 6};
        System.out.println(minCost(arr));
    }

}
