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

    public static void main(String args[]){
        // int sample[] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        // Alloccur(sample, 2, sample.length - 1);
        // System.out.println();

        String words[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        convertEng(369, words);
        System.out.println();
    }
}
