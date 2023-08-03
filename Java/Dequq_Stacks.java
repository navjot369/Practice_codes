import java.util.*;

public class Dequq_Stacks {
    static class Stack {
        Deque<Integer> dq = new ArrayDeque<>();

        public void push(int data) {
            dq.addLast(data);
        }

        public int pop() {
            return dq.removeLast();
        }

        public int peek() {
            return dq.getLast();
        }
    }

    public static void main(String args[]) {
        Stack s = new Stack();
        s.push(1);
        s.push(5);
        s.push(8);
        System.out.println(s.pop());
        System.out.println(s.peek());
    }
}
