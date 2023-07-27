import java.util.ArrayList;

//Implementing using ArrayList.

public class Stacks_Alist {
    static class Stack {
        static ArrayList<Integer> list = new ArrayList<>();
        public static boolean isEmpty() {
            return list.size() == 0;
        }

        public void push(int data) {
            list.add(data);
        }

        public int pop() {
            if(isEmpty()) {
                return -1; //Any invalid value;
            }
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        public int peep() {
            if(isEmpty()) {
                return -1;
            }

            return list.get(list.size() - 1);
        }
    }

    public static void main(String args[]) {
        Stack s = new Stack();
        s.push(1);
        s.push(3);
        s.push(8);
        s.push(4);

        System.out.println(s.pop());
        System.out.println(s.peep());
        System.out.println(s.pop());
    }
}
