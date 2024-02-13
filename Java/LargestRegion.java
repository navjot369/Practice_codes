import java.util.*;

public class LargestRegion {
    public static void main(String args[]) {
        int arr[][] = {{0, 0, 0, 1, 0}, {0, 0, 1, 1, 0}, {0, 0, 0, 0, 0}, {1, 1, 1, 1, 1}};

        System.out.println("Largest Region - " + maxRegion(arr));
    }

    public static boolean isValid(int i, int j, int[][] arr) {
        return (i >= 0 && j >= 0 && i < arr.length && j < arr[0].length);
    }

    public static int maxUtil(int[][] arr, boolean[][] vis, int indI, int indJ) {
        vis[indI][indJ] = true;
        int ans = 1;

        for(int i = -1; i < 2; i++) {
            for(int j = -1; j < 2; j++) {
                if(isValid(indI+i, indJ+j, arr)){ 
                    if(arr[indI+i][indJ+j] == 1 && !vis[indI+i][indJ+j]) {
                        ans += maxUtil(arr, vis, indI+i, indJ+j);
                    }
                }
            }
        }
        return ans;
    }

    public static int maxRegion(int[][] arr) {
        int answer = 0;
        int M = arr.length;
        int N = arr[0].length;
        boolean vis[][] = new boolean[M][N];
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(arr[i][j] == 1 && !vis[i][j]) {
                    int regionLen = maxUtil(arr, vis, i, j);
                    if(regionLen > answer) {
                        answer = regionLen;
                    }
                }
            }
        }
        return answer;
    }
}