//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        while (t-- > 0) {
            int sum = 4;//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2)
    {
        int dp[] = new int[x+1];
        int s = 1;
        for(int i = 0; i < y; i++) {
            int j = start;
            for(; j < x+1; j++) {
                if(s1.charAt(j) == s2.charAt(i)) {
                    dp[j]++;
                    start = j++;
                    break;
                }
            }
            for(; j < x+1; j++) {
                dp[j] = dp[j-1];
            }
        }
    }
    
}
            int N = 3;
            int coins[] = {3, 2, 1};
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int coins[], int N, int sum) {
        long dp[] = new long[sum+1];
        dp[0] = 1;
        
        for(int i = 0; i < N; i++) {
            for(int j = coins[i]; j <= sum; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        
        return dp[sum];
    }
}
