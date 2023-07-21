public class LinkedList {
    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public  void addMid(int ind, int data) {
        Node temp = head;
        if(ind == 0){
            addFirst(data);
            return;
        }
        for(int i = 0; i < ind - 1; i++){
            temp = temp.next;
            if(temp.next == null){
                addLast(data);
                return;
            }
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public int removeFirst() {
        if(size == 0){
            return Integer.MIN_VALUE;
        }
        if(size == 1){
            
        }
    }
    public void print() {
        Node temp = head;
        System.out.print(size + " : ");
        while(temp != null) {
            System.out.print(temp.data + " ->");
            temp = temp.next;
        }
        System.out.println(" null");
    }


    public static void main(String args[]) {
        LinkedList list = new LinkedList();
        list.head = new Node(1);
        list.tail = list.head;
        list.print();
        list.addFirst(3);
        list.print();
        list.addLast(5);
        list.print();
        list.addMid(8, 9);
        list.print();
        list.addLast(2);
        list.print();
    }
}
