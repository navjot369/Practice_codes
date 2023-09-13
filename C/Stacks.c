#include <stdio.h>
#include <limits.h>

int main() {
    int arr[] = {3, 4, 4, 2, 10, 8, -7};
    int len = sizeof(arr) / sizeof(arr[0]);

    int max1 = INT_MIN, max2 = INT_MIN, max3 = INT_MIN;
    int min1 = INT_MAX, min2 = INT_MAX;

    for(int i = 0; i < len; i++) {
        if(arr[i] > max1) {
            max3 = max2;
            max2 = max1; 
            max1 = arr[i];
        }
        else if(arr[i] > max2) {
            max3 = max2;
            max2 = arr[i];
        }
        else if(arr[i] > max3) {
            max3 = arr[i];
        }
        
        if(arr[i] < min1) {
            min2 = min1;
            min1 = arr[i];
        }
        else if(arr[i] < min2){
            min2 = arr[i];
        }
    }
    int pro1 = min1 * min2 * max1;
    int pro2 = max1 * max2 * max3;
}