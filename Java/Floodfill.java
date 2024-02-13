import java.util.*;

public class Floodfill{
    public static class Pair {
        int i;
        int j;
        public Pair(int i, int j) {
            this.i  = i;
            this.j = j;
        }
    }

    public static void floodFill1(int[][] image, int sr, int sc, int color) { //Internal Graph implementation
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(sr, sc));
        int devi[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        boolean ischeck[][] = new boolean[image.length][image[0].length];
        ischeck[sr][sc] =  true;
        while(!q.isEmpty()) {
            Pair curr = q.remove();
            System.out.println(curr.i + " -- " + curr.j);
            for(int i = 0; i < 4; i++) {
                int newi = curr.i + devi[i][0];
                int newj = curr.j + devi[i][1];
                if(newi >= 0 && newj >= 0 && newi < image.length && newj < image[0].length && !ischeck[newi][newj] && image[curr.i][curr.j] == image[newi][newj]) {
                    q.add(new Pair(newi, newj));
                    ischeck[newi][newj] = true;
                }
            }
            image[curr.i][curr.j] = color;
        }
    }


    //Better approach using recursion
    public static void floodFill2(int[][] image, int sr, int sc, int old, int color) {
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != old || image[sr][sc] == color) {
            return;
        }
        image[sr][sc] = color;
        floodFill2(image, sr - 1, sc, old, color);
        floodFill2(image, sr, sc + 1, old, color);
        floodFill2(image, sr + 1, sc, old, color);
        floodFill2(image, sr, sc - 1, old, color);
    }

    public static void main(String args[]) {
        int image[][] = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int color = 2;

        floodFill2(image, sr, sc, image[sr][sc],color);
        for(int  i = 0; i < image.length; i++) {
            for(int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j] + "  ");
            }
            System.out.println();
        }
    }
}