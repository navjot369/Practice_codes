//{ Driver Code Starts
import java.io.*;
import java.util.*;

class targetSum
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        boolean dp[][] = new boolean[N+1][sum+1];
        for(int i = 0; i < N+1; i++) dp[i][0] = true;
        
        for(int i = 1; i < N+1; i++) {
            for(int j = 1; j < sum + 1; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= arr[i-1]) {
                    dp[i][j] = dp[i][j] || dp[i-1][j-arr[i-1]];
                }
            }
        }

        System.out.print("  ");
        for(int i = 0; i < sum+1; i++) System.out.print(i + " ");
        System.out.println();
        for(int i = 0; i < N+1; i++) {
            System.out.print(i+ " ");
            for(int j = 0; j < sum+1; j++) {
                System.out.print((dp[i][j]? 1: 0) + " ");
            }
            System.out.println();
        }
        
        return dp[N][sum];
    }
}