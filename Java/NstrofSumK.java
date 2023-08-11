import java.util.*;

public class NstrofSumK {
    public static String getStr(int N, int K) {
        char arr[] = new char[N];
        Arrays.fill(arr, 'a');

        for(int i = N - 1; i >= 0; i--) {
            K -= i;
            if(K >= 26) {
                arr[i] = 'z';
                K -= 26;
            }
            else if(K <= 1) {
                break;
            }
            else {
                arr[i] = (char)('a' + K - 1);
                K -= (arr[i] - 'a' + 1);
            }
            K += i;
        }

        String str = new String(arr);
        return str;
    }

    public static void main(String args[]) {
        System.out.println(getStr(3, 25));
    }
}
