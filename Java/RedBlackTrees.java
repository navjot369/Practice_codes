public class RedBlackTrees {
    static class Node {
        int data;
        char color;
        Node left;
        Node right;
        Node parent;

        public Node(int data){
            this.data = data;
            this.color = 'R';
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }

    public Node root;

    boolean ll = false;
    boolean lr = false;
    boolean rl = false;
    boolean rr = false;

    public void insertNode(int val) {
        if(this.root == null) {
            this.root = new Node(val);
            this.root.color = 'B';
            return ;
        }else {
            this.root = insert(this.root, val);
        }
    }

    public Node rotateLeft(Node root) {
        Node x = root.right;
        Node y = x.left;

        root.right = y;
        x.left = root;

        root.parent = x;
        if(y != null) {
            y.parent = root;
        }
        return x;
    }

    public Node rotateRight(Node root) {
        Node x = root.left;
        Node y = x.right;


        root.left = y;
        x.right = root;

        root.parent = x;
        if(y!=null) {
            y.parent = root;
        }
        return x;
    }

    public  Node insert(Node root, int val) {
        if(root == null) {
            return new Node(val);
        }

        boolean RRissue = false;

        if(val < root.data) {
            root.left = insert(root.left, val);
            root.left.parent = root;
            if(root != this.root) {
                if(root.color == 'R' && root.left.color == 'R'){
                    RRissue = true;
                }
            }
        } else if(val > root.data) {
            root.right = insert(root.right, val);
            root.right.parent = root;
            if(root != this.root) {
                if(root.color == 'R' && root.right.color == 'R') {
                    RRissue = true;
                }
            }
        } else {
            return root;
        }

        if(this.ll) {
            root = rotateRight(root);
            root.color = 'B';
            root.right.color = 'R';
            this.ll = false;
        }
        else if(this.rr) {
            root = rotateLeft(root);
            root.color = 'B';
            root.left.color = 'R';
            this.rr = false;
        }
        else if(this.lr) {
            root.left = rotateLeft(root.left);
            root.left.parent = root;
            root = rotateRight(root);
            root.color = 'B';
            root.right.color = 'R';
            this.lr = false;
        }
        else if(this.rl) {
            root.right = rotateRight(root.right);
            root.right.parent = root;
            root = rotateLeft(root);
            root.color = 'B';
            root.left.color = 'R';
            this.rl = false;
        }

        if(RRissue) {
            if(root.parent.right == root) {
                if(root.parent.left == null || root.parent.left.color == 'B') {
                    if(root.left != null && root.left.color == 'R') {
                        this.rl = true;
                    }
                    else if(root.right != null && root.right.color == 'R') {
                        this.rr = true;
                    }
                }
                else {
                    root.parent.left.color = 'B';
                    root.color = 'B';
                    if(root.parent != this.root) {
                        root.parent.color = 'R';
                    }
                }
            }
            else {
                if(root.parent.right == null || root.parent.right.color == 'B') {
                    if(root.left != null && root.left.color == 'R') {
                        this.ll = true;
                    }
                    else if(root.right != null && root.right.color == 'R') {
                        this.lr = true;
                    }
                }
                else {
                    root.parent.right.color = 'B';
                    root.color = 'B';
                    if(root.parent != this.root) {
                        root.parent.color = 'R';
                    }
                }
            }
            RRissue = false;
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

    public void inOrderTransversal() {
        inOrder(this.root);
    }

    public void preOrderTransversal() {
        preOrder(this.root);
    }
    void printTreeHelper(Node root, int space) {
        int i;
        if(root != null) {
            space = space + 10;
            printTreeHelper(root.right, space);
            System.out.printf("\n");
            for ( i = 10; i < space; i++) {
                System.out.printf(" ");
            }
            System.out.printf("%d (%c)", root.data, root.color);
            System.out.printf("\n");
            printTreeHelper(root.left, space);
        }
    }

    public void printTree() {
        printTreeHelper(this.root, 0);
    }


    public static void main(String args[]) {
        RedBlackTrees t = new RedBlackTrees();

        int arr[] = {1, 4, 6, 3, 5, 7, 8, 2, 9};
        for(int i = 0; i < arr.length; i++){
            t.insertNode(arr[i]);
            t.inOrderTransversal();
            System.out.println();
            t.preOrderTransversal();
            System.out.println();
            System.out.println("<<<<<<ooo>>>>>>>");
        }

        t.printTree();
    }
}
