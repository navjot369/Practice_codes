import java.util.*;

public class CountDistEle {
    public static int count(int arr[]) {
        HashSet<Integer> set = new HashSet<>();
        for(int i:arr) set.add(i);
        return set.size();
    }

    public static void main(String args[]) {
        int arr[] = {1, 1, 2, 3, 4, 2, 3, 5 ,6, 4, 3, 8};

        System.out.println(count(arr));
    }
}