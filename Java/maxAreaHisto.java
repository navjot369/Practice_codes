import java.util.Stack;

public class maxAreaHisto {
    public static int maxArea(int arr[]) {
        int len = arr.length;
        Stack<Integer> s = new Stack<>();
        int leftSmaller[] = new int[len];
        int rightSmaller[] = new int[len];

        for(int i = 0; i < len; i++) {
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                leftSmaller[i] = -1;
            }
            else{
                leftSmaller[i] = s.peek();
            }
            s.push(i);
        }
        while(!s.isEmpty()) {
            s.pop();
        }

        for(int i = len - 1; i >= 0; i--) {
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                rightSmaller[i] = len;
            }
            else {
                rightSmaller[i] = s.peek();
            }
            s.push(i);
        }

        int ans = 0;
        for(int i = 0; i < len; i++) {
            int width = rightSmaller[i] - leftSmaller[i] - 1;
            int currArea = width * arr[i];
            if(currArea > ans) {
                ans = currArea;
            }
        }

        return ans;
    }

    public static void main(String args[]) {
        int arr[] = {2, 1, 6, 6, 2, 3};
        System.out.println(maxArea(arr));
    }
}
