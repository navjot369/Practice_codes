public class removeDuplicates {
    public static void fun(String str, int index, StringBuilder sb, boolean arr[]) {
        if(index == str.length()) {
            System.out.println(sb);
            return;
        }
        if(arr[str.charAt(index) - 'a']) {
            fun(str, index + 1, sb, arr);
        }
        else {
            arr[str.charAt(index) - 'a'] = true;
            sb.append(str.charAt(index));
            fun(str, index + 1, sb, arr);
        }
    }

    public static void main(String args[]) {
        fun("appnnaacolledgge", 0, new StringBuilder(), new boolean[26]);
    }
}
