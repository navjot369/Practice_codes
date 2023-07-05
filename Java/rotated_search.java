public class rotated_search {
    public static int min_search(int arr[]){
        /*Progrram to find the minumum number using binary search */
        int left = 0;
        int right = arr.length - 1;
        while(left<=right){
            int mid = (left+right)/2;
            if(mid>0 && arr[mid-1] > arr[mid]){
                return mid;
            }
            if(arr[mid] >= arr[left] && arr[mid] > arr[right]){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return left;
    }
    public static int bin_search(int arr[], int left, int right, int target){
        //function implementing simple binary search algorithm.
        while(left<=right){
            int mid = left + (right-left)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] < target){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return -1;
    }
    public static int search(int arr[], int target){
        // Will find the pivot index and will provide call binary search
        // function with right arguments.
        int mini = min_search(arr);
        if(arr[mini] <= target && target <= arr[arr.length-1]){
            return bin_search(arr, mini, arr.length-1, target);
        }
        else{
            return bin_search(arr, 0, mini-1, target);
        }
    }
    public static void main(String args[]){
        int arr[] = {4, 5, 6, 0, 1, 2, 3};
        System.out.println(search(arr, 0));
    }
}
