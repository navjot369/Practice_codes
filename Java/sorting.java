public class sorting {

    public static void selection(int arr[], int i) {
        if (i == arr.length) {
            return;
        }
        int min = i;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[min]) {
                min = j;
            }
        }
        if (min != i) {
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        selection(arr, i + 1);
    }

    public static void bubble(int arr[]) {
        for (int i = arr.length - 1; i > 0; i--) {
            boolean swap = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
    }

    public static void insertion(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] < val){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = val;
        }
    }

    public static void counting(int arr[]) {
        int largest = Integer.MIN_VALUE;
        int len = arr.length;
        for(int i = 0; i < len; i++) {
            largest = largest > arr[i]? largest : arr[i];
        }
        int count[] = new int[largest + 1];
        for(int i = 0; i < len; i++) {
            count[arr[i]]++;
        }
        int index = 0;
        for(int j = 0; j <= largest; j++) {
            while(count[j] > 0) {
                arr[index] = j;
                index++;
                count[j]--;
            }
        }
    }

    public static void main(String args[]) {
        int arr[] = { 9, 4, 1, 3, 8, 10, 3 };
        // selection(arr, 0);
        // bubble(arr);
        // insertion(arr);
        counting(arr);
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.println(arr[i]);
            } else {
                System.out.print(arr[i] + " < ");
            }
        }
    }
}
