public class LongestPalimSubStr {
    public static void main(String args[]) {
        String S = "aaaabbaa";
        System.out.println(longestPalindrome(S));
    }

    public static String longestPalindrome(String S) {
        int len = S.length();
        int dp[][] = new int[len][len];
        for (int i = 0; i < len; i++)
            dp[i][i] = 1;

        int start = 0, end = 0;
        int maxLength = 0;
        for (int s = len - 1; s >= 0; s--) {
            for (int e = s + 1; e < len; e++) {
                if (S.charAt(s) == S.charAt(e)) {
                    if (dp[s + 1][e - 1] > 0 || s + 1 == e - 1) {
                        dp[s][e] = dp[s + 1][e - 1] + 2;
                        if (dp[s][e] > maxLength) {
                            maxLength = dp[s][e];
                            start = s;
                            end = e;
                        }
                    }
                }
            }
        }

        System.out.print("  ");
        for (int i = 0; i < len; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < len; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < len; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return S.substring(start, end + 1);
    }
}
