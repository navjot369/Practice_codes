public class counting_sort {
    // It is used where range is short.
    public static void sort(int arr[]){
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i] > largest)largest = arr[i];
        }
        int count[] = new int[largest+1];
        for(int i=0; i<arr.length; i++){
            count[arr[i]]++;
        }
        int index = 0;
        for(int i=0; i<count.length; i++){
            while(count[i]>0){
                arr[index] = i;
                index++;
                count[i]--;
            }
        }
    }
    public static void main(String args[]){
        int arr[] = {6, 4, 3, 2, 1, 5};
        sort(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + ", ");
        }
    }
}
