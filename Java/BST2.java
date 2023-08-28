import java.util.ArrayList;

public class BST2 {
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

    public static Node createBST(int arr[], int st, int end) {
        if(st > end) {
            return null;
        }

        int mid = (st + end)/2;
        Node root = new Node(arr[mid]);
        root.left = createBST(arr, st, mid - 1);
        root.right = createBST(arr, mid + 1, end);
        return root;
    }

    public static void preOrder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data + "  ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {
        if(root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + "  ");
        inOrder(root.right);
    }

    public static void getInorder(Node root, ArrayList<Integer> list) {
        if(root == null) {
            return;
        }

        getInorder(root.left, list);
        list.add(root.data);
        getInorder(root.right, list);
    }

    public static Node ALtoBST(ArrayList<Integer> list, int st, int end) {
        if(st > end) {
            return null;
        }

        int mid = (st + end)/2;
        Node root = new Node(list.get(mid));
        root.left = ALtoBST(list, st, mid - 1);
        root.right = ALtoBST(list, mid + 1, end);
        return root;
    }

    public static Node balancedBST(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        getInorder(root, list);

        return ALtoBST(list, 0, list.size() - 1);
    }

    public static void main(String args[]) {
        // To create a BST from sorted array.
        // int arr[] = {1, 3, 4, 5, 6, 8, 10, 11};
        // Node root = createBST(arr, 0, arr.length - 1);

        // preOrder(root);
        // System.out.println();
        // inOrder(root);
        // System.out.println();

        //To convert a BST to balanced BST.
        //A balanced BST is one which have minimum height.
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);
        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        System.out.println("<<<<<<<<<<>>>>>>>>>>>");

        root = balancedBST(root);

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();


    }
}
