public class sample {
    public static int power(int a, int n) {
        if(n == 0) {
            return 1;
        }
        int ans = power(a, n/2);
        ans *= ans;
        if(n % 2 == 1) {
            ans = ans * a;
        }
        return ans;
    }

    public static void main(String[] args) {
        int a = 2;
        int n = 10;
        int ans = power(a, n);
        System.out.println(ans);
    }
}