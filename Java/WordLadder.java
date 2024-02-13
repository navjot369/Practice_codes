import java.util.*;

public class WordLadder {

    public static void main(String args[]) {
        Set<String> s = new HashSet<>();
        s.add("POON");
        s.add("PLEE");
        s.add("SAME");
        s.add("POIE");
        s.add("PLEA");
        s.add("PLIE");
        s.add("POIN");

        System.out.println("Levels - " + levels("TOON", "PLEA", s));
    }

    public static int levels(String src, String target, Set<String> s) {
        if (src == target) {
            return 1;
        }
        if (!s.contains(target)) {
            return 0;
        }
        int level = 0;
        int wordlength = src.length();
        Queue<String> q = new LinkedList<>();
        q.add(src);

        while (!q.isEmpty()) {
            level++;
            int sizeQ = q.size();
            for (int i = 0; i < sizeQ; i++) {
                char[] words = q.remove().toCharArray();
                for (int pos = 0; pos < wordlength; pos++) {
                    char org_char = words[pos];
                    for (char c = 'A'; c <= 'Z'; c++) {
                        words[pos] = c;
                        if (String.valueOf(words).equals(target)) {
                            return level + 1;
                        }
                        if (!s.contains(String.valueOf(words))) {
                            continue;
                        }
                        s.remove(String.valueOf(words));
                        q.add(String.valueOf(words));
                    }
                    words[pos] = org_char;
                }
            }
        }
        return 0;
    }
}