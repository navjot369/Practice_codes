public class distOrnot {
    public static boolean fun1(int arr[]){
        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i]==arr[j]){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String args[]){
        int arr[] = {3, 4, 1, 9, 10};
        System.out.println(fun1(arr));
    }
}
