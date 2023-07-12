import java.util.HashSet;
import java.lang.Math;

public class RecursionQue {
    public static void Alloccur(int arr[], int key, int index) {
        if(index == -1){
            return;
        }
        Alloccur(arr, key, index - 1);
        if(arr[index] == key) {
            System.out.print(index + " ");
        }
    }

    public static void convertEng(int num, String words[]){
        if(num == 0) {
            return;
        }
        convertEng((int)(num / 10), words);
        System.out.print(words[num%10] + " ");
    }

    public static int countSub(String str, int si, int ei, int len){
        if(len == 1){
            return 1;
        }
        if(len <= 0){
            return 0;
        }
        int res = countSub(str, si + 1, ei, len - 1) + 
                  countSub(str, si, ei - 1, len - 1) - 
                  countSub(str, si + 1, ei - 1, len - 2);
        
        if(str.charAt(si) == str.charAt(ei)){
            res++;
        }
        return res;
    }

    //Function to print string in reverse.
    public static void printRev(String str, int index) {
        if(index < 0){
            System.out.println();
            return;
        }
        System.out.print(str.charAt(index));
        printRev(str, index - 1);
    }
    
    //Function to find first and last occurence of an element.
    public static int first = -1;
    public static int last = -1;
    public static void findEle(String str, char ele, int index) {
        if(index == str.length()) {
            if(first != -1){
                System.out.println("First occurence at " + first);
                System.out.println("Last occurence at " + last);
                if(first == last){
                    System.out.println("The element occurs only once.");
                }
            }
            else{
                System.out.println("The element not found");
            }
            return;
        }
        if(str.charAt(index) == ele) {
            if(first == -1){
                first = index;
            }
            last = index;
        }
        findEle(str, ele, index + 1);
    }

    //Function to check if array is strictly increasing or not.
    public static boolean isSorted(int arr[], int index) {
        if(index == arr.length - 1){
            return true;
        }
        if(arr[index] < arr[index + 1]){
            return isSorted(arr, index + 1);
        }
        else{
            return false;
        }
    }

    //Function to move all 'x' to the end of string.
    public static String newStr = "";
    public static int count = 0;
    public static String moveX(String str, int ind){
        if(ind == str.length()) {
            for(int i =0; i<count; i++){
                newStr += 'x';
            }
            return newStr;
        }
        if(str.charAt(ind) == 'x'){
            count++;
        }
        else{
            newStr += str.charAt(ind);
        }
        return moveX(str, ind + 1);
    }

    public static String removeDup(String str, int ind, boolean map[], String newStr) {
        if(ind == str.length()) {
            return newStr;

        }
        if(map[str.charAt(ind) - 'a'] == false){
            newStr += str.charAt(ind);
            map[str.charAt(ind) - 'a'] = true;
        }
        return removeDup(str, ind + 1, map, newStr);
    }

    //Function to get subsequences of a string.
    public static void sub(String str, int ind, String newStr) {
        if(ind == str.length()) {
            System.out.println(newStr);
            return;
        }
        sub(str, ind + 1, newStr + str.charAt(ind));
        sub(str, ind + 1, newStr);
    }

    //Function to print unique subsequeces of the string.
    public static void unique(String str, int ind, String newStr, HashSet<String> set) {
        if(ind == str.length()){
            if(set.contains(newStr)){
                return;
            }
            else {
                set.add(newStr);
                System.out.println(newStr);
                return;
            }
        }
        unique(str, ind + 1, newStr + str.charAt(ind), set);
        unique(str, ind + 1, newStr, set);
    }

    //Function to print keypad combinations of old nokia type phones.
    public static void makeArr(int num, int arr[], int len) {
        if(len < 0){
            return;
        }
        arr[len] = num%10;
        makeArr((int)num/10, arr, len - 1);
    }

    public static void combine(int arr[], int ind, String keypad[], String str) {
        if(ind == arr.length){
            System.out.println(str);
            return;
        }
        for(int i=0; i<keypad[arr[ind]].length(); i++){
            combine(arr, ind + 1, keypad, str + keypad[arr[ind]].charAt(i));
        }
    }

    public static void main(String args[]){
        // int sample[] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        // Alloccur(sample, 2, sample.length - 1);
        // System.out.println();

        // String words[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        // convertEng(369, words);
        // System.out.println();

        // String str = "navvxjxoxxjjnnnttxt";
        // System.out.println(str + " >>  " + countSub(str, 0, str.length() - 1, str.length()));
        // printRev(str, str.length() - 1);
        // findEle(str, 'a', 0);

        // int arr[] = {1, 3, 5, 6, 9, 10};
        // System.out.println(isSorted(arr, 0));
        // System.out.println(moveX(str, 0));

        // System.out.println(removeDup(str, 0, new boolean[26], ""));
        // sub("aaa", 0, "");
        // HashSet<String> set = new HashSet<String>();
        // unique("aaa", 0, "", set);
        String keypad[] = {".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
        int num = 20;
        int arr[] = new int[(int)Math.log10(num) + 1];
        makeArr(num, arr, (int)Math.log10(num));
        combine(arr, 0, keypad, "");
    }
}
