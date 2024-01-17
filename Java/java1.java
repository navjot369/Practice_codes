import java.util.*;

public class java1 {
    public static void main(String main[]) {
        int arr[] = {1, 2, 3, 4, 5};
        changeArr(arr);
        for(int i:arr) System.out.print(i + " ");
    }

    public static void changeArr(int arr[]) {
        arr[3] = 10;
        return;
    }
	
}

