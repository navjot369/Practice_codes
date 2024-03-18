//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class EditDistance {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = 1;
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int editDistance(String s, String t) {
        int x = s.length();
        int y = t.length();
        
        int dp[][] = new int[x+1][y+1];
        for(int i = 0; i <= x; i++) dp[i][0] = i;
        for(int j = 0; j <= y; j++) dp[0][j] = j;
        
        for(int i = 1; i <= x; i++) {
            for(int j = 1; j <= y; j++) {
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }
            }
        }

        System.out.print("  ");
        for(int i = 0; i <=x ; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i = 0; i <= x; i++) {
            System.out.print(i + " ");
            for(int j = 0; j <= y; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[x][y];
        
    }
}