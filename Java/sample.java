import java.lang.Math;

public class sample {
    public static void main(String agrs[]){
        int num = 23;
        System.out.println((int)(num / Math.pow(10, (int)Math.log10(num))));
    }
}