public class count_vowels {
    public static void main(String args[]){
        String str = "Hello, My nAme is Navjot Singh";
        int ans = count(str);
        System.out.println("Number of vowels are " + ans);

    }
    public static int count(String str){
        int count = 0, len = str.length();
        for(int i=0; i<len; i++){
            switch(str.charAt(i)){
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                count++;
                System.out.println(i + " -- " + str.charAt(i));
            }
        }       
        return count;
    }
}
