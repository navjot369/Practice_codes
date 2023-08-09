import java.util.*;

public class ActivitySelection {
    public static void maxActivity(int start[], int end[]) {
        int len = start.length;
        int activity[][] = new int[len][3];

        for(int i = 0; i < len; i++) {
            activity[i][0] = i;
            activity[i][1] = start[i];
            activity[i][2] = end[i];
        }

        Arrays.sort(activity, Comparator.comparingDouble(o -> o[2]));

        int maxAct = 1;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(activity[0][0]);
        int lastEnd = activity[0][2];
        for(int i = 1; i < len; i++) {
            if(activity[i][1] >= lastEnd) {
                maxAct++;
                list.add(activity[i][0]);
                lastEnd = activity[i][2];
            }
        }

        System.out.println("Maximum activities: " + maxAct);
        for(int i = 0; i < list.size(); i++) {
            System.out.print("A" + list.get(i) + " ");
        } 
        System.out.println();

    }
    public static void main(String args[]) {
        int start[] = {0, 1, 3, 5, 5, 8};
        int end[] = {6, 2, 4, 7, 9, 9};

        maxActivity(start, end);
    }
}
