public class bubble_sort {
    public static void sort(int arr[]){
        int turn = 0;
        for(int i=arr.length-2; i>=0; i--){
            turn++;
            int swap = 0; //To make code more optimized, it will check if any swaps 
            // are occured in our array, if no swaps are there it means that our 
            // array is already sorted.
            for(int j=0; j<=i; j++){
                if(arr[j+1]<arr[j]){
                    swap++;
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.print(turn + " >>   ");
            print_arr(arr);
            if(swap==0)return;
        }
    }
    public static void print_arr(int arr[]){
        for(int i=0; i<arr.length; i++){
            if(i==arr.length-1){
                System.out.println(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
    }
    public static void main(String args[]){
        int arr[] = {6, 1, 2, 3, 4, 5};
        sort(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + ", ");
        }
    }
}
