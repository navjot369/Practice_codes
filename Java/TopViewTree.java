import java.util.*;

public class TopViewTree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int d) {
            this.data = d;
            this.left = null;
            this.right = null;
        }
    }

    static class Info {
        Node node;
        int hd;

        public Info(Node  node, int dis) {
            this.node = node;
            this.hd = dis;
        }
    }

    public static void topView(Node root) {
        // Queue<Info> q = new LinkedList<>();
        Queue<Info> q = new ArrayDeque<>();
        HashMap<Integer, Node> map = new HashMap<>();

        q.add(new Info(root, 0));
        q.add(null);
        int min = 0, max = 0;

        while(!q.isEmpty()) {
            Info curr = q.remove();
            if(curr == null) {
                if(q.isEmpty()){
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if(!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                }
                if(curr.node.left != null) {
                    q.add(new Info(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }
                if(curr.node.right != null){
                    q.add(new Info(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }
            }
        }

        for(int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + "  ");
        }
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        topView(root);
    }
}
