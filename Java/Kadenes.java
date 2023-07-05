public class Kadenes {
    public static int algo(int arr[]) {
        int current_sum = 0;
        int max_sum = 0;
        int len = arr.length;
        for(int i = 0; i < len; i++) {
            current_sum += arr[i];
            if(current_sum > max_sum) {
                max_sum = current_sum;
            }
            if(current_sum < 0) {
                current_sum = 0;
            }
        }
        return max_sum;
    }

    public static void main(String args[]){
        int arr[] = { -1, 2, 4, 6, 10, -1, 12 };
        System.out.println(algo(arr));
    }
}
