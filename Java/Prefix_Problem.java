public class Prefix_Problem {
    static class Node{
        Node child[] = new Node[26];
        boolean eow = false;
        int more = 0; //This is used in this particular problem.

        public Node() {
            for(int i = 0; i < 26; i++) {
                child[i] = null;
            }
        }
    }
    public static Node root = new Node();

    public static void insert(String str){
        Node curr = root;
        for(int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if(curr.child[idx] == null) {
                curr.child[idx] = new Node() ;
            }
            curr.more++;
            curr = curr.child[idx];
        }
        curr.eow = true;
    }

    public static boolean search(String str) {
        Node curr = root;
        for(int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if(curr.child[idx] == null) {
                return false;
            }
            curr = curr.child[idx];
        }
        return curr.eow;
    }

    public static String getPrefix(String str) {
        Node curr = root;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            curr = curr.child[idx];
            sb.append(str.charAt(i));
            if(curr.more <= 1){
                return sb.toString();
            }
        }
        return sb.toString();
    }

    public static void main(String args[]){
        String arr[] = {"zebra", "dog", "duck", "dove", "zebau"};
        for(int i = 0; i < 5; i++) {
            insert(arr[i]);
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " -> " + getPrefix(arr[i])); 
        }
    }
}