import java.util.Stack;

public class LL_palimdrome {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static boolean isPali(Node head) {
        Stack<Integer> s = new Stack<>();
        Node temp = head;

        while(temp != null) {
            s.push(temp.data);
            temp = temp.next;
        }

        temp = head;
        while(temp != null) {
            if(s.pop() != temp.data) {
                return false;
            }
            temp = temp.next;
        }

        return true;
    }

    public static void main(String args[]) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        System.out.println(isPali(head));
    } 
}
