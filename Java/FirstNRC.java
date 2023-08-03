import java.util.*;

public class FirstNRC {
    public static void NonRepeat(String str) {
        // Queue<Character> q = new LinkedList<>();
        Queue<Character> q = new ArrayDeque<>();
        int freq[] = new int[26];

        for(int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);

            freq[curr - 'a']++;
            q.add(curr);

            while(!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }
            if(q.isEmpty()) {
                System.out.print(-1 + "  ");
            }
            else{
                System.out.print(q.peek() + " ");
            }
        }
        System.out.println();
    }

    public static void main(String args[]) {
        String str = "aabccxb";
        NonRepeat(str);
    }
}
