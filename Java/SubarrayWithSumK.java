import java.util.*;

public class SubarrayWithSumK {
    public static int countSubarray(int arr[], int K) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);

        int sum = 0;
        int count = 0;

        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(hm.containsKey(sum - K)) {
                count += hm.get(sum - K);
            }
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String args[]) {
        int arr[] = {10, 2, -2, -20, 10};
        int K = -10;

        int ans = countSubarray(arr, K);
        System.out.println(ans);

    }
}