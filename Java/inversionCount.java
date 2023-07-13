public class inversionCount {
    public static int merge(int arr[], int si, int mid, int ei) {
        int ans = 0;
        int temp[] = new int[ei - si + 1];
        int i = si, j = mid + 1, k = 0;

        while(i <= mid && j <= ei){
            if(arr[i] <= arr[j]){
                temp[k] = arr[i];
                i++;
            }
            else{
                temp[k] = arr[j];
                ans += mid - i +1;
                j++;
            }
            k++;
        }
        while(i <= mid){
            temp[k] = arr[i];
            i++;
            k++;
        }
        while(j <= ei){
            temp[k] = arr[j];
            j++;
            k++;
        }
        for(int ind = si, itemp = 0; itemp < k; ind++, itemp++){
            arr[ind] = temp[itemp];
        }
        return ans;
    }

    public static int getCount(int arr[], int left, int right) {
        int ans = 0;
        if(right > left) {
            int mid = left + (right - left)/2;
            ans = getCount(arr, left, mid);
            ans += getCount(arr, mid + 1, right);
            ans += merge(arr, left, mid, right);
        }
        return ans;
    }
    public static void main(String args[]) {
        int arr[] = {2, 4, 1, 5, 3};
        System.out.println(getCount(arr, 0, arr.length - 1));
    }
}
