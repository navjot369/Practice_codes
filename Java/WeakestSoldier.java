import java.util.*;

public class WeakestSoldier {
    static class Row implements Comparable<Row> {
        int count;
        int idx;

        public Row(int arr[], int idx) {
            int count = 0;
            for(int i = 0; i < arr.length; i++) {
                count += arr[i];
            }
            this.count = count;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row other) {
            if(this.count == other.count) {
                return this.idx - other.idx;
            }
            else{
                return this.count - other.count;
            }
        }
    }
    public static void main(String args[]) {
        int arr[][] = {{1, 1, 1, 0}, {1, 1, 1, 1}, {1, 1, 0, 0}, {1, 0, 0, 0}, {0, 0, 0, 0}};
        int K = 2;
        PriorityQueue<Row> pq = new PriorityQueue<>();

        for(int i = 0; i < arr.length; i++) {
            pq.add(new Row(arr[i], i));
        }

        for(int i = 0; i < K; i++){
            System.out.println("Row - " + pq.remove().idx);
        }
    }
}
