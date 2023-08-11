public class BestTImeStocks {
    public static int maxProfit(int stocks[]) {
        int buy = stocks[0];
        int maxPro = 0;
        for(int i = 0; i < stocks.length; i++) {
            if(stocks[i] <= buy) {
                buy = stocks[i];
                continue;
            }
            int profit = stocks[i] - buy;
            if(profit > maxPro) {
                maxPro = profit;
            }
        }

        return maxPro;
    }
    public static void main(String args[]) {
        int stocks[] = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(stocks));
    }
}
