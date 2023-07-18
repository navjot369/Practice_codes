public class string_permutation {
    public static void strPer(String str, String newStr) {
        if(str.length() == 0) {
            System.out.println(newStr);
            return;
        }
        for(int i = 0; i < str.length(); i++){
            String temp = str.substring(0, i) + str.substring(i + 1, str.length());
            strPer(temp, newStr + str.charAt(i));

        }
    }

    public static void main(String args[]){
        strPer("abc", ""); 
    }
}
