public class HanoiTower {
    public static void Transfer(int n, String src, String helper, String dest) {
        if(n == 1){
            System.out.println("Transfer disk " + n + " from " + src + " to " + dest);
            return;
        }
        Transfer(n - 1, src, dest, helper);
        System.out.println("Transfer disk " + n + " from " + src + " to " + dest);
        Transfer(n - 1, helper, src, dest);

    }

    public static void main(String main[]) {
        Transfer(4, "A", "B", "C");
    }
}
