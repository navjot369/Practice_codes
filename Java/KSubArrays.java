import java.util.*;

/*
 * We have an Array[] of N elements and a number K. ( 1<=K<=N).Split the given  array 
 * into K subarrays (they must cover all the elements). The maximum subarray sum achievable
 *  out of K subarrays formed must be the minimum possible. Find that possible subarray sum.
 */
public class KSubArrays {
    public static int minSumBF(int arr[], int K) {  //Brute force
        Arrays.sort(arr);
        int N = arr.length;
        int maxSum = arr[N - 1];

        int tempSum = 0;
        for(int i = 0; i <= N - K; i++){
            tempSum += arr[i];
        }
        maxSum = tempSum > maxSum? tempSum : maxSum;

        return maxSum;
    }

    public static int ans = 100000;
    public static void solve(int arr[], int N, int K, int ind, int maxSum) {
        System.out.println(K + " " + ind + " " + maxSum);
        if(K == 1) {
            // maxSum = Math.max(maxSum, sum);
            int sum = 0;
            for(int i = ind; i < N; i++) {
                sum += arr[i];
            }
            maxSum = Math.max(maxSum, sum);
            ans = Math.min(ans, maxSum);
            System.out.println("K 1 : " + ans);
            return;
        }

        int sum = 0;
        for(int i = ind; i < N; i++) {
            sum += arr[i];
            maxSum = Math.max(sum, maxSum);
            solve(arr, N, K - 1, i + 1, maxSum);
        }
    }

    public static void main(String args[]) {
        int arr[] = {3, 1, 2, -4};
        solve(arr, 4, 1, 0, 0);
        System.out.println(ans);
    }
}
