public class Heaps2 {
    public static void heapify(int arr[], int ind, int len) {
        int left = 2 * ind + 1;
        int right = 2 * ind + 2;
        int maxInd = ind;

        if(left < len && arr[left] > arr[maxInd]) {
            maxInd = left;
        }
        if(right < len && arr[right] > arr[maxInd]) {
            maxInd = right;
        }

        if(maxInd != ind) {
            int temp = arr[maxInd];
            arr[maxInd] = arr[ind];
            arr[ind] = temp;

            heapify(arr, maxInd, len);
        }
    }

    public static void heapSort(int arr[]) {
        int len = arr.length;

        for(int i = len/2; i >= 0; i--) {
            heapify(arr, i, len);
        }

        int last = len - 1;
        while(last > 0) {
            int temp = arr[last];
            arr[last] = arr[0];
            arr[0] = temp;

            heapify(arr, 0, last);
            last--;
        }
    }
    public static void main(String args[]) {
        int arr[] = {5, 1, 3, 4, 8, 9, 2};
        

        heapSort(arr);

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }
}
