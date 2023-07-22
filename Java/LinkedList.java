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
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if(size == 0) {
            return Integer.MIN_VALUE;
        }
        if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node prev = head;
        for(int i = 0; i < size - 2; i++) {
            prev = prev.next;
        } 
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public void print() {
        Node temp = head;
        System.out.print(size + " : ");
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println(" null");
    }

    public int itrSearch(int key) {
        Node temp = head;
        int i = 0;
        while(temp != null) {
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public int helper(Node head, int key) { //this is actual recursive search function.
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx == -1) return -1;
        return idx + 1;
    }

    public int recrSearch(int key) {
        return helper(head, key);
    }

    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public void remNendNode(int n) {
        int sz = 0;
        Node temp = head;
        while(temp != null) {
            temp = temp.next;
            sz++;
        }
        if(n == sz){
            head = head.next;
            size--;
            return;
        }
        int indPrev = sz - n;
        int i = 1;
        Node prev = head;
        while(i < indPrev) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        if(n == 1) {
            tail = prev;
        }
        size--;
        return;
    }

    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean checkPalimdrome() {
        if(head == null || head.next == null) {
            return true;
        }

        Node midNode = findMid(head);

        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        while(right != null) {
            if(left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public void addNodeLoop(int ind, int data) {
        Node temp = head;
        for(int i = 0; i < ind; i++){
            temp = temp.next;
        }
        Node newNode = new Node(data);
        tail.next = newNode;
        newNode.next = temp;
        tail = null;
        size++;
    }

    public boolean isLoop() {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    public Node mergeSort(Node Mhead) {
        if(Mhead == null || Mhead.next == null) {
            return Mhead;
        }
        Node slow = Mhead;
        Node fast = Mhead.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node Lhead = Mhead;
        Node Rhead = slow.next;
        slow.next = null;
        Node newLhead = mergeSort(Lhead);
        Node newRhead = mergeSort(Rhead);
        Node Newhead = mergeList(newLhead, newRhead);
        return Newhead;
    }

    public Node mergeList(Node Lhead, Node Rhead) {
        Node MergeList = new Node(-1);
        Node temp = MergeList;
        while(Lhead != null && Rhead != null) {
            if(Lhead.data <= Rhead.data) {
                temp.next = Lhead;
                temp = Lhead;
                Lhead = Lhead.next;
            }
            else {
                temp.next = Rhead;
                temp = Rhead;
                Rhead = Rhead.next;
            }
        }
        while(Lhead != null) {
            temp.next = Lhead;
            temp = Lhead;
            Lhead = Lhead.next;
        }
        while(Rhead != null) {
            temp.next = Rhead;
            temp = Rhead;
            Rhead = Rhead.next;
        }
        return MergeList.next;
    }

    public void removeLoop() {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                slow = head;
                Node last = null;
                while(slow != fast) {
                    last = fast;
                    slow = slow.next;
                    fast = fast.next;
                }
                last.next = null;
                tail = last;
            }
        }
    }

    public void ZigZag() {
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = null;
        Node curr = slow.next;
        Node next;
        slow.next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node Lhead = head;
        Node Rhead = prev;
        Node nextL, nextR;
        while(Lhead !=null && Rhead != null) {
            nextL = Lhead.next;
            nextR = Rhead.next;
            Lhead.next = Rhead;
            Rhead.next = nextL;
            Lhead = nextL;
            Rhead = nextR;
        }
    }

    public static void main(String args[]) {
        LinkedList list = new LinkedList();
        list.addFirst(9);
        list.addLast(11);
        list.addLast(7);
        list.addLast(6);
        list.addLast(10);
        list.addLast(12);
        list.print();
        head = list.mergeSort(head);
        list.print();
        list.ZigZag();
        list.print();
    }
}
