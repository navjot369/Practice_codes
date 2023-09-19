import java.util.*;

public class ValidAnagram {
    public static boolean isAnagram(String s1, String s2) {
        HashMap<Character, Integer> hm = new HashMap<>();

        for(int i = 0; i < s1.length(); i++) {
            hm.put(s1.charAt(i), hm.getOrDefault(s1.charAt(i), 0) + 1);
        }

        for(int i = 0; i < s2.length(); i++) {
            if(hm.containsKey(s2.charAt(i))) {
                if(hm.get(s2.charAt(i)) == 1) {
                    hm.remove(s2.charAt(i));
                } else {
                    hm.put(s2.charAt(i), hm.getOrDefault(s2.charAt(i), 0) - 1);
                }
            } else {
                return false;
            }
        }

        return hm.isEmpty();
    }

    public static void main(String args[]) {
        String s1 = "rare";
        String s2 = "rare";

        boolean ans = isAnagram(s1, s2);
        System.out.println(ans);
    }
}