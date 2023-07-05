public class String_compression {
    public static String compressed(String str){
        StringBuilder str1 = new StringBuilder("");
        Integer count = 1;
        char ch = str.charAt(0);
        for(int i=1; i<=str.length(); i++){
            if(i == str.length()){
                str1.append(ch);
                if(count != 1)str1.append(count.toString());
                break;
            }
            if(str.charAt(i) == ch){
                count++;
            }
            else{
                str1.append(ch);
                if(count != 1)str1.append(count.toString());
                count = 1;
                ch = str.charAt(i);
            }
        }
        return str1.toString();
    }
    public static void main(String args[]){
        String str = "abbcccdddd";
        System.out.println(compressed(str));
        System.out.println(method2(str));
    }
    public static String method2(String str){
        StringBuilder str1 = new StringBuilder();
        for(int i = 0; i<str.length(); i++){
            Integer count = 1;
            while(i<str.length() - 1 && str.charAt(i) == str.charAt(i+1)){
                count++;
                i++;
            } 
            str1.append(str.charAt(i));
            if(count>1){
                str1.append(count.toString());
            }
        }
        return str1.toString();
    }
}
