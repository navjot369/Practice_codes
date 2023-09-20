import java.util.*;

public class TwoSum {
    public static int[] getTarget(int arr[], int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            int diff = target - arr[i];

            if(hm.containsKey(diff)) {
                return new int[]{hm.get(diff), i};
            }
            hm.put(arr[i], i);
        }

        return new int[]{0, 0};
    }
    public static void main() {
        int arr[] = {2, 7, 11, 15};

        int ans[] = getTarget(arr, 9);
        System.out.println("(" + ans[0] + ", " + ans[1] + ")");
    }
}