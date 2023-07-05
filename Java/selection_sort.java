public class selection_sort {
    public static void sort(int arr[]){
        for(int i=0; i<arr.length-1; i++){
            int min = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            if(min != i){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }
    public static void main(String args[]){
        int arr[] = {10, 3, 2, 1, 4, 11};
        sort(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
}
