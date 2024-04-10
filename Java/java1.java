import java.util.*;

public class java1 {
    public static void main(String args[]) {
        String s = "lee(t(c)o)de)";
        Stack<String> st = new Stack<>();
        int len = s.length();
        String temp = "";

        for(int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            temp = "";
            if(ch == ')') {
                while(!st.isEmpty() && st.peek().compareTo("(") != 0) {
                    System.out.println(i + " -- " + temp + " p- " + st.peek() + " is " + (st.peek().compareTo("(")));
                    temp = st.pop() + temp;
                }
                System.out.println(i + " -- " + temp);
                if(st.isEmpty()) {
                    st.add(temp);
                }else{
                    st.pop();
                    st.add("("+temp+")");
                }
            }
            else{
                temp += ch;
                st.add(temp);
            }
        }
        temp = "";
        while(!st.isEmpty()) {
            System.out.println(st.peek());
            if(st.peek() != "(") {
                temp = st.pop() + temp;
            }
        }
        System.out.println(temp);
    }
}