import java.util.*;

/*
 * Here, we are given two arrays, we have to make pairs of elements in these 
 * arrays such that sum of their absolute difference is minimum.
 * We have to find the minimum sum that is possible.
 */
public class MinAbsPair {
    public static int minSumByPairs(int A[], int B[]) {
        Arrays.sort(A);
        Arrays.sort(B);

        int result = 0;

        for(int i = 0; i < A.length; i++) {
            result += Math.abs(A[i] - B[i]);
        }

        return result;
    }
    public static void main(String args[]) {
        int A[] = {5, 3, 2, 1};
        int B[] = {6, 7, 10, 9};

        int ans = minSumByPairs(A, B);
        System.out.println(ans);

    }
}
