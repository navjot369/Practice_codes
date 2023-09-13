import java.util.*;

public class NearlyNcars {
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distsq;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.distsq = x * x + y * y;
        }

        @Override
        public int compareTo(Point p2) {
            return this.distsq - p2.distsq;
        }
    }

    public static void main(String args[]) {
        int arr[][] = {{3, 3}, {1, 1}, {-2, -2}};
        int N = 2;

        PriorityQueue<Point> pq = new PriorityQueue<>();

        for(int i = 0; i < arr.length; i++) {
            pq.add(new Point(arr[i][0], arr[i][1]));
        }

        for(int k = 0; k < N; k++){
            Point temp = pq.remove();
            System.out.println("(" + temp.x + ", "+temp.y + ")");

        }
    }
}
