public class BinaryString {
    public static void BinaryStr(int num, int lastPlace, String str) {
        if(num == 0) {
            System.out.println(str);
            return;
        }
        BinaryStr(num - 1, 0, str + "0");
        if(lastPlace == 0) {
            BinaryStr(num - 1, 1, str + "1");
        }
    }

    public static void main(String args[]) {
        BinaryStr(3, 0, "");
    }
}
