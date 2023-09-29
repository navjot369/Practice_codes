import java.util.*;

public class groupAnagrams {
    static class Node {
        Node child[] = new Node[26];
        boolean eow = false;

        public Node() {
            for(int i = 0; i < 26; i++) {
                child[i] = null;
            }
        }
    }
    public static Node root = new Node();
    public static HashMap<String, ArrayList<String>> hm = new HashMap<>();


    public static void insert(String s) {
        Node curr = root;
        
        char temp[] = s.toCharArray();
        Arrays.sort(temp);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < temp.length; i++) {
            sb.append(temp[i]);
            int idx = temp[i] - 'a';
            if(curr.child[idx] == null) {
                curr.child[idx] = new Node();
            }
            curr = curr.child[idx];
        }
        String lexi = sb.toString();
        if(curr.eow) {
            hm.get(lexi).add(s);
        }
        else {
            ArrayList<String> newlist = new ArrayList<>();
            newlist.add(s);
            hm.put(lexi, newlist);
            curr.eow = true;
        }
    }

    public static void main(String args[]) {
        String arr[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        for(int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }

        for(String str:hm.keySet()) {
            System.out.println(hm.get(str));
        }
    }
}