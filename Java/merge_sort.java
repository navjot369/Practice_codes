public class merge_sort {
    public static void mergeSort(int arr[], int si, int ei){
        printArr(arr, si, ei);
        if(si>=ei){
            return;
        }
        int mid = si + (ei-si)/2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);
        merge(arr, si, mid, ei);
        printArr(arr, 0, 5);
    }
    public static void merge(int arr[], int si, int mid, int ei){
        int temp[] = new int[ei-si+1];
        int i = si;
        int j = mid+1;
        int k = 0;
        while(i <= mid && j <= ei){
            if(arr[i] < arr[j]){
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while(i <= mid){
            temp[k++] = arr[i++];
        }
        while(j <= ei){
            temp[k++] = arr[j++];
        }
        for(int oi=si, ti=0; ti<temp.length; oi++, ti++){
            arr[oi] = temp[ti];
        }
    }
    public static void printArr(int arr[], int si, int ei){
        for(int i=si; i<=ei; i++){
            if(i==ei){
                System.out.println(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
    }
    public static void main(String args[]){
        int sample[] = {6, 5, 4, 3, 2, 1};
        mergeSort(sample, 0, sample.length-1);
        printArr(sample, 0, sample.length-1);
    }
}
