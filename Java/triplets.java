public class triplets{
    // This code contains algorithm for rainwater wala question.
    public static int collect(int arr[]){
        int l = 0, r = arr.length-1;
        int lmax = arr[0];
        int rmax = arr[r];
        int total = 0;
        while(l<r){
            if(lmax<rmax){
                l++;
                lmax = Math.max(lmax, arr[l]);
                total += (lmax - arr[l]);
            }else{
                r--;
                rmax = Math.max(rmax, arr[r]);
                total += (rmax - arr[r]);
            }
        }
        return total;
    }
    public static void main(String args[]){
        int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(collect(arr));
    }
}