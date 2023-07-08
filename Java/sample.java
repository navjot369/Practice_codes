public class sample {
    public static void main(String agrs[]){

    }

    public static void remove(String str, int index, StringBuilder sb, boolean arr[]) {
        if(index == str.length()){
            System.out.println(sb);
        }

        if(arr[str.charAt(index) - 'a']) {
            remove(str, index + 1, sb, arr);
        }
        else {
            arr[str.charAt(index) - 'a'] = true;
            remove(str, index + 1, sb.append(str.charAt(index)), arr);
        }
    }
}