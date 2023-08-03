import java.util.*;

public class Stacks2Queues {
    public static class Stack {
        // static Queue<Integer> q1 = new LinkedList<>();
        // static Queue<Integer> q2 = new LinkedList<>();
        static Queue<Integer> q1 = new ArrayDeque<>();
        static Queue<Integer> q2 = new ArrayDeque<>();

        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void push(int data) {
            if(q1.isEmpty()) {
                q1.add(data);
                while(!q2.isEmpty()) {
                    q1.add(q2.remove());
                }
            }
            else {
                q2.add(data);
                while(!q1.isEmpty()) {
                    q2.add(q1.remove());
                }
            }
        }

        public static int pop() {
            if(isEmpty()) {
                return -1;
            }
            if(!q1.isEmpty()) {
                return q1.remove();
            }
            else{
                return q2.remove();
            }
        }

        public static int peek() {
            if(isEmpty()) {
                return -1;
            }

            if(!q1.isEmpty()) {
                return q1.peek();
            }
            else{
                return q2.peek();
            }
        }
    }

    public static void main(String args[]) {
        Stack.push(1);
        Stack.push(2);
        Stack.push(3);
        Stack.push(4);

        while(!Stack.isEmpty()) {
            System.out.println(Stack.peek());
            Stack.pop();
        }
    }
}