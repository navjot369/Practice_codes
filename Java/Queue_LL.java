public class Queue_LL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        static Node head = null;
        static Node tail = null;

        public static boolean isEmpty() {
            return head == null;
        }

        public static void add(int data) {
            Node newNode = new Node(data);
            if(head == null) {
                head = tail = newNode;
            }
            else{
                tail.next = newNode;
                tail = newNode;
            }
        }

        public static int remove() {
            if(isEmpty()) {
                return -1;
            }

            int value = head.data;
            if(head == tail) {
                head = tail = null;
            }
            else {
                head = head.next;
            }
            return value;
        }

        public static int peek() {
            if(isEmpty()) {
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String args[]) {
        Queue.add(1);
        Queue.add(2);
        Queue.add(3);
        Queue.add(5);
        while(!Queue.isEmpty()) {
            System.out.println(Queue.remove());
        }
    }
}
