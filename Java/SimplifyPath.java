import java.util.Stack;

public class SimplifyPath {
    public static String simplify(String path) {
        Stack<String> s = new Stack<>();
        int len = path.length();
        StringBuilder temp = new StringBuilder("");
        for(int ind = 0; ind <= len; ind++) {
            if(ind == len || path.charAt(ind) == '/') {
                String str = temp.toString();
                if(str.length() > 0) {
                    if(str.compareTo("..") == 0) {
                        if(!s.isEmpty()) {
                            s.pop();
                        }
                    }
                    else {
                        s.push(str);
                    }
                }
                temp = new StringBuilder("");
            }
            else {
                temp.append(path.charAt(ind));
            }
        }
        String ans = "";
        while(!s.isEmpty()) {
            ans = "/" + s.pop() + ans;
        }
        return ans;
    }

    public static void main(String args[]) {
        String str = "navjot/singh/../../..";
        System.out.println(simplify(str));
    }
}
