import java.util.*;

public class java1 {
    public static void main(String main[]) {
        // int nums[] = {41,33,29,33,35,26,47,24,18,28};
        int nums[] = {1,10,100,1000};

        System.out.println(minOperations(nums));
    }
    public static int myCode(int nums[]) {
        Arrays.sort(nums);

        //
        for(int i:nums) System.out.print(i + "  ");
        System.out.println();
        //

        int maxCount = -1, expect = nums[0] + 1;
        int count = 1, start = nums[0], starti = 0;
        int end = nums[0], endi = 0, temp = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == expect) {
                expect++;
                count++;
            }
            else {
                if(count > maxCount) {
                    maxCount = count;
                    starti = temp;
                    endi = i - 1;
                }
                temp = i;
                expect = nums[i] + 1;
                count = 1;
            }
        }
        System.out.println("starti - " + starti + " endi = " + endi);

        int total = 0;
        temp = nums[starti] - 1;
        count = 0;
        int limit = nums[starti] - starti;
        for(int i = starti - 1; i >= 0 && temp >= limit; i--) {
            if(nums[i] > temp) continue;
            while(temp >= limit && nums[i] != temp) {
                count++;
                temp--;
            }
            temp--;
        }
        total += count;

        temp = nums[endi] + 1;
        count = 0;
        limit = nums[endi] + (nums.length - 1 - endi);
        for(int i = endi + 1; i < nums.length; i++) {
            if(nums[i] < temp) continue;
            while(temp <= limit && nums[i] != temp) {
                temp++;
                count++;
            }
            temp++;
        }
        total += count;

        return total;
    }

    public static int minOperations(int[] nums) {
        Arrays.sort(nums);
        int count=Integer.MAX_VALUE,j=1,dup=0;
        int[] dupArr = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            System.out.println("for loop: " + i );
            while(j<nums.length&&nums[j]<=nums[i]+nums.length-1) {
                System.out.println("while: " + j + " dup - " + dup);
                int abc = (nums[i]+nums.length-1);
                System.out.println(nums[j] + " <= " + abc);
                if(nums[j]==nums[j-1]) ++dup;
                dupArr[j]=dup;
                j++;
            }
            count = Math.min(count, i+(nums.length-j)+dup-dupArr[i]);
            System.out.println(count + "\n");
        }
        for(int i:nums) System.out.print(i + "  ");
        System.out.println();
        for(int i:dupArr) System.out.print(i + "  ");
        System.out.println();
        return count;
    }
	
}

