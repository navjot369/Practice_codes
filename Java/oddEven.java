public class oddEven {
    public static void find(int num){
        int bitmask = 1;
        if((num & bitmask) == 1){
            System.out.println("This is odd");
        }else{
            System.out.println("This is even");
        }
    }
    public static void main(String args[]){
        for(int i=0; i<10; i++){
            find(i);
        }
    }
}
