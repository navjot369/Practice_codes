public class AVLtrees {
    static class Node {
        int data, height;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.height = 1;
            this.left = null;
            this.right = null;
        }
    }

    public static Node rotateLeft(Node root) {
        Node x = root.right;
        Node y = x.left;

        root.right = y;
        x.left = root;

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    public static Node rotateRight(Node root) {
        Node x = root.left;
        Node y = x.right;

        root.left = y;
        x.right = root;

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    public static int height(Node root) {
        if(root == null){
            return 0;
        }

        return root.height;
    }

    public static int balancedFactor(Node root) {
        if(root == null) {
            return 0;
        }

        return height(root.left) - height(root.right);
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
        } else {
            return root;
        }

        root.height = Math.max(height(root.left), height(root.right)) + 1;

        int bf = balancedFactor(root);

        if(bf > 1 && val < root.left.data) {
            return rotateRight(root);
        }
        if(bf > 1 && val > root.left.data) {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }
        if(bf < -1 && val > root.right.data) {
            return rotateLeft(root);
        }
        if(bf < -1 && val < root.right.data) {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }

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

    public static Node inOrderSuccesor(Node root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static Node deleteNode(Node root, int val) {
        if(root == null) {
            return null;
        }

        if(val < root.data) {
            root.left = deleteNode(root.left, val);
        }
        else if(val > root.data) {
            root.right = deleteNode(root.right, val);
        }
        else {
            if(root.left == null && root.right == null) {
                root = null;
            }
            else if(root.left == null || root.right == null) {
                if(root.left == null) {
                    root = root.right;
                }else {
                    root = root.left;
                }
            }
            else {
                Node temp = inOrderSuccesor(root.right);
                root.data = temp.data;
                root.right = deleteNode(root.right, temp.data);
            }
        }

        if(root == null) {
            return null;
        }

        root.height = Math.max(height(root.left), height(root.right)) + 1;

        int bf = balancedFactor(root);

        if(bf > 1 && balancedFactor(root.left) >= 0) {
            return rotateRight(root);
        }

        if(bf > 1 && balancedFactor(root.left) < 0) {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }

        if(bf < -1 && balancedFactor(root.right) <= 0) {
            return rotateLeft(root);
        }

        if(bf < -1 && balancedFactor(root.right) > 0) {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }

        return root;
    }
    public static void main(String args[]) {
        Node root = null;
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root =  insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();

        int arr[] = {50, 40, 20, 30 ,45};
        for(int i = 0; i < arr.length; i++) {
            root = deleteNode(root, arr[i]);
            preOrder(root);
            System.out.println();
            inOrder(root);
            System.out.println();
            System.out.println("<<<<<<>>>>>>>>");
        }
    }
}
