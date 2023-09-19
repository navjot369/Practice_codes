import java.util.*;

public class SubarrayWithSum0 {
    public static int largestArray(int arr[]) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        int len = 0;
        hm.put(0, -1);

        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(hm.containsKey(sum)) {
                len = Math.max(len, i - hm.get(sum));
            } else {
                hm.put(sum, i);
            }
        }
        return len;
    }

    public static void main(String args[]) {
        int arr[] = {10, 5, -5, 8, -10, 6, 9};
        int ans = largestArray(arr);

        System.out.println(ans);
    }
}