//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class MCM
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        int dp[][] = new int[N-1][N-1];
        for(int len = 1; len < N-1; len++) {
            for(int i = 0, j=len; j < N-1; j++, i++) {
                int min = Integer.MAX_VALUE;
                for(int k = i; k < j; k++) {
                    int cost = arr[i]*arr[k+1]*arr[j+1];
                    cost += (dp[i][k]+dp[k+1][j]);
                    min = Math.min(min, cost);
                }
                dp[i][j] = min;
            }
        }

        for(int i = 0; i < N-1; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        
        return dp[0][N-2];
    }
}