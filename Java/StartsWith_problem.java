public class StartsWith_problem {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        public Node() {
            for(int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }
    public static Node root = new Node();

    public static void insert(String str) {
        Node curr = root;
        for(int i = 0; i < str.length(); i++){
            int idx = str.charAt(i) - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static boolean isPrefix(String pre) {
        Node curr = root;
        for(int i = 0; i < pre.length(); i++) {
            int idx = pre.charAt(i) - 'a';
            if(curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    public static void main(String args[]) {
        String arr[] = {"apple", "app", "hell", "hello", "zebra"};
        for(int i = 0;i < arr.length; i++) {
            insert(arr[i]);
        }

        System.out.println(isPrefix("zebronics"));
    }
}