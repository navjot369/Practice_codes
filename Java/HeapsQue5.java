import java.util.*;

public class HeapsQue5 {
    static class Node implements Comparable<Node> {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public int compareTo(Node node) {
            return this.data - node.data;
        }
    }

    public static Node mergeList(Node arr[]) {
        Node ans = new Node(-1);
        Node temp = ans;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(Node n:arr) {
            if(n != null) {
                pq.add(n);
            }
        }

        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            if(curr.next != null) {
                pq.add(curr.next);
            }
            ans.next = curr;
            ans = ans.next;
        }

        return temp.next;
    }

    public static void main(String args[]) {
        Node node1 = new Node(1);
        node1.next = new Node(3);
        node1.next.next = new Node(7);

        Node node2 = new Node(2);
        node2.next = new Node(4);
        node2.next.next = new Node(8);

        Node node3 = new Node(9);
        node3.next = new Node(10);
        node3.next.next = new Node(11);

        Node arr[] = {node1, node2, node3};

        Node answer = mergeList(arr);

        while(answer != null) {
            System.out.print(answer.data + " -> ");
            answer = answer.next;
        }
        System.out.println("NULL");
    }
}
