import java.util.*;

public class Queue2Stacks {
    static class Queue {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        public boolean isEmpty() {
            return s1.isEmpty();
        }

        public void add(int data) {
            s1.push(data);
        }

        public int remove() {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            int res= s2.pop();

            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }

            return res;
        }

        public int peek() {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            int res= s2.peek();

            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }

            return res;
        }
    }

    public static void main(String args[]) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
