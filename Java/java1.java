import java.util.*;

public class Solution {
    public static void main(String args[]) {
        String str = "a+b+c+d-e";
        String ans = infixToPostfix(str);

        System.out.println(ans);
    }
    public static String infixToPostfix(String exp) {
        String ans = "";
        int len = exp.length();
        Stack<Character> s = new Stack<>();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('^', 1);
        map.put('*', 2);
        map.put('/', 2);
        map.put('+', 3);
        map.put('-', 3);
        map.put('(', 4);

        for(int i = 0; i < len; i++) {
            char ch = exp.charAt(i);
            System.out.println(ch + " " + ans);
            if(ch == '(') {
                s.push(ch);
            }
            else if(ch == ')') {
                while(s.peek() != '(')
                ans += s.pop();
                s.pop();
            }
            else if((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z')) {
                System.out.println("here1"); 
                ans += ch;
            }
            else {
                System.out.println("here2");
                while(!s.isEmpty() && map.get(s.peek()) <= map.get(ch)) {
                    ans += s.pop();
                }
                s.push(ch);
            }
        }
        while(!s.isEmpty()) {
            ans += s.pop();
        }
        return ans;
    }
}