#include<stdio.h>
int main() {
	int n;
	scanf("%d", &n);
	int arr[n];
	for(int i = 0;i < n; i++) {
	    scanf("%d", &arr[i]);
	}
	int idx = 0;
	for(int i = 0;i < n; i++) {
	    if(arr[i] % 10 != 0) {
	        printf("%d %d \n", i, arr[i]);
	        int temp = arr[i];
	        int tempi = i;
	        while(tempi > idx) {
	            arr[tempi] = arr[tempi - 1];
	            tempi--;
	        }
	        arr[idx] = temp;
	        idx++;
	    }
	}
	for(int i = 0; i < n; i++) {
	    printf("%d ", arr[i]);
	}
	return 0;
};