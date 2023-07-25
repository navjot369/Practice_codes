public class CircularLL {
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node last;
    public static int size;

    public void firstNode(int data) {
        if(last != null) {
            return;
        }
        Node newNode = new Node(data);
        last = newNode;
        last.next = last;
        size++;
        return;
    }

    public void addAfter(int data) {
        if(last == null) {
            firstNode(data);
            return;
        }
        Node newNode = new Node(data);
        newNode.next = last.next;
        last.next = newNode;
        last = newNode;
        size++;
    }

    public void addMiddle(int key, int data) {
        if(last == null) {
            return;
        }
        if(last.data == key) {
            addAfter(data);
        }
        Node temp = last;
        do {
            if(temp.next.data == key) {
                Node newNode = new Node(data);
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        } while(temp != last);
    }

    public int delete(int key) {
        if(last == null) {
            return Integer.MIN_VALUE;
        }
        Node temp = last;
        do {
            if(temp.next.data == key) {
                if(temp.next == last) {
                    last = temp;
                }
                int data = temp.next.data;
                temp.next = temp.next.next;
                size--;
                return data;
            }
            temp = temp.next;
        } while (temp != last);
        return -1;
    }

    public void print() {
        System.out.print(size + " : ... ");
        Node temp = last;
        do {
            temp = temp.next;
            System.out.print(temp.data + " > ");
        } while(temp != last);
        System.out.println("...");
    }

    public static void main(String args[]) {
        CircularLL ll = new CircularLL();
        ll.addAfter(1);
        ll.addAfter(3);
        ll.addAfter(4);
        ll.addMiddle(1, 2);
        ll.print();
        System.out.println(last.data);
        ll.delete(2);
        ll.print();
        System.out.println(last.data);
    }
}
