import java.util.*;

public class UnionIterSet {
    public static int union(int arr1[], int arr2[]) {
        HashSet<Integer> set = new HashSet<>();

        for(int val:arr1) set.add(val);
        for(int val:arr2) set.add(val);

        return set.size();
    }

    public static int intersection(int arr1[], int arr2[]) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int val:arr1) set.add(val);

        int count = 0;
        for(int i = 0; i < arr2.length; i++) {
            if(set.contains(arr2[i])) {
                count++;
                set.remove(arr2[i]);
            }
        }

        return count;
    }

    public static void main(String args[]) {
        int arr1[] = {1, 2, 3, 6};
        int arr2[] = {3, 7, 6, 9};

        int u = union(arr1, arr2);
        System.out.println("Total number of union elements: " + u);

        int i = intersection(arr1, arr2);
        System.out.println("Total number of intersection elements: " + i);

    }
}