public class LongestWord {
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
        for(int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static String largest = "";
    public static void getWord(Node root, String str) {
        if(root == null) {
            return;
        }
        largest = str.length() > largest.length() ? str : largest;
        for(int i = 0; i < 26; i++) {
            if(root.children[i] != null && root.children[i].eow == true) {
                getWord(root.children[i], str + (char)('a' + i));
            }
        }
    }

    public static void main(String args[]) {
        // String arr[] = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        String arr[] = {"ab", "ad", "ar"};
        for(int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }

        getWord(root, new String());
        System.out.println(largest);
    }
}