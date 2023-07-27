import java.util.Stack;

public class ReverseString {
    public static String reverseStr(String str) {
        Stack<Character> s = new Stack<>();
        int ind = 0;
        while(ind < str.length()) {
            s.push(str.charAt(ind));
            ind++;
        }

        StringBuilder newStr = new StringBuilder("");
        while(!s.isEmpty()) {
            newStr.append(s.pop());
        }

        return newStr.toString();
    }

    public static void main(String args[]) {
        String str = "Navjot Singh";
        String result = reverseStr(str);
        System.out.println(result);
    }
}