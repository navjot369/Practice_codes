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
    public static void main(String args[]){
        // int sample[] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        // Alloccur(sample, 2, sample.length - 1);
        // System.out.println();

        // String words[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        // convertEng(369, words);
        // System.out.println();

        String str = "abca";
        System.out.println(str + " >>  " + countSub(str, 0, str.length() - 1, str.length()));
    }
}
