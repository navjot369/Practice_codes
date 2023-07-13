import java.lang.Math;

public class sample {
    public static void main(String agrs[]){
        int num = 100;
        int ans = 1;
        for(int i = 0; i <= num; i++){
            ans *= i;
        }
        System.out.println(ans);
    }
}