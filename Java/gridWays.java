public class gridWays {
    static int m = 3;
    static int n = 3;
    public static int ways(int i, int j) {
        if(i == m - 1 && j == n - 1) return 1;
        int ans = 0;
        if(i < m - 1) ans += ways(i + 1, j);
        if(j < n - 1) ans += ways(i , j + 1);
        return ans;
    }

    public static void main(String args[]) {
        System.out.println(ways(0, 0));
    }
}
