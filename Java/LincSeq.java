//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class LincSeq{
    public static void main(String args[]) throws IOException { 
        int t = 1;
        while(t > 0){
            
            //taking size of array
            int n = 6;
            int array[] = {5, 8, 3, 7, 9, 1};
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[])
    {
        int dp[][] = new int[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                dp[i][j] = -1;
            }
        }
        int ans = util(a, size-1, size, dp);
        for(int i = 0; i < size; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
        return ans;
    }
    static int util(int arr[], int curr, int comp,int dp[][]) {
        if(curr == -1) {
            return 0;
        }
        if()
        
        return ans;
    }
} 