import java.util.*;


public class SortStringChar {
    public static String sortIt(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
            (a, b) -> a.getValue() == b.getValue() ? a.getKey() - b.getKey() :
            b.getValue() - a.getValue());
        
        for(Map.Entry<Character, Integer> e:map.entrySet()) {
            pq.add(e);
        }

        StringBuilder strbld = new StringBuilder();
        while(!pq.isEmpty()) {
            Map.Entry<Character, Integer> curr = pq.poll();
            char chr = curr.getKey();
            int times = curr.getValue();

            while(times-- > 0) {
                strbld.append(chr);
            }
        }

        return strbld.toString();
    }

    public static void main(String args[]) {
        String str = "tree";

        String ans = sortIt(str);

        System.out.println(ans);
    }
}
