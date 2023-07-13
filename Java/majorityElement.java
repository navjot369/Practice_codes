public class majorityElement {
    public static int countEle(int arr[], int ele, int si, int ei){
        int count = 0;
        for(int i = si; i <= ei; i++){
            if(arr[i] == ele) {
                count++;
            }
        }
        return count;
    }

    public static int majorityEle(int arr[], int si, int ei) {
        if(si == ei){
            return arr[si];
        }

        int mid = si + (ei - si)/2;
        int left = majorityEle(arr, si, mid);
        int right = majorityEle(arr, mid + 1, ei);

        if(left == right){
            return left;
        }

        int leftcount = countEle(arr, left, si , ei);
        int rightcount = countEle(arr, right, si, ei);
        return leftcount > rightcount ? left : right;
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 2, 2, 3, 3};
        System.out.println(majorityEle(arr, 0, arr.length - 1));
    }
}
