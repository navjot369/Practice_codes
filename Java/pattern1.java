public class pattern1 {
    public static void main(String args[]) {
        
        for(int i = 1; i < 4; i++) {
            int j = 1;
            for(; j <= i; j++) {
                System.out.print(j);
            }
            j = 2;
            if(i == 1) {
                System.out.print(i);
                j--;
            }
            for(; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
        for(int i = 3; i >= 1; i--) {
            int j = 4 - i;
            for(; j > 0; j--) {
                System.out.print(" ");
            }
            j++;
            for(; j <= i; j++) {
                System.out.print(j);
            }
            j = 2;
            if(i == 1) {
                System.out.print(i);
                j--;
            }
            for(; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
