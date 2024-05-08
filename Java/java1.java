import java.util.*;

public class java1 {
    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int v) {
            this.val = v;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int val) {
        if(root == null) {
            return new Node(val);
        }

        if(root.val >= val) {
            root.left = insert(root.left, val);
        }
        if(root.val < val) {
            root.right = insert(root.right, val);
        }

        return root;
    }
}