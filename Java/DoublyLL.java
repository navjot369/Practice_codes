public class DoublyLL {
    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        if(size == 0) {
            head = tail = new Node(data);
            size++;
            return;
        }
        Node newNode = new Node(data);
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        size++;
    }

    public void addLast(int data) {
        if(size == 0) {
            head = tail = new Node(data);
            size++;
            return;
        }
        Node newNode = new Node(data);
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    public int removeFirst() {
        if(size == 0) return Integer.MIN_VALUE;
        int data = head.data;
        head = head.next;
        if(size == 1) tail = null;
        if(size > 1) head.prev = null;
        size--;
        return data;
    }

    public int removeLast() {
        if(size == 0) return Integer.MIN_VALUE;
        int data = tail.data;
        tail = tail.prev;
        if(size == 1) head = null;
        if(size > 1) tail.next = null;
        size--;
        return data;
    }
    
    public void reverse1() {
        Node curr = head;
        tail = head;
        Node prev = null;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void reverse2() {
        Node loop = head;
        Node temp = head;
        head = tail;
        tail = temp;

        while(loop != null) {
            temp = loop.prev;
            loop.prev = loop.next;
            loop.next = temp;
            loop = loop.prev;
        }
    }

    public void print() {
        Node temp = head;
        System.out.print(size + " : null <-> ");
        while(temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String args[]) {
        DoublyLL dllist = new DoublyLL();
        dllist.addFirst(2);
        dllist.addFirst(3);
        dllist.addLast(5);
        dllist.addLast(9);
        dllist.print();
        // System.out.println(dllist.removeFirst());
        // dllist.reverse1();
        dllist.print();
        System.out.println(head.data + " " + tail.data);
        dllist.reverse2();
        dllist.print();
        System.out.println(head.data + " " + tail.data);

    }
}