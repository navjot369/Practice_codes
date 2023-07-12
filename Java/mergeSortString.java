public class mergeSortString {
    public static void mergeSort(String arr[], int si, int ei) {
        if(si >= ei){
            return;
        }
        int mid = si + (ei - si)/2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);
        merge(arr, si, mid, ei);
    }

    public static void merge(String arr[], int si, int mid, int ei) {
        String temp[] = new String[ei - si + 1];
        int firsti = si, ind = 0, seci = mid + 1;
        while(firsti <= mid && seci <= ei) {
            if(arr[firsti].compareTo(arr[seci]) <= 0){
                temp[ind] = arr[firsti];
                firsti++;
            }
            else{
                temp[ind] = arr[seci];
                seci++;
            }
            ind++;
        }
        while(firsti <= mid){
            temp[ind] = arr[firsti];
            firsti++;
            ind++;
        }
        while(seci <= ei) {
            temp[ind] = arr[seci];
            seci++;
            ind++;
        }
        for(int i = 0, j = si; i < ind; i++, j++) {
            arr[j] = temp[i];
        }
    }

    public static void main(String args[]){
        String arr[] = {"Zebra", "Monkey", "Parrot", "Lion", "Bird"};
        mergeSort(arr, 0, arr.length - 1);
        for(int i = 0 ; i < arr.length; i++){
            if(i == arr.length - 1){
                System.out.println(arr[i]);
            }
            else{
                System.out.print(arr[i] + ", ");
            }
        }
    }
}
