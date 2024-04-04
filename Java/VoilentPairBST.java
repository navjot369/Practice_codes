//{ Driver Code Starts
    import java.io.*;
    import java.util.*;
    
    class Node {
        int data;
        Node left;
        Node right;
    
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    
        public static Node buildTree(String str) {
            // Corner Case
            if (str.length() == 0 || str.charAt(0) == 'N') return null;
    
            // Creating array of Strings from input
            // String after spliting by space
            String ip[] = str.split(" ");
    
            // Create the root of the tree
            Node root = new Node(Integer.parseInt(ip[0]));
    
            // Push the root to the queue
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
    
            // Starting from the second element
            int i = 1;
            while (queue.size() > 0 && i < ip.length) {
    
                // Get and remove the front of the queue
                Node currNode = queue.peek();
                queue.remove();
    
                // Get the current node's value from the string
                String currVal = ip[i];
    
                // If the left child is not null
                if (!currVal.equals("N")) {
    
                    // Create the left child for the current node
                    currNode.left = new Node(Integer.parseInt(currVal));
                    // Push it to the queue
                    queue.add(currNode.left);
                }
    
                // For the right child
                i++;
                if (i >= ip.length) break;
    
                currVal = ip[i];
    
                // If the right child is not null
                if (!currVal.equals("N")) {
    
                    // Create the right child for the current node
                    currNode.right = new Node(Integer.parseInt(currVal));
    
                    // Push it to the queue
                    queue.add(currNode.right);
                }
                i++;
            }
    
            return root;
        }
    
        public static Node inputTree(BufferedReader br) throws IOException {
            return buildTree(br.readLine().trim());
        }
    
        public static void inorder(Node root) {
            if (root == null) return;
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
    
    class GFG {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t;
            t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
    
                int n;
                n = Integer.parseInt(br.readLine());
    
                Node root = Node.inputTree(br);
    
                Solution obj = new Solution();
                int res = obj.pairsViolatingBST(n, root);
    
                System.out.println(res);
            }
        }
    }
    
    // } Driver Code Ends
    
    
    /*
    
    Definition for Binary Tree Node
    class Node
    {
        int data;
        Node left;
        Node right;
    
        Node(int data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }
    */
    
    class Solution {
        static int arr[];
        int ind;
        public static void Inorder(Node root) {
            if(root == null) return;
            Inorder(root.left);
            a[ind++] = root.data;
            Inorder(root.right);
        }
        
        public static int mergeSort(int start, int end) {
            if(start >= end) return 0;
            
            int mid = start + (end-start)/2;
            
            int count = mergeSort(start, mid);
            count += mergeSort(mid+1, end);
            
            int left = start;
            int right = mid+1;
            int len = end-start+1;
            int temp[] = new int[len];
            int ind = 0;
            
            while(left <= mid && right <= end) {
                if(arr[left] <= arr[right]) {
                    temp[ind++] = arr[left++];
                } else {
                    temp[ind++] = arr[right++];
                    count++;
                }
            }
            while(left <= mid) temp[ind++] = arr[left++];
            while(right <= end) temp[ind++] = arr[right++];
            for(int i = 0; i < len; i++) {
                arr[start++] = temp[i];
            }
            
            return count;
        }
        
        public static int pairsViolatingBST(int n, Node root) {
            arr = new int[n];
            Inorder(root);
            return mergeSort(0, len-1);
        }
    }
    