//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] str = br.readLine().trim().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int[][] matrix = new int[N][M];
            for(int i=0; i<N; i++)
            {
                String[] s = br.readLine().trim().split(" ");
                for(int j=0; j<M; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            System.out.println(obj.closedIslands(matrix, N, M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int closedIslands(int[][] matrix, int N, int M)
    {
        int ans = 0;
        boolean vis[][] = new boolean[N][M];
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(matrix[i][j] == 1 && !vis[i][j]) {
                    if(isclosed(matrix, i, j, N, M, vis)) {
                        System.out.println("At point- " + i + " - " + j);
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    
    public static boolean isclosed(int[][] matrix, int i, int j, int N, int M, boolean[][] vis) {
        if(i<0 || j<0 || i==N || j==M) {
            System.out.println(i + ", " + j + "- " + "False 1");
            return false;
        }
        if(matrix[i][j] == 0) {
            System.out.println(i + ", " + j + "- " + "True 2");
            return true;
        }
        
        if(vis[i][j]) {
            System.out.println(i + ", " + j + "- " + "True 3");
            return true;
        }
        vis[i][j] = true;
        boolean top = isclosed(matrix, i - 1, j, N, M, vis);
        boolean right = isclosed(matrix, i, j + 1, N, M, vis);
        boolean bottom = isclosed(matrix, i + 1, j, N, M, vis);
        boolean left = isclosed(matrix, i, j - 1, N, M, vis);
        if(!(top && right && bottom && left)) {
            return false;
        }
        return true;
    }
}