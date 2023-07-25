public class InsertionNode {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node getInsertion(Node head1, Node head2) {
        while(head1 != null) {
            Node temp = head2;
            while(temp != null) {
                if(temp == head1) {
                    return head1;
                }
                temp = temp.next;
            }
            head1 = head1.next;
        }
        return null;
    }



    public static void main(String args[]) {
        Node head1, head2;

        Node newNode = new Node(2);
        head1 = newNode;

        newNode = new Node(3);
        head2 = newNode;

        newNode = new Node(4);
        head1.next = newNode;

        newNode = new Node(5);
        head1.next.next = newNode;
        head2.next = newNode;

        newNode = new Node(6);
        head2.next.next = newNode;

        head2.next.next.next = null;

        System.out.println(getInsertion(head1, head2).data);
    }
}
