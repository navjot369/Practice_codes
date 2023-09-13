import java.util.*;

public class HeapsQue4 {
    public static int operation(float arr[]) {
        float sum = 0;
        for(float val:arr) sum += val;
        float desired = sum / 2.0f;

        PriorityQueue<Float> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(float val:arr) {
            pq.add(val);
        }
        int times = 0;

        while(sum > desired) {
            float curr = pq.poll();
            System.out.println(times + " --- " + curr + " --- " + sum);
            curr /= 2.0f;
            sum -= curr;
            pq.add(curr);
            times++;
        }
        return times;
    }

    public static int operation(int arr[]) {
        int sum = 0;
        for(int val:arr) sum += val;
        int desired = sum / 2;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int val:arr) pq.add(-val);

        int times = 0;
        while(sum > desired) {
            int curr = -pq.poll();
            sum -= Math.ceil(curr * 1.0 / 2);
            pq.add(-(curr / 2));
            times++;
        }

        return times;
    }
    public static void main(String args[]) {
        int arr[] = {1, 5, 8, 9};
        int ans = operation(arr);
        System.out.println(ans);

    }
}
