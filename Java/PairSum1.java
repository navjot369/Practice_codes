import java.util.ArrayList;

public class PairSum1 {
    public static boolean pairs(ArrayList<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        while(left < right) {
            int sum = list.get(left) + list.get(right);
            if(sum == target) {
                return true;
            }
            else if(sum < target) {
                left++;
            }
            else{
                right--;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(8);
        list.add(13);
        list.add(15);
        System.out.println(pairs(list, 11));
    }
}