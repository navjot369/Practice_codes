#include <iostream>
using namespace std;

void mergeSort(int[], int, int);

int main() {
    int arr[6] = {6, 2, 3 ,5, 4, 1};
    mergeSort(arr, 0, 5);

    for(int i = 0; i < 6; i++) {
        cout << arr[i] << ", ";
    }
    cout << endl;
}

void mergeSort(int arr[], int start, int end) {
    if(start >= end) {
        return;
    }
    int mid = start + (end-start)/2;
    mergeSort(arr, start, mid);
    mergeSort(arr, mid+1, end);
    
    int len = end-start+1;
    int ind = 0, i = start, j = mid+1;
    int temp[len];
    while(i <= mid && j <= end) {
        if(arr[i] <= arr[j]) {
            temp[ind++] = arr[i++];
        }
        else{
            temp[ind++] = arr[j++];
        }
    }
    while(i <= mid) {
        temp[ind++] = arr[i++];
    }
    while(j <= end) {
        temp[ind++] = arr[j++];
    }
    for(int i = 0, j = start; i < len; i++, j++) {
        arr[j] = temp[i];
    }
}