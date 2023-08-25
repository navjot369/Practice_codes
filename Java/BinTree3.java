import java.util.HashMap;

public class BinTree3 {
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

    public static boolean isMirrorTree(Node root1, Node root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 == null || root2 == null) {
            return false;
        }

        if(root1.data != root2.data) {
            return false;
        }

        boolean way1 = isMirrorTree(root1.left, root2.right);
        boolean way2 = isMirrorTree(root1.right, root2.left);

        if(way1 && way2) {
            return true;
        } else {
            return false;
        }
    }

    public static Node makeMirror(Node root) {
        if(root == null) {
            return root;
        }

        Node left = makeMirror(root.left);
        Node right = makeMirror(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public static void inOrder(Node root) {
        if(root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + "  ");
        inOrder(root.right);
    }

    public static Node deleteleaf(Node root, int x) {
        if(root == null) {
            return null;
        }
        if(root.left == null && root.right == null && root.data == x) {
            return null;
        }

        root.left = deleteleaf(root.left, x);
        root.right = deleteleaf(root.right, x);

        return root;
    }

    static HashMap<String, Integer> m;
    public static String duplicateSubtree(Node root) {
        if(root == null) {
            return "";
        }

        String str = "(";
        str += duplicateSubtree(root.left);
        str += Integer.toString(root.data);
        str += duplicateSubtree(root.right);
        str += ")";

        if(m.containsKey(str)) {
            if(m.get(str) == 1) {
                System.out.print(root.data + " ");
            }
            m.put(str, m.get(str) + 1);
        } else {
            m.put(str, 1);
        }

        return str;
    }

    public static void getduplicate(Node root) {
        m = new HashMap<>();
        duplicateSubtree(root);
    }

    public static int maxSum;
    public static int getmaxPath(Node root) {
        maxSum = 0;
        maxPath(root);
        return maxSum;
    }

    public static int maxPath(Node root) {
        if(root == null) {
            return 0;
        }

        int left = maxPath(root.left);
        int right = maxPath(root.right);

        maxSum = Math.max(Math.max(left + right + root.data, root.data), maxSum);

        return (Math.max(left, right) + root.data);
    }

    public static void main(String args[]) {
        Node root1 = new Node(1);
        root1.left = new Node(4);
        root1.right = new Node(3);
        root1.left.left = new Node(3);
        root1.right.left = new Node(4);
        root1.right.right = new Node(3);
        root1.right.left.left = new Node(3);

        Node root2 = new Node(4);
        root2.left = new Node(2);
        root2.right = new Node(7);
        // root2.left.left = new Node(3);
        // root2.left.right = new Node(2);
        // root2.right.left = new Node(5);
        // root2.right.right = new Node(4);

        Node root3 = new Node(-10);
        root3.left = new Node(9);
        root3.right = new Node(20);
        root3.right.left = new Node(15);
        root3.right.right = new Node(7);

        // System.out.println("Is mirror tree: " + isMirrorTree(root1, root2));

        // inOrder(root1);
        // System.out.println();
        // makeMirror(root1);
        // inOrder(root1);
        // System.out.println();

        // inOrder(root2);
        // System.out.println();
        // deleteleaf(root2, 3);
        // inOrder(root2);
        // System.out.println();

        // getduplicate(root1); // Function to get all duplicate subtrees.

        System.out.println(getmaxPath(root2));

    }
}
