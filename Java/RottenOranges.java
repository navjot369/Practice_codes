import java.util.*;

public class RottenOranges {
    public static class Index {
        int i;
        int j;

        public Index(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public static void main(String args[]) {
        int[][] arr = {{2, 1, 0, 2, 1}, 
        {0, 1, 1, 2, 1},
        {0, 0, 0, 2, 1}};

        int time = minTime(arr);
        if(time == -1) {
            System.out.println("All oranges can't be rotten");
        }
        else {
            System.out.println("All oranges will be rotten in: " + time);
        }
    }

    public static boolean isValid(int i, int j, int M, int N) {
        return (i >= 0 && j >= 0 && i < M && j < N);
    }

    public static int minTime(int[][] arr) {
        int M = arr.length;
        int N = arr[0].length;
        Queue<Index> q = new LinkedList<>();
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(arr[i][j] == 2) {
                    q.add(new Index(i, j));
                }
            }
        }
        q.add(null);
        int time = 0;
        int di[] = {1, 0, -1, 0};
        int dj[] = {0, 1, 0, -1};

        while(!q.isEmpty()) {
            Index curr = q.remove();
            if(curr == null) {
                if(!q.isEmpty()) {
                    time++;
                    q.add(null);
                }
                continue;
            }
            int i = curr.i;
            int j = curr.j;
            for(int x = 0; x < 4; x++) {
                if(isValid(i + di[x], j + dj[x], M, N)) {
                    int new_i = i + di[x];
                    int new_j = j + dj[x];
                    if(arr[new_i][new_j] == 1) {
                        arr[new_i][new_j] = 2;
                        q.add(new Index(new_i, new_j));
                    }
                }
            }
        }
        for(int i=0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(arr[i][j] == 1) {
                    return -1;
                }
            }
        }
        return time;
    }
}