public class IntToRoman {
    public static String intToRoman(int num) {
        String s = "";
        if (num >= 1000) {
            int temp = num / 1000;
            for (int i = 0; i < temp; i++) {
                s += 'M';
            }
            num %= 1000;
        }
        System.out.println(s);
        if (num >= 900) {
            s += "CM";
            num -= 900;
        }
        if (num >= 500) {
            s += "D";
            num -= 500;
        }
        if (num >= 400) {
            s += "CD";
            num -= 400;
        }
        if (num >= 100) {
            int temp = num / 100;
            for (int i = 0; i < temp; i++) {
                s += "C";
            }
            num %= 100;
        }
        System.out.println(s);
        if (num >= 90) {
            s += "XC";
            num -= 90;
        }
        if (num >= 50) {
            s += "L";
            num -= 50;
        }
        if (num >= 40) {
            s += "XL";
            num -= 40;
        }
        if (num >= 10) {
            int temp = num / 10;
            for (int i = 0; i < temp; i++) {
                s += "D";
            }
            num %= 10;
        }
        System.out.println(s);
        if (num == 9) {
            s += "IX";
            num -= 9;
        }
        if (num >= 5) {
            s += "V";
            num -= 5;
        }
        if (num == 4) {
            s += "IV";
            num -= 4;
        }
        System.out.println(s);
        while (num > 0) {
            s += "I";
            num -= 1;
        }
        return s;
    }

    public static void main(String args[]) {
        System.out.println(intToRoman(1994));
    }
}