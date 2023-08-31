public class BSTinBT {
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
        boolean isBST;
        int sum;

        public Info(boolean isBST, int sum) {
            this.isBST = isBST;
            this.sum = sum;
        }
    }

    static int maxSum = 0;
    public static Info maxBST(Node root, int min, int max) {
        if(root == null) {
            return new Info(true, 0);
        }

        Info left = maxBST(root.left, min, root.data);
        Info right = maxBST(root.right, root.data, max);

        int sum = root.data + left.sum + right.sum;

        if(left.isBST && right.isBST) {
            maxSum = Math.max(maxSum, sum);
            if(root.data > min && root.data < max) {
                return new Info(true, sum);
            }
        }
        return new Info(false, sum);
    }

    public static int maxBSTinBT(Node root) {
        maxSum = 0;

        maxBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

        return maxSum;
    }

    public static void main(String args[]) {
        Node root = new Node(5);
        root.left = new Node(9);
        root.right = new Node(2);
        root.left.left = new Node(6);
        root.left.left.left = new Node(5);
        root.left.left.right = new Node(7);
        root.right.right = new Node(3);

        System.out.println(maxBSTinBT(root));
    }
}
