import java.util.Stack;

public class BST_ques {
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

    public static int sumInRange(Node root, int k1, int k2) {
        if(root == null) {
            return 0;
        }
        if(root.data < k1) {
            return sumInRange(root.right, k1, k2);
        }
        else if(root.data > k2) {
            return sumInRange(root.left, k1, k2);
        }
        else{
            int ans = root.data;
            ans += sumInRange(root.left, k1, k2);
            ans += sumInRange(root.right, k1, k2);
            return ans;
        }
    }

    static int diff = Integer.MAX_VALUE;
    static int ans = -1;

    public static void closestEle(Node root, int val) {
        if(root == null) {
            return;
        }

        int abs = Math.abs(root.data - val);
        if(abs < diff) {
            ans = root.data;
            diff = abs;
        }

        if(val < root.data) {
            closestEle(root.left, val);
        } else if(val > root.data) {
            closestEle(root.right, val);
        } else {
            return;
        }
    }

    public static int closestElement(Node root, int val) {
        diff = Integer.MAX_VALUE;
        ans = -1;
        closestEle(root, val);

        return ans;
    }

    static int level = 0;
    static int Ksmallest = -1;
    public static void getKthS(Node root, int k) {
        if(level >= k || root == null) {
            return;
        }
        getKthS(root.left, k);
        level++;
        if(level == k) {
            Ksmallest = root.data;
        }
        getKthS(root.right, k);
        
    }

    public static int getKsmallest(Node root, int k) {
        level = 0;
        Ksmallest = -1;
        getKthS(root, k);

        return Ksmallest;
    }

    public static int getPairs(Node root1, Node root2, int x) {
        int count = 0;

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        Node top1, top2;

        while(true) {
            while(root1 != null) {
                s1.add(root1);
                root1 = root1.left;
            }

            while(root2 != null) {
                s2.add(root2);
                root2 = root2.right;
            }

            if(s1.isEmpty() || s2.isEmpty()) {
                break;
            }

            top1 = s1.peek();
            top2 = s2.peek();

            if(top1.data + top2.data == x) {
                s1.pop();
                s2.pop();
                count++;
                System.out.println(top1.data + ", " + top2.data);
                root1 = top1.right;
                root2 = top2.left;
            }
            else if(top1.data + top2.data < x) {
                s1.pop();
                root1 = top1.right;
            }
            else {
                s2.pop();
                root2 = top2.left;
            }
        }

        return count;
    }
 
    public static void main(String args[]) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(11);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(20);

        // System.out.println(closestElement(root, 7));

        // System.out.println(getKsmallest(root, 3));

        Node root1 = new Node(5);
        root1.left = new Node(3);
        root1.right = new Node(7);
        root1.left.left = new Node(2);
        root1.left.right = new Node(4);
        root1.right.left = new Node(6);
        root1.right.right = new Node(8);

        Node root2 = new Node(10);
        root2.left = new Node(6);
        root2.right = new Node(15);
        root2.left.left = new Node(3);
        root2.left.right = new Node(8);
        root2.right.left = new Node(12);
        root2.right.right = new Node(18);

        System.out.println(getPairs(root1, root2, 16));

    }
}
