public class prefix_sum {
    public static void main(String[] args) {
        int arr[] = { -1, -2, 4, 6, 10, -1, 12 };
        System.out.println(Max_subarray(arr));
    }

    public static int Max_subarray(int[] arr){ // Using prefix sum algorithm
        int len = arr.length;
        int prefix[] = new int[len];
        prefix[0] = arr[0];
        int max_sum = arr[0];
        for(int i = 1; i < len; i++){
            prefix[i] = prefix[i-1] + arr[i];
            if(prefix[i] > max_sum) {
                max_sum = prefix[i];
            }
        }
        for(int i = 1; i < len; i++) {
            for(int j = i + 1; j < len; j++) {
                if(prefix[j] - prefix[i-1] > max_sum) {
                    max_sum = prefix[j] - prefix[i-1];
                }
            }
        }
        return max_sum;
    }
    
}