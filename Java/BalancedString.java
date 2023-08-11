public class BalancedString {
    public static void main(String args[]) {
        String str = "LRRRRLLLRLRL";

        int countR = 0;
        int countL = 0;
        int partitions = 0;

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'L') {
                countL++;
            }
            else {
                countR++;
            }
            if(countL == countR) {
                countL = countR = 0;
                partitions++;
            }
        }

        System.out.println("Total number of partitions: " + partitions);
    }
}
