import java.util.ArrayList;
import java.util.Collections;

public class ArrayList_que {
    public static boolean isMono(ArrayList<Integer> list) {
        boolean inc = true;
        boolean desc = true;
        for(int i = 0; i < list.size() - 1; i++){
            if(list.get(i) < list.get(i + 1)) {
                desc = false;
            }
            if(list.get(i) > list.get(i + 1)){
                inc = false;
            }
        }
        return inc || desc;
    }

    public static ArrayList<Integer> isAlone(ArrayList<Integer> list) {
        Collections.sort(list);
        ArrayList<Integer> newList = new ArrayList<>();
        for(int i = 1; i < list.size() -1; i++) {
            if(list.get(i - 1) < list.get(i) - 1 && list.get(i) + 1 < list.get(i + 1)){
                newList.add(list.get(i));
            }
        }
        if(list.size() == 1) {
            newList.add(list.get(0));
        }
        if(list.size() > 1) {
            if(list.get(0) + 1 < list.get(1)) {
                newList.add(list.get(0));
            }
            if(list.get(list.size() - 1) - 1 > list.get(list.size() - 2)){
                newList.add(list.get(list.size() - 1));
            }
        }
        return newList;
    }

    public static int maxFollow(ArrayList<Integer> list, int key) {
        int[] result = new int[1000];
        for(int i = 0; i < list.size() - 1; i++) {
            if(list.get(i) == key) {
                result[list.get(i + 1) - 1]++;
            }
        }
        int max = 0;
        for(int i = 0; i < 1000; i++){
            if(result[i] > max) {
                max = i + 1;
            }
        }
        return max == 0? -1 : max;
    }

    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(3);

        System.out.println(maxFollow(list, 2));
    }
}
