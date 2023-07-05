public class quick_sort {
    public static void sort(int arr[], int si, int ei){
        if(si>=ei){
            return;
        }
        int index = si-1;
        int pivot = arr[ei];
        for(int i=si; i<=ei;  i++){
            if(arr[i]<=pivot){
                index++;
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
        printArr(arr);
        sort(arr, si, index-1);
        sort(arr, index+1, ei);
    }
    public static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            if(i==arr.length-1){
                System.out.println(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
    }
    public static void main(String args[]){
        int sample[] = {6, 5, 4, 1, 2, 3};
        sort(sample, 0, sample.length-1);
        printArr(sample);
    }
}
