import java.util.*;

public class HashMap1 {
    public static void main(String args[]) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 45);
        hm.put("Australia", 32);
        hm.put("Britain", 56);
        System.out.println(hm);

        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 100);
        lhm.put("China", 12);
        lhm.put("Argentina", 83);
        System.out.println(lhm);

        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("India", 123);
        tm.put("China", 143);
        tm.put("USA", 184);
        System.out.println(tm);
    }
}