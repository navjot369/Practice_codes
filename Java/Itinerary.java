import java.util.*;

public class Itinerary {
    public static String getStart(HashMap<String, String> hm) {
        Set<String> set = hm.keySet();
        HashMap<String, String> rev = new HashMap<>();

        for(String val:set) {
            rev.put(hm.get(val), val);
        }

        for(String val:set) {
            if(!rev.containsKey(val)) {
                return val;
            }
        }
        return "";
    }

    public static void main(String args[]) {
        HashMap<String, String> hm = new HashMap<>();
        hm.put("Chennai", "Bengaluru");
        hm.put("Mumbai", "Delhi");
        hm.put("Goa", "Chennai");
        hm.put("Delhi", "Goa");
        
        String start = getStart(hm);

        while(hm.containsKey(start)) {
            System.out.print(start + " -> ");
            start = hm.get(start);
        }
        System.out.println(start);

    }
}