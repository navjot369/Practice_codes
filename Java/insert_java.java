public class insert_java {
    public static void sort(int arr[]){
        for(int i=1; i<arr.length; i++){
            int current = arr[i];
            int pre = i-1;
            while(pre>=0 && arr[pre] > current){
                arr[pre+1] = arr[pre];
                pre--;
            }
            arr[pre+1] = current;
        }
    }
    public static void main(String args[]){
        int arr[] = {1, 3, 4, 5, 2};
        sort(arr);
        for(int i=0 ;i<arr.length; i++){
            System.out.print(arr[i] + ", ");
        }
        System.err.println();
    }
}