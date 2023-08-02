import java.util.Stack;

public class TrapRainStack {
    public static int totalWater(int arr[]) {
        Stack<Integer> s = new Stack<>();
        int ans = 0;
        for(int i = 0; i < arr.length; i++) {
            while(!s.isEmpty() && arr[s.peek()] < arr[i]) {
                int popHeight = arr[s.pop()];
                if(s.isEmpty()) break;
                int distance = i - s.peek() - 1;
                int min_height = Math.min(arr[i], arr[s.peek()]) - popHeight;
                int curr = distance * min_height;
                ans += curr;
            }
            s.push(i);
        }
        return ans;
    }

    public static void main(String args[]) {
        int[] arr = {0, 0, 4, 2, 5, 0, 6, 4, 0, 5};
        int ans = totalWater(arr);
        System.out.println(ans);
    }
}
