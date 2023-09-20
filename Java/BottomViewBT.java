import java.util.*;

public class BottomViewBT {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Info {
        int data;
        int depth;

        public Info(int d, int dep) {
            this.data = d;
            this.depth = dep;
        }
    }

    static HashMap<Integer, Info> hm;
    static int min, max;

    public static void getBottom(Node root, int pos, int depth) {
        if(root == null) {
            return;
        }
        min = Math.min(min, pos);
        max = Math.max(max, pos);

        if(hm.containsKey(pos)) {
            if(hm.get(pos).depth < depth) {
                hm.put(pos, new Info(root.data, depth));
            }
        }else {
            hm.put(pos, new Info(root.data, depth));
        }
        
        getBottom(root.left, pos - 1, depth + 1);
        getBottom(root.right, pos + 1, depth + 1);
    }

    public static void BottomView(Node root) {
        hm = new HashMap<>();
        min = 0;
        max = 0;
        getBottom(root, 0, 0);
    }

    public static void main(String args[]) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right = new Node(22);
        root.right.left = new Node(13);
        root.right.right = new Node(25);

        BottomView(root);

        for(int i = min; i <= max; i++) {
            System.out.print(hm.get(i).data + "  ");
        }
        System.out.println();
    }
}