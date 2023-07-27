public class Stacks_LL {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class Stack {
        public static Node head = null;
        public boolean isEmpty() {
            return head == null;
        }

        public void push(int data) {
            Node newNode = new Node(data);
            if(head == null) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
            return;
        }

        public int pop() {
            if(head == null) {
                return -1;
            }
            int data = head.data;
            head = head.next;
            return data;
        }

        public int peep() {
            if(isEmpty()) {
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String args[]) {
        Stack list = new Stack();
        System.out.println(list.pop());
        list.push(1);
        list.push(2);
        list.push(4);
        list.push(5);
        System.out.println(list.peep());
        System.out.println(list.pop());
        System.out.println(list.peep());

    }
}
