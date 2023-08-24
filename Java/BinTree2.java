public class BinTree2 {
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
        int diam;
        int ht;

        public Info(int d, int h)  {
            this.diam = d;
            this.ht = h;
        }
    }

    public static Info diameter(Node root) {
        if(root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);
        int temp_diam = leftInfo.ht + rightInfo.ht + 1;
        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), temp_diam);
        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        return new Info(diam, ht);
    }

    public static boolean isIdentical(Node root, Node subroot) {
        if(root == null && subroot == null) {
            return true;
        } else if(root == null || subroot == null || root.data != subroot.data) {
            return false;
        }

        boolean leftCase = isIdentical(root.left, subroot.left);
        boolean rightCase = isIdentical(root.right, subroot.right);

        return leftCase && rightCase;

    }

    public static boolean isSubtree(Node root, Node subroot) {
        if(root == null) {
            return false;
        }

        if(root.data == subroot.data) {
            if(isIdentical(root, subroot)) {
                return true;
            }
        }

        boolean leftCase = isSubtree(root.left, subroot);
        boolean rightCase = isSubtree(root.right, subroot);

        return leftCase || rightCase;
    }

    public static void getLevel(Node root, int level,int k) {
        if(root == null) {
            return;
        }
        if(level == k) {
            System.out.print(root.data + "  ");
            return;
        }
        getLevel(root.left, level + 1, k);
        getLevel(root.right, level + 1, k);
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(8);

        // System.out.println("Diameter of tree: " + diameter(root).diam);

        Node subroot = new Node(2);
        subroot.left = new Node(4);
        subroot.right = new Node(5);

        getLevel(root, 1, 2);
    }
}
