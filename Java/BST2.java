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

    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxBST = 0;

    public static Info largestBST(Node root) {
        if(root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if(leftInfo.max >= root.data || rightInfo.min <= root.data) {
            return new Info(false, size, min, max);
        }

        if(leftInfo.isBST && rightInfo.isBST) {
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);

    }

    public static Node mergeBST(Node root1, Node root2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        getInorder(root1, list1);
        getInorder(root2, list2);

        ArrayList<Integer> finalList = new ArrayList<>();
        int i = 0, j = 0;
        while(i < list1.size() && j < list2.size()) {
            if(list1.get(i) < list2.get(j)){
                finalList.add(list1.get(i));
                i++;
            } else {
                finalList.add(list2.get(j));
                j++;
            }
        }
        while(i < list1.size()) {
            finalList.add(list1.get(i));
            i++;
        }
        while(j < list2.size()) {
            finalList.add(list2.get(j));
            j++;
        }

        return ALtoBST(finalList, 0, finalList.size() - 1);
    }

    public static void main(String args[]) {
        // To create a BST from sorted array.
        // int arr[] = {1, 3, 4, 5, 6, 8, 10, 11};
        // Node root = createBST(arr, 0, arr.length - 1);

        // preOrder(root);
        // System.out.println();
        // inOrder(root);
        // System.out.println();

        // <<<<<<<<<<<<<<<<<ooo>>>>>>>>>>>>>>>
        //To convert a BST to balanced BST.
        //A balanced BST is one which have minimum height.
        // Node root = new Node(8);
        // root.left = new Node(6);
        // root.left.left = new Node(5);
        // root.left.left.left = new Node(3);
        // root.right = new Node(10);
        // root.right.right = new Node(11);
        // root.right.right.right = new Node(12);

        // preOrder(root);
        // System.out.println();
        // inOrder(root);
        // System.out.println();
        // System.out.println("<<<<<<<<<<---->>>>>>>>>>>");

        // root = balancedBST(root);

        // preOrder(root);
        // System.out.println();
        // inOrder(root);
        // System.out.println();

        //<<<<<<<<<<<ooo>>>>>>>>>>>>>>
        //To find largest BST in a given Binary Tree.
        // Node root = new Node(50);
        // root.left = new Node(30);
        // root.right = new Node(60);
        // root.left.left = new Node(5);
        // root.left.right = new Node(20);
        // root.right.left = new Node(45);
        // root.right.right = new Node(70);
        // root.right.right.left = new Node(65);
        // root.right.right.right = new Node(80);

        // largestBST(root);
        // System.out.println(maxBST);

        //<<<<<<<<<<<<ooo>>>>>>>>>>>>>
        //Given two BST, merge them to a balanced BST.
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node root = mergeBST(root1, root2);

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
    }
}
