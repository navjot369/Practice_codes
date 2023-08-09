import java.util.*;

public class IndianCoins {
    public static void main(String args[]) {
        Integer coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};

        Arrays.sort(coins, Comparator.reverseOrder());

        int amount = 574;
        ArrayList<Integer> list = new ArrayList<>();
        int totalCoins = 0;

        for(int i = 0; i < coins.length; i++) {
            while(coins[i] <= amount) {
                totalCoins++;
                list.add(coins[i]);
                amount -= coins[i];
            }
        }

        System.out.println("Total coins used: " + totalCoins);
        System.out.print("List of coins used: ");
        for(int i = 0; i < list.size(); i++) {
            if(i == list.size() - 1) {
                System.out.println(list.get(i));
            }
            else {
                System.out.print(list.get(i) + ", ");
            }
        }
    }
}
