import java.util.*;

public class BinTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int ind = -1;
        public Node MakeTreePre(int nodes[]) {
            ind++;
            if(nodes[ind] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[ind]);
            newNode.left = MakeTreePre(nodes);
            newNode.right = MakeTreePre(nodes);

            return newNode;
        }

        public void printPreOrder(Node root) {
            if(root == null) {
                return;
            }
            System.out.print(root.data + ", ");
            printPreOrder(root.left);
            printPreOrder(root.right);
        }

        public void printInOrder(Node root) {
            if(root == null) {
                return;
            }

            printInOrder(root.left);
            System.out.print(root.data + ", ");
            printInOrder(root.right);
        }

        public void printPostOrder(Node root) {
            if(root == null) {
                return;
            }
            printPostOrder(root.left);
            printPostOrder(root.right);
            System.out.print(root.data + ", ");
        }

        public void printLevelOrder(Node root) {
            if(root == null) {
                return;
            }

            Queue<Node> q  = new ArrayDeque<>();
            // Queue<Node> q = new LinkedList<>();
            //Correct code will work, if this line is added and
            //line of ArrayDeque is commented.
            q.add(root);
            q.add(null);
            while(!q.isEmpty()) {
                Node currNode = q.remove();
                if(currNode == null) {
                    System.out.println();
                    if(q.isEmpty()) {
                        break;
                    }
                    else {
                        q.add(null);
                    }
                }
                else {
                    System.out.print(currNode.data + "  ");
                    if(currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if(currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }

        public int getHeight(Node root) {
            if(root == null) {
                return 0;
            }

            int leftH = getHeight(root.left);
            int rightH = getHeight(root.right);
            return Math.max(leftH, rightH) + 1;
        }

        public int countNodes(Node root) {
            if(root == null) {
                return 0;
            }

            int leftCount = countNodes(root.left);
            int rightCount = countNodes(root.right);
            return leftCount + rightCount + 1;
        }

        public int sumofNodes(Node root) {
            if(root == null) {
                return 0;
            }

            int leftSum = sumofNodes(root.left);
            int rightSum = sumofNodes(root.right);
            return leftSum + rightSum + root.data;
        }


    }

    public static void main(String main[]) {
        int nodes[] = {1, 2, 4, 7, -1, -1, 8, -1, -1, 5, -1, -1, 3, -1, 6, -1, 9, -1, 10, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.MakeTreePre(nodes);
        System.out.println(root.data);
        System.out.println();

        tree.printPreOrder(root);
        System.out.println();
        // tree.printInOrder(root);
        // System.out.println();
        // tree.printPostOrder(root);
        // System.out.println();
        // tree.printLevelOrder(root);
        // System.out.println();

        // System.out.println("Height of tree: " + tree.getHeight(root));
        // System.out.println("Total number of nodes are: " + tree.countNodes(root));
        System.out.println("Sum of all these nodes are: " + tree.sumofNodes(root));


    }
}
