import java.util.*;

public class GenerateBin {
    public static void genBin(int N) {
        Queue<String> q = new ArrayDeque<>();
        q.add("1");
        while(N-- > 0) {
            String str = q.remove();
            System.out.print(str + " ");
            q.add(str + "0");
            q.add(str + "1");
        }
    }

    public static void main(String args[]) {
        genBin(5);
        System.out.println();
    }
}
