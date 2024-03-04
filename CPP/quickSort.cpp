#include <iostream>
using namespace std;

void quickSort(int arr[], int start, int end) {
    if(start >= end) {
        return;
    }
    int pivot = arr[end], ind = start, temp;
    for(int i = start; i <= end; i++) {
        if(arr[i] <= pivot) {
            temp = arr[ind];
            arr[ind] = arr[i];
            arr[i] = temp;
            ind++;
        }
    }
    ind--;
    quickSort(arr, start, ind-1);
    quickSort(arr, ind+1, end);
}

int main() {
    int arr[] = {6, 1 ,3 ,4, 2 ,4};
    quickSort(arr, 0, 5);

    for(int i = 0; i < 6; i++) {
        cout << arr[i] << "  ";
    }
    cout << endl;
}