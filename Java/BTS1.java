import java.util.ArrayList;

public class BTS1 {
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

    public static Node insert(Node root, int val) {
        if(root == null) {
            return new Node(val);
        }

        if(val < root.data) {
            root.left = insert(root.left, val);
        }
        else if(val > root.data) {
            root.right = insert(root.right, val);
        }

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

    public static boolean search(Node root, int val) {
        if(root == null) {
            return false;
        }
        if(root.data == val) {
            return true;
        }
        else if(root.data > val) {
            return search(root.left, val);
        } else {
            return search(root.right, val);
        }
    }

    public static Node deleteNode(Node root, int val) {
        if(root == null) {
            return null;
        }
        if(root.data == val) {
            if(root.left == null && root.right == null) {
                return null;
            } else if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            } else {
                int IS = inOrderSuccesor(root.right);
                root.data = IS;
                root.right = deleteNode(root.right, IS);
            }
        } else if(root.data > val) {
            root.left = deleteNode(root.left, val);
        } else {
            root.right = deleteNode(root.right, val);
        }

        return root;
    }

    public static int inOrderSuccesor(Node root) {
        while(root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    public static void printInRange(Node root, int k1, int k2) {
        if(root == null) {
            return;
        }

        if(k1 <= root.data && root.data <= k2) {
            printInRange(root.left, k1 , k2);
            System.out.print(root.data + "  ");
            printInRange(root.right, k1, k2);
        } else if(root.data < k1) {
            printInRange(root.right, k1, k2);
        } else {
            printInRange(root.left, k1, k2);
        }
    }

    public static void printPath(ArrayList<Node> path) {
        for(int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i).data + " -> ");
        }
        System.out.println("Null");
    }

    public static void getPath(Node root, ArrayList<Node> path) {
        if(root == null) {
            return;
        }

        path.add(root);
        if(root.left == null && root.right == null) {
            printPath(path);
        }

        getPath(root.left, path);
        getPath(root.right, path);

        path.remove(path.size() - 1);
    }

    public static boolean isValid(Node root, Node min, Node max) {
        if(root == null) {
            return true;
        }

        if(min != null && root.data <= min.data) {
            return false;
        }
        if(max != null && root.data >= max.data) {
            return false;
        }

        return isValid(root.left, min, root) && isValid(root.right, root, max);
    }

    public static Node mirrorBST(Node root) {
        if(root == null) {
            return null;
        }

        Node left = mirrorBST(root.left);
        Node right = mirrorBST(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public static void main(String args[]) {
        Node root = new Node(8); 
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);
        root.left.left.left = new Node(1);
        root.left.left.right = new Node(4);

        // Node root = null;

        // int arr[] = {5 ,1, 2, 3, 7, 10, 11, 12, 8};
        // for(int i = 0; i < arr.length; i++) {
        //     root = insert(root, arr[i]);
        // }

        inOrder(root);
        System.out.println("\n-----");

        // Search(root, 5);

        // for(int i = 0; i < arr.length; i++) {
        //     root = deleteNode(root, i);
        //     inOrder(root);
        //     System.out.println();
        // }

        // printInRange(root, 10, 15);

        // getPath(root, new ArrayList<>());

        // System.out.println(isValid(root, null, null));

        root = mirrorBST(root);
        inOrder(root);
        System.out.println();
    }
}