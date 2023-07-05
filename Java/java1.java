public class java1 {
    public static void printInc(int num){
        if(num == 0){
            return;
        }
        printInc(num - 1);
        System.out.println(num + "  ");
    }

    public static void main(String args[]){
        printInc(12);
    }
}