import java.util.*;

public class ReverseKQueue {
    public static void reverse(Queue<Integer> q, int k) {
        int n = q.size();
        if(k > n) k = n;
        int x = n - k;
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < k; i++){
            s.push(q.remove());
        }
        while(!s.isEmpty()) {
            q.add(s.pop());
        }
        while(x-- > 0) {
            q.add(q.remove());
        }
    }
    //time - O(n + k)
    //space - O(k)


    public static void main(String args[]) {
        Queue<Integer>  q = new ArrayDeque<>();
        for(int i = 10; i < 101; i += 10) {
            q.add(i);
        }
        reverse(q, 13);
        while(!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
    }
}
