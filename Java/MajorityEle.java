import java.util.*;

public class MajorityEle {
    public static void getMajority(int arr[]) {
        int len = arr.length;
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i = 0; i < len; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }

        // Set<Integer> set = hm.keySet(); 
        // We can directly use hm.keySet() in the for each loop.

        for(Integer val:hm.keySet()) {
            if(hm.get(val) > len/3) {
                System.out.println(val);
            }
        }
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 2, 1, 1, 2, 2, 1};

        getMajority(arr);
    }
}