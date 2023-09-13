import java.util.*;

public class HeapsQue3 {
    static class Cell implements Comparable<Cell> {
        int x;
        int y;
        int dist;

        public Cell(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Cell c1) {
            return this.dist - c1.dist;
        }
    }

    public static int path(int arr[][], int M, int N) {
        int dist[][] = new int[M][N];
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, -1, 0, 1};
        dist[0][0] = arr[0][0];

        PriorityQueue<Cell> pq = new PriorityQueue<>();
        pq.add(new Cell(0, 0, dist[0][0]));

        while(!pq.isEmpty()) {
            Cell curr = pq.poll();
            for(int i = 0; i < 4; i++) {
                int rows = curr.x + dx[i];
                int cols = curr.y + dy[i];
                if(rows < 0 || rows >= M || cols < 0 || cols >= N) {
                    continue;
                }
                if(curr.dist + arr[rows][cols] < dist[rows][cols]) {
                    if(dist[rows][cols] != Integer.MAX_VALUE) {
                        Cell temp = new Cell(rows, cols, dist[rows][cols]);
                        pq.remove(temp);
                    }
                    dist[rows][cols] = curr.dist + arr[rows][cols];
                    pq.add(new Cell(rows, cols, dist[rows][cols]));
                }
            }
        }
        return dist[M-1][N-1];
    }

    public static void main(String args[]) {
        int arr[][] = { { 31, 100, 65, 12, 18 }, { 10, 13, 47, 157, 6 },
        { 100, 113, 174, 11, 33 }, { 88, 124, 41, 20, 140 }, { 99, 32, 111, 41, 20 } };
        int sum = path(arr, 5, 5);
        System.out.println(sum);
    }
}
