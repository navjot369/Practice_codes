public class friendsPairing {
    public static int totalWays(int num) {
        if(num == 1 || num == 2){
            return num;
        }
        int ans = totalWays(num - 1) + ((num - 1) * totalWays(num - 2));
        return ans;
    }

    public static void main(String args[]) {
        int num = 4;
        System.out.println("Total number of ways are: " + totalWays(num));
    }
}
