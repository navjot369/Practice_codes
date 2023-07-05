public class anagrams {
    public static void main(String args[]){
        String str1 = "hgins Navjot";
        String str2 = "Navjotsingh";
        boolean ans = is_ana(str1, str2);
        if(ans) System.out.println("They are anagrams");
        else System.out.println("They are not anagrams");
    }
    public static boolean is_ana(String str1, String str2){
        int arr[] = new int[150];
        for(int i=0; i<str1.length(); i++){
            arr[str1.charAt(i)]++;
        }
        for(int i=0; i<str2.length(); i++){
            arr[str2.charAt(i)]--;
        }
        for(int i=0; i<150; i++){
            if(arr[i]!=0)return false;
        }
        return true;
    }
}
