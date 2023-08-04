import java.util.*;

public class maxSubarrayK {

    public static void maxSub(int arr[], int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = arr.length;
        int i;
        for(i = 0; i < k; i++) {
            while(!dq.isEmpty() && arr[i] >= arr[dq.getLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        for(; i < n; i++) {
            System.out.print(arr[dq.getFirst()] + "  ");
            while(!dq.isEmpty() && dq.getFirst() <= i - k) {
                dq.removeFirst();
            }
            while(!dq.isEmpty() && arr[dq.getLast()] <= arr[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        System.out.println(arr[dq.getFirst()]);
    }

    public static void main(String args[]) {
        int arr[] = {6, 2, 3, 12, 5, 4, 6, 7};
        maxSub(arr, 3);
    }
}
