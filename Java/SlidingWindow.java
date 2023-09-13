import java.util.*;

public class SlidingWindow {
    static class Pair implements Comparable<Pair> {
        int val;
        int idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair other) {
            return other.val - this.val;
        }
    }
    public static void main(String args[]) {
        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int len = arr.length;
        int K = 3;
        int res[] = new int[len-K+1];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int i;
        for(i = 0; i < K; i++) {
            pq.add(new Pair(arr[i], i));
        }
        res[0] = pq.peek().val;

        for(; i < len; i++) {
            while(pq.size() > 0 && pq.peek().idx <= i-K) {
                pq.remove();
            }
            pq.add(new Pair(arr[i], i));
            res[i-K+1] = pq.peek().val;
        }

        for(int j = 0; j < len-K+1; j++){
            System.out.print(res[j] + "  ");
        }
    }
}
