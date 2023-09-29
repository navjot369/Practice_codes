public class StreamWord {
    static class Node {
        Node child[] = new Node[29];
        boolean eow = false;
        String word;

        public Node() {
            for(int i = 0; i < 26; i++) {
                child[i] = null;
            }
            this.word = null;
        }
    }
    public static Node root = new Node();

    public static void insert(String str) {
        Node curr = root;
        for(int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if(curr.child[idx] == null) {
                curr.child[idx] = new Node();
            }
            curr = curr.child[idx];
        }
        curr.eow = true;
        curr.word = str;
    }
    public static String ans = "";

    public static void getWord(Node root) {
        if(root == null) {
            return;
        }
        if(root.word.length() > ans.length()) {
            ans = root.word;
        }

        for(int i = 0; i < 26; i++) {
            if(root.child[i] != null && root.child[i].eow) {
                getWord(root.child[i]);                
            }
        }
    }
    
    public static void main(String args[]) {
        String arr[] = {"a","banana","app","app","ap","apply","apple", "w","wo","wor","worl","world"};
        for(int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
        root.word = "";
        getWord(root);
        System.out.println(ans);
    }
}