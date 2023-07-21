import java.util.ArrayList;

//In this, we will search for target pair in sorted and rotated Array.

public class PairSum2 {
    public static boolean paris(ArrayList<Integer> list, int target) {
        int len = list.size();
        int pivot = len - 1;
        for(int i = 0; i < len - 1; i++){
            if(list.get(i) > list.get(i + 1)) {
                pivot = i;
                break;
            }
        }
        int left = (pivot + 1) % len;
        int right = pivot;
        while(left != right) {
            int sum = list.get(left) + list.get(right);
            System.out.println(left + " " + right + " " + sum);
            if(sum == target) {
                return true;
            }
            else if(sum < target) {
                left = (left + 1) % len;
            }
            else {
                right = (len + right - 1) % len;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(8);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println(paris(list, 7));
    }
}
