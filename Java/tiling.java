public class tiling {
    public static int totalWays(int n) {
        if(n == 0){
            return 1;
        }
        int ways = totalWays(n-1);
        if(n >= 2){
            ways += totalWays(n-2);
        }
        return ways;
    }

    public static void main(String args[]) {
        int num = Integer.parseInt(args[0]);
        System.out.println(totalWays(num));
    }
}
