import java.util.Stack;

public class NextGreaterEle {
    public static void nextEle(int arr[], int result[]) {
        Stack<Integer> s = new Stack<>();
        int len = result.length;

        for(int i = len - 1; i >= 0; i--){ 
            while(!s.isEmpty() && arr[i] >= arr[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()){
                result[i] = -1;
            }
            else{
                result[i] = arr[s.peek()];
            }
            s.push(i);
        }
    }

    public static void main(String args[]) {
        int arr[] = {9, 4, 5, 6, 6, 8};
        int result[] = new int[arr.length];
        nextEle(arr, result);
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
}
