public class Rain_water {
    public static void main(String args[]){
        int height[] = {4, 2, 0, 6, 3, 2, 5};
        int len = height.length;
        int left_max[] = new int[len];
        int right_max[] = new int[len];
        left_max[0] = height[0];
        for(int i=1; i<len; i++){
            left_max[i] = left_max[i-1]>height[i]? left_max[i-1]: height[i];
            // Here, Math.max(,) can also be used.
        }
        right_max[len-1] = height[len-1];
        for(int i=len-2; i>=0; i--){
            right_max[i] = right_max[i+1]>height[i]? right_max[i+1]: height[i];
        }
        int total = 0;
        for(int i=0; i<len; i++){
            int min_bound = left_max[i]<right_max[i]?left_max[i]:right_max[i];
            total += (min_bound-height[i]);
        }
        System.out.println("Total water is " + total);
    }
}