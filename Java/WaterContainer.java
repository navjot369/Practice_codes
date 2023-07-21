import java.util.ArrayList;

public class WaterContainer {
    public static int totalWater(ArrayList<Integer> list) {
        int max = 0;
        int left = 0;
        int right = list.size() - 1;
        while(left < right) {
            int height = list.get(left) < list.get(right)? list.get(left) : list.get(right);
            int width = right - left;
            int currWater = height * width;
            if(currWater > max) max = currWater;
            if(list.get(left) < list.get(right)) left++;
            else right--;
        }
        return max;

    }
    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(3);
        list.add(7);
        System.out.println(totalWater(list));
    }
}