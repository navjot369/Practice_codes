public class bit_operation {
    public static int getBit(int number, int i) {
        if ((number & (1 << i)) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static int setBit(int number, int i) {
        int ans = (number | (1 << i));
        return ans;
    }

    public static int clearBit(int number, int i) {
        int ans = (number & ~(1 << i));
        return ans;
    }

    public static int updateBit(int number, int i, int nB) { // nB==0 -> clear; nB==1 -> set
        int n = clearBit(number, i);
        int bitmask = nB << i;
        return n | bitmask;
    }

    public static int clearnBits(int number, int n) { // We have to clear last number of bits.
        int bitmask = ((-1) << n);
        return number & bitmask;
    }

    public static int clearRange(int number, int i, int j) {
        int a = ((~0) << (j + 1));
        int b = ((1 << i) - 1);
        int bitmask = a | b;
        return (number & bitmask);
    }

    public static boolean ifPower2(int number) {
        return ((number & (number - 1)) == 0);
    }
    public static int countSet(int number){
        int count = 0;
        while(number > 0) {
            if((number & 1) != 0){
                count++;
            }
            number>>=1;
        }
        return count;
    }
    public static int fastExp(int number, int power){
        int ans = 1;
        while(power > 0){
            if((power & 1) != 0){
                ans *= number;
            }
            number *= number;
            power>>=1;
        }
        return ans;
    }
    public static void swapNum(int num1, int num2){
        System.out.println("Value of numbers before swap: " + num1 + ", " + num2);
        num1 = num1 ^ num2;
        num2 = num1 ^ num2;
        num1 = num1 ^ num2;
        System.out.println("Value of numbers after swap: " + num1 + ", " + num2);
    }
    public static void main(String args[]) {
        // int num = 5;
        // System.out.println(getBit(num, 2));
        // System.out.println("Setting first bit to one: " + setBit(num, 1));
        // System.out.println("Clearing the second bit: " + clearBit(num, 2));
        // System.out.println("Update 1 bit: " + updateBit(num, 1, 1));
        // System.out.println("Update 2 bit: " + updateBit(num, 2, 0));
        // System.out.println("Clearing last 2 bits: " + clearnBits(num, 2));
        // System.out.println(clearRange(10, 2, 4));
        // System.out.println("Is power of 2? " + ifPower2(17));
        // System.out.println("Number of set bits: " + countSet(15));
        // System.out.println("Fast Exponentiation: " + fastExp(3, 4));
        swapNum(3, 6);
    }
}
