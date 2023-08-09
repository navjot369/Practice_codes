import java.util.*;

public class FractionalKnapsack {

    public static int maxProfit(int weight[], int value[], int W) {
        int len = weight.length;
        int capacity = W;
        int profit = 0;

        double ratio[][] = new double[len][2];
        for(int i = 0; i < len; i++){
            ratio[i][0] = i;
            ratio[i][1] = value[i]/(double)weight[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        for(int i = len - 1; i >= 0; i--) {
            int idx = (int)ratio[i][0];
            if(capacity >= weight[idx]) {
                capacity -= weight[idx];
                profit += value[idx];
            }
            else {
                profit += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }
        return profit;

    }
    public static void main(String args[]) {
        int weight[] = {10, 5, 30};
        int value[] = {40, 100, 120};
        int W = 50;

        int ans = maxProfit(weight, value, W);
        System.out.println(ans);
    }
}
