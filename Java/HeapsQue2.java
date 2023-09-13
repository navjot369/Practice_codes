import java.util.*;

public class HeapsQue2 {
    public static int times(int arr[], int N, int K) {
        boolean temp[] = new boolean[N + 1];
        Queue<Integer> q = new ArrayDeque<>();
        int time = 0;
        for(int x:arr) {
            temp[x] = true;
            q.add(x);
        }
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int curr = q.poll();
                if(curr - 1 >= 1 && !temp[curr - 1]){
                    temp[curr - 1] = true;
                    q.add(curr - 1);
                }
                if(curr + 1 <= N && !temp[curr + 1]) {
                    temp[curr + 1] = true;
                    q.add(curr + 1);
                }
            }
            time++;
        }
        return time - 1;
    }
    public static void main(String args[]) {
        int arr[] = {2, 6};
        int N = 6;
        int K = 2;
        int ans = times(arr, N, K);

        System.out.println(ans);
    }
}