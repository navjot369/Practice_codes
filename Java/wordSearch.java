public class wordSearch {
    public static void main(String args[]) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'}, {'A','D','E','E'}};
        String word = "ABCB";

        Solution sol = new Solution();
        System.out.println(sol.exist(board, word));
    }
}

class Solution {
    static String str;
    static int temp[][];
    static char mat[][];
    static int m, n, len;
    static int di[] = {-1, 0, 1, 0};
    static int dj[] = {0, 1, 0, -1};

    public boolean exist(char[][] board, String word) {
        return exists(board, word);
    }

    public static boolean exists(char[][] board, String word) {
        str = word;
        mat = board;
        len = str.length();
        m = board.length;
        n = board[0].length;
        temp = new int[m][n];

        boolean ans =  util(0, 0, 0);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++)
            System.out.print(temp[i][j] + " ");
            System.out.println();
        }
        return ans;
    }

    public static boolean isValid(int i, int j) {
        return ((i >= 0 && i < m) && (j >= 0 && j < n));
    }

    public static boolean util(int i, int j, int ind) {
        if(ind == len-1 && mat[i][j] == str.charAt(ind)) {
            return true;
        }

        System.out.println(i + " " + j + " ->> ");
        for(int ii = 0; ii < m; ii++) {
            for(int jj = 0; jj < n; jj++)
            System.out.print(temp[ii][jj] + " ");
            System.out.println();
        }
        System.out.println();

        if(mat[i][j] == str.charAt(ind)) {
            int prev = temp[i][j];
            temp[i][j] = 2;
            for(int k = 0; k < 4; k++) {
                if(isValid(i+di[k], j+dj[k]) && temp[i+di[k]][j+dj[k]] != 2) {
                    if(util(i+di[k], j+dj[k], ind+1)) {
                        return true;
                    }
                }
            }
            temp[i][j] = prev;
            if(ind != 0) return false;
        }

        if(ind == 0) {
            temp[i][j] = 1;
            for(int k = 0; k < 4; k++) {
                if(isValid(i+di[k], j+dj[k]) && temp[i+di[k]][j+dj[k]] == 0) {
                    if(util(i+di[k], j+dj[k], ind)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}