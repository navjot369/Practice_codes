import java.util.*;

public class CommonAncestor2 {
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

    public static Node lca(Node root, int n1, int n2) {
        if(root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);

        if(left == null){
            return right;
        }
        if(right == null) {
            return left;
        }

        return root;
    }

    public static int distance(Node root, int num) {
        if(root == null) {
            return -1;
        }
        if(root.data == num) {
            return 0;
        }

        int left = distance(root.left, num);
        int right = distance(root.right, num);

        if(left == -1 && right == -1) {
            return -1;
        } else if (right == -1) {
            return left + 1;
        } else {
            return right + 1;
        }
    }

    public static int minDist(Node root, int n1, int n2) {
        Node lca = lca(root, n1, n2);
        int dist1 = distance(lca, n1);
        int dist2 = distance(lca, n2);
        return dist1 + dist2;
    }

    public static int transform(Node root) {
        if(root == null) {
            return 0;
        }

        int left = transform(root.left);
        int right = transform(root.right);
        int leftSum = root.left != null ? root.left.data : 0;
        int rightSum = root.right != null ? root.right.data : 0;
        int data = root.data;

        root.data = left + leftSum + right + rightSum;
        return data;
    }

    public static void printTree(Node root) {
        // Here, VScode show erorrs if we implement queues using LinkedList to make queues
        // But in ArrayDeque, we can't add null, so to use code use LinkedList instead of ArrayDeque.
        Queue<Node> q = new ArrayDeque<>();

        q.add(root);
        q.add(null);
        while(!q.isEmpty()) {
            Node curr = q.remove();
            if(curr == null) {
                if(q.isEmpty()) {
                    break;
                }
                else{
                    q.add(null);
                    System.out.println();
                }
            } else {
                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }
                System.out.print(curr.data  + "   ");
            }
        }
    }

    public static boolean isUnivalued(Node root, int parentData) {
        if(root == null) {
            return true;
        }
        if(root.data != parentData) {
            return false;
        }
        if(!isUnivalued(root.left, root.data)) {
            return false;
        }
        if(!isUnivalued(root.right, root.data)) {
            return false;
        }

        return true;
        
    }

    public static int KthAnces(Node root, int num, int k) {
        if(root == null) {
            return -1;
        }
        if(root.data == num) {
            return 0;
        }

        int left = KthAnces(root.left, num, k);
        int right = KthAnces(root.right, num, k);

        if(left == -1 && right == -1) {
            return -1;
        }
        int max = Math.max(left, right);
        if(max + 1 == k) {
            System.out.println(root.data);
        }
        return max + 1;
        

    }

    public static void main(String args[]) {
        Node root = new Node(2);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(2);
        root.left.right = new Node(2);
        root.right.left = new Node(2);
        root.right.right = new Node(2);

        // System.out.println(lca(root, 4, 3).data);
        // System.out.println(minDist(root, 4, 3));
        // KthAnces(root, 7, 2);
        // transform(root);
        // printTree(root);
        System.out.println(isUnivalued(root, root.data));
    }
}
