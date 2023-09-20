import java.util.*;

public class HashSet1 {
    public static void main(String args[]) {
        HashSet<Integer> set = new HashSet<>();
        set.add(5);
        set.add(2);
        set.add(3);
        set.add(2);
        set.add(5);
        set.add(1);
        System.out.println(set);

        LinkedHashSet<Integer> lset = new LinkedHashSet<>();
        lset.add(5);
        lset.add(2);
        lset.add(3);
        lset.add(2);
        lset.add(5);
        lset.add(1);
        System.out.println(lset);

        TreeSet<Integer> tset = new TreeSet<>();
        tset.add(5);
        tset.add(4);
        tset.add(3);
        tset.add(2);
        tset.add(3);
        System.out.println(tset);
        tset.remove(2);
        System.out.println(tset.contains(5) + ", " + tset.contains(2));

        System.out.print("\nBefore size - " + set.size());
        set.clear();
        System.out.println(", after using .clear() - " + set.size());
        System.out.println(set.isEmpty());


        System.out.println("Using iterator - ");
        Iterator<Integer> itr = lset.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }

        System.out.println("Using for each loop - ");
        for(int val:tset) {
            System.out.println(val);
        }
    }
}