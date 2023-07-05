public class stocks{
    public static int docks(int arr[]){
        int max_pro = 0;
        int buy_price = arr[0];
        int pro = 0;
        for(int i=1; i<arr.length; i++){
            pro = arr[i] - buy_price;
            if(pro<=0){  //loss
                buy_price = arr[i];
                continue;
            }
            if(pro>max_pro){ //profit
                max_pro = pro;
            }
        }
        return max_pro;
    }
    public static void main(String args[]){
        int arr[] = {1, 9, 3, 4, 4};
        System.out.println(docks(arr));
    }
}