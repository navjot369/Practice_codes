import java.util.Stack;

public class DecodeString {
    public static void decode(String str, Stack<Character> s, int times) {
        if(times == 0) {
            return;
        }
        Stack<Character> temp = new Stack<>();
        String num = "";
        int i = 0;
        while(i < str.length()) {
            char curr = str.charAt(i);
            if(curr >= '0' && curr <= '9') {
                num += curr;
            }
            else if(curr == '[') {
                int count;
                if(num.length() > 0) count = Integer.parseInt(num);
                else count = 1;
                int start = i + 1;
                temp.push('[');
                while(!temp.isEmpty()) {
                    i++;
                    if(str.charAt(i) == '[') {
                        temp.push(str.charAt(i));
                    }
                    else if(str.charAt(i) == ']') {
                        temp.pop();
                    }
                }
                decode(str.substring(start, i), s, count);
            }
            else {
                s.push(curr);
            }
            i++;
        }
        decode(str, s, times - 1);
    }

    public static void main(String args[]) {
        Stack<Character> s = new Stack<>();
        String str = "3[Navj2[o]t ]";
        decode(str, s, 1);
        String newStr = "";
        while(!s.isEmpty()) {
            newStr = s.pop() + newStr;
        }
        System.out.println(newStr);
    }
}
