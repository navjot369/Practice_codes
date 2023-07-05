public class reverse_sort {
    int num = 5;
    public static void bubble(int arr[]){
        for(int i=arr.length-2; i>=0; i--){
            for(int j=0; j<=i; j++){
                if(arr[j+1]>arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public static void selection(int arr[]){
        for(int i=0; i<arr.length-1; i++){
            int largest = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j]>arr[largest]){
                    largest = j;
                }
            }
            if(i!=largest){
                int temp = arr[i];
                arr[i] = arr[largest];
                arr[largest] = temp;
            }
        }
    }
    public static void insertion(int arr[]){
        for(int i=1; i<arr.length; i++){
            int cur = arr[i];
            int pre = i-1;
            while(pre>=0 && arr[pre] > cur){
                arr[pre+1] = arr[pre];
                pre--;
            }
            pre++;
            arr[pre] =cur;
        }
    }
    public static void counting(int arr[]){
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>largest){
                largest = arr[i];
            }
        }
        int count[] = new int[largest+1];
        for(int i=0; i<arr.length; i++){
            count[arr[i]]++;
        }
        int index = 0;
        for(int i=count.length-1; i>=0; i--){
            while(count[i]>0){
                arr[index] = i;
                index++;
                count[i]--;
            }
        }
    }
    public static void main(String args[]){
        int sample[] = {45, 17, 89, 32, 57, 74, 6, 93, 20, 63, 11, 38, 82, 51, 99, 24, 76, 42, 68, 28};
        // bubble(sample);
        // selection(sample);
        // insertion(sample);
        counting(sample);
        for(int i=0; i<sample.length; i++){
            System.out.print(sample[i] + ", ");
        }
    }
}
