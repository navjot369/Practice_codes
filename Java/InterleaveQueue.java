import java.util.*;

public class InterleaveQueue {
    public static void Interleave(Queue<Integer> original) {
        int size = original.size();
        Queue<Integer> auxiliary = new ArrayDeque<>();

        for(int i = 0; i < size / 2; i++) {
            auxiliary.add(original.remove());
        }

        while(!auxiliary.isEmpty()) {
            original.add(auxiliary.remove());
            original.add(original.remove());
        }


    }

    public static void main(String args[]) {
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 1; i < 11; i++) {
            q.add(i);
        }

        Interleave(q);

        while(!q.isEmpty()) {
            System.out.print(q.remove() + "  ");
        }
        System.out.println();
    }
}
