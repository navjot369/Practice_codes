public class string_subset {
    public static void subset(String str, int ind, String newStr) {
        if(ind == str.length()) {
            if(str.compareTo(newStr) == 0) {
                System.out.println(newStr);
                return;
            }
            System.out.print(newStr + ", ");
            return;
        }
        subset(str, ind + 1, newStr);
        subset(str, ind + 1, newStr + str.charAt(ind));
    }
    public static void main(String args[]) {
        subset("abc", 0, "");
    }
}