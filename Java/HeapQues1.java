import java.util.*;

public class HeapQues1 {
    /*
    public static void main(String args[]) {
        int arr[] = {10, 20, 11, 70, 50, 40, 100, 5};
        int K = 3;
        int res[] = new int[arr.length];
        int temp[] = new int[K];
        for(int i = 0; i < K; i++) {
            temp[i] = Integer.MIN_VALUE;
        }

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < K; j++) {
                if(arr[i] > temp[j]) {
                    int k = K - 1;
                    while(k > j) {
                        temp[k] = temp[k - 1]; 
                        k--;
                    }
                    temp[j] = arr[i];
                    break;
                }
            }
            if(temp[K - 1] == Integer.MIN_VALUE) {
                res[i] = -1;
            } else {
                res[i] = temp[K - 1];
            }
        }

        for(int i = 0; i < arr.length; i++) {
            System.out.print(res[i] + ", ");
        }
    }
    */

    public static List<Integer> getKthele(int arr[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();
        for(int val:arr) {
            if(pq.size() < k) {
                pq.add(val);
            } else {
                if(val > pq.peek()) {
                    pq.poll();
                    pq.add(val);
                }
            }

            if(pq.size() < k) {
                list.add(-1);
            } else {
                list.add(pq.peek());
            }
        }
        return list;
    }

    public static void main(String args[]) {
        int arr[] = {10, 20, 11, 70, 50, 40, 100, 5};
        int K = 3;
        List<Integer> res = getKthele(arr, K);
        for(int x:res) {
            System.out.print(x + ", ");
        }
    }
}