public class KlargestOddNo {
    public static int BruteForce(int start, int end, int k) { //Brute Force
        int pos = 0;
        for(int i = end; i >= start; i--) {
            if(i % 2 != 0) {
                pos++;
            }
            if(pos == k) {
                return i;
            }
        }
        return 0;
    }

    public static int KthLargestOdd(int L, int R, int K) {
        if(K < 1) {
            return 0;
        }

        if((R & 1) > 0) {
            int count = (int)Math.ceil((R - L + 1) / 2);
            if(K <= count) {
                return (R - 2 * K + 2);
            }else{
                return 0;
            }
        }
        else {
            int count = (R - L + 1) / 2;
            if(K <= count) {
                return (R - 2 * K + 1);
            }
            else{
                return 0;
            }
        }
    }
    public static void main(String args[]) {
        System.out.println(KthLargestOdd(0, 13, 4));
    }
}
