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

    public static void mergeSort(int arr[], int si, int ei) {
        if(si >= ei) {
            return;
        }
        int mid = si + (ei - si)/2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);
        merge(arr, si, mid, ei);
    }
    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si;
        int j = mid + 1;
        int ind = 0;
        while(i <= mid && j <= ei) {
            if(arr[i] < arr[j]){
                temp[ind] = arr[i];
                i++;
            }
            else {
                temp[ind] = arr[j];
                j++;
            }
            ind++;
        }
        while(i <= mid){
            temp[ind] = arr[i];
            i++;
            ind++;
        }
        while(j <= ei){
            temp[ind] = arr[j];
            j++;
            ind++;
        }
        for(int k = si, t = 0; t < temp.length; t++, k++){
            arr[k] = temp[t];
        }
    }

    public static void quickSort(int arr[], int si, int ei) {
        if(si >= ei) {
            return;
        }
        int pivot = arr[ei];
        int ind = si - 1;
        for(int i = si; i <= ei; i++) {
            if(arr[i] <= pivot) {
                ind++;
                int temp = arr[ind];
                arr[ind] = arr[i];
                arr[i] = temp;
            }
        }
        quickSort(arr, si, ind - 1);
        quickSort(arr, ind + 1, ei);
    }

    public static int search(int arr[], int tar, int si, int ei) {
        if(si > ei) {
            return -1;
        }
        int mid = si + (ei - si)/2;
        if(arr[mid] == tar) {
            return mid;
        }
        if(arr[si] <= arr[mid]) {
            if(arr[si] <= tar && tar <= arr[mid]) {
                return search(arr, tar, si, mid - 1);
            }
            else {
                return search(arr, tar, mid + 1, ei);
            }
        }
        else {
            if(arr[mid] <= tar && tar <= arr[ei]){
                return search(arr, tar, mid + 1, ei);
            }
            else {
                return search(arr, tar, si, mid - 1);
            }
        }
    }

    public static void main(String args[]) {
        // int arr[] = { 9, 4, 1, 3, 8, 10, 3 , 2, 6};
        // selection(arr, 0);
        // bubble(arr);
        // insertion(arr);
        // counting(arr);
        // mergeSort(arr, 0, arr.length - 1);
        // quickSort(arr, 0, arr.length - 1);
        // for (int i = 0; i < arr.length; i++) {
        //     if (i == arr.length - 1) {
        //         System.out.println(arr[i]);
        //     } else {
        //         System.out.print(arr[i] + " < ");
        //     }
        // }

        // Search in rotated array.
        int arr[] = {5, 7, 9, 1, 2, 3, 4};
        for(int i = 0; i < arr.length; i++) {
            System.out.print(search(arr, arr[i], 0, arr.length - 1) + "  ");
        }
    }
}
